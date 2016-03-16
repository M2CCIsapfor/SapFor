package Server;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.resource.Singleton;

import Client.AgentT;
import Client.SessionT;
import Client.Stage;
import Client.UV;


@Singleton
@Path("{cleHashage}")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SessionManager {

	Data donnees=new Data();

	/**
	 * Methode de test
	 * @return "Hello"
	 */
	@GET
	@Path("/simple")
	public String simple(){
		return "Hello";
	}


	/**
	 * Fonction d'affichage de la liste des Sessions accessible pour un Agent
	 * @param cle : Clé de hashage fourni à l'agent lors de la connexion
	 * @param rol : Role de l'Agent : Apprenant ou Formateur
	 * @return La liste des Sessions qui sont accessible à l'agent connecté
	 */
	@GET
	@Path("/sessionsAcc")
	public List<SessionT> SessionAccessibles(@PathParam("cleHashage") String cle, @QueryParam("role") String rol){
		List<SessionT> sess=new ArrayList<SessionT>();
		SerAgent agent = rechercheAgent(cle, donnees.lAgent);

		//Liste des sessions accessibles en tant qu'apprenant
		if (rol.equals("apprenant")){
			for(SerSession s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getSerUv())!=true){
					SessionT nouvelle=new SessionT();
					nouvelle.setId(s.getId());
					nouvelle.setLieu(s.getLieu());
					nouvelle.setCliUv(new UV(s.getSerUv().getNumero(),s.getSerUv().getNom()));
					nouvelle.setDate(s.getDate());
					sess.add(nouvelle);}
			}
			return sess;
		}
		//Liste des sessions accessibles en tant que formateur
		else if (rol.equals("formateur")){
			for(SerSession s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getSerUv())==true){
					SessionT nouvelle=new SessionT();
					nouvelle.setId(s.getId());
					nouvelle.setLieu(s.getLieu());
					nouvelle.setCliUv(new UV(s.getSerUv().getNumero(),s.getSerUv().getNom()));
					nouvelle.setDate(s.getDate());
					sess.add(nouvelle);
				}
			}
			return sess;	
		}
		else {return null;}
	}

	/**
	 * Fonction d'affichage de la liste des Sessions o� l'agent est inscrit
	 * @param cle : Clé de hashage fourni à l'agent lors de la connexion
	 * @param rol : Role de l'Agent : ApprenantCandidat ou FormateurCandidat ou ApprenantInscrit ou Formateur Inscrit
	 * @return La liste des Sessions o� l'agent est inscrit suivant son role
	 */

@GET
	@Path("/sessions")
	public synchronized List<SessionT> CandidatSession(@PathParam("cleHashage") String cle, @QueryParam("role") String rol){

		List<SessionT> lSessionCand=new ArrayList<SessionT>();
		SerAgent agent=rechercheAgent(cle, donnees.lAgent);

		for(SerSession s:donnees.lSession){
			if(rol.equals("ApprenantCandidat")){
				if(s.getCandidatsAp().contains(agent)){
					SessionT nouvelle=new SessionT(s.getId(),new UV(s.getUv().getNumero(),s.getUv().getNom()), s.getDate(), s.getLieu(), s.getNbMin(), s.getNbMax(), s.getNbFormateur());
					lSessionCand.add(nouvelle);
				}
			}
			else if(rol.equals("FormateurCandidat")){
				if(s.getCandidatsFo().contains(agent)){
					SessionT nouvelle=new SessionT(s.getId(),new UV(s.getUv().getNumero(),s.getUv().getNom()), s.getDate(), s.getLieu(), s.getNbMin(), s.getNbMax(), s.getNbFormateur());
					lSessionCand.add(nouvelle);
				}
			}
			else if(rol.equals("ApprenantInscrit")){
				if(s.getApprenants().contains(agent)){
					SessionT nouvelle=new SessionT(s.getId(),new UV(s.getUv().getNumero(),s.getUv().getNom()), s.getDate(), s.getLieu(), s.getNbMin(), s.getNbMax(), s.getNbFormateur());
					lSessionCand.add(nouvelle);
				}
			}

			else if(rol.equals("FormateurInscrit")){
				if(s.getFormateurs().contains(agent)){
					SessionT nouvelle=new SessionT(s.getId(),new UV(s.getUv().getNumero(),s.getUv().getNom()), s.getDate(), s.getLieu(), s.getNbMin(), s.getNbMax(), s.getNbFormateur());
					lSessionCand.add(nouvelle);
				}
			}
		}
		return lSessionCand;
	}

	/**
	 * Recherche d'un Agent dans une liste d'Agent à partir d'une clef de hashage 
	 * @param cle : Clé de Hashage fourni à l'Agent lors de sa connexion
	 * @param listeAgent : Liste dans laquelle l'Agent est recherché
	 * @return L'agent correspondant à la clé de hashage
	 */
	public SerAgent rechercheAgent(String cle, List<SerAgent> listeAgent){
		for(SerAgent a:listeAgent){
			if(a.getCleHashage().equals(cle)==true){
				return a;
			}
		}		
		return null;
	}

	// RECHERCHE AGENT PAR RAPPORT A SON MATRICULE
	public SerAgent rechercheAgentMatricule(String matricule, List<SerAgent> listeAgent){
		for(SerAgent a:listeAgent){
			if(a.getMatricule().equals(matricule)==true){
				return a;
			}
		}		
		return null;
	}

	/**
	 * Recherche si l'agent possède les UVs requis pour une session 
	 * @param agent
	 * @param session
	 * @return Rend true si tous les UV requis pour une sessions sont validés par l'agent
	 */
	public boolean rechercheUVrequis(SerAgent agent, SerSession session){
		boolean requisAcquis=true;
		for(SerUV uvprerequis : session.getSerUv().getPrerequis()){
			if(agent.getAptitude().contains(uvprerequis)==false){requisAcquis=false;}
		}
		return requisAcquis;
	}


	/**
	 * En tant que directeur:
	 * Ajout un nouvel agent parmi les  participants à la session en tant qu'apprenant ou formateur
	 * 
	 * @param cle
	 * @param codeS
	 * @return Status sur la validation de la candidature
	 */
	@POST
	@Path ("/session/{codeSession}/{matricule}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//	public Response valideCandidats( @PathParam("cleHashage") String cle, @PathParam("CodeSession") int codeS ) {
	public Response valideCandidats( @PathParam("matricule") String matri, @PathParam("CodeSession") int codeS ) {
		SerAgent AgentApAValider;
		SerSession SelectSession = rechercheSession(codeS, donnees.lSession);
		boolean youAreTheDirector = false;

		for ( SerStage stge:donnees.lStage ){
			if ( rechercheSession( codeS, stge.getListeSerSessions() ) != null ) { 
				youAreTheDirector = true; 
			}
		}

		if (youAreTheDirector) {

			if ( rechercheAgentMatricule(matri, SelectSession.getCandidatsAp()) != null ) {
				AgentApAValider = rechercheAgentMatricule(matri, SelectSession.getCandidatsAp());
				SelectSession.validerApprenant(AgentApAValider);
				return Response.status(Status.ACCEPTED).entity(AgentApAValider).build();

			} else if ( rechercheAgentMatricule(matri, SelectSession.getCandidatsFo()) != null ){
				AgentApAValider = rechercheAgentMatricule(matri , SelectSession.getCandidatsFo());
				SelectSession.validerFormateur(AgentApAValider);
				return Response.status(Status.ACCEPTED).entity(AgentApAValider).build();

			} else {
				AgentApAValider = null;
				return Response.status(Status.NOT_FOUND).entity(AgentApAValider).build();
			}
		} else {
			AgentApAValider = null;
			return Response.status(Status.UNAUTHORIZED).entity(AgentApAValider).build();
		}

	}


	/**
	 * En tant que Directeur:
	 * Retourne la liste des candidats à une session en tant que : 
	 * ApprenantCandidat, FormateurCandidat, ApprenantInscrit ou FormateurInscrit
	 * @param codeS
	 * @param rol
	 * @return ListeCandidat
	 */
	@GET
	@Path("/session/{codeSession}/candidats/")
	public List<AgentT> ListeAgentSession(@PathParam("codeSession") int codeS, @QueryParam("role") String rol){
		List<AgentT> ListeCandidat=new ArrayList<AgentT>();
		SerSession SelectSession = rechercheSession(codeS,donnees.lSession);
		boolean youAreTheDirector = false;

		for ( SerStage stge:donnees.lStage ){
			if ( rechercheSession( codeS, stge.getListeSerSessions() ) != null ) { 
				youAreTheDirector = true; 
			}
		}

		if (youAreTheDirector) {

			if ( rol.equals("ApprenantCandidat") ){
				for( SerAgent sA:SelectSession.getCandidatsAp() ){
					AgentT cA = new AgentT(sA.getMatricule(), sA.getNom(), sA.getPrenom());
					ListeCandidat.add(cA);
				}
			}
			else if ( rol.equals("FormateurCandidat") ){
				for( SerAgent sA:SelectSession.getCandidatsFo() ){
					AgentT cA = new AgentT(sA.getMatricule(), sA.getNom(), sA.getPrenom());
					ListeCandidat.add(cA);
				}
			}
			else if ( rol.equals("ApprenantInscrit") ){
				for( SerAgent sA:SelectSession.getApprenants() ){
					AgentT cA = new AgentT(sA.getMatricule(), sA.getNom(), sA.getPrenom());
					ListeCandidat.add(cA);
				}
			}
			else if ( rol.equals("ApprenantInscrit") ){
				for( SerAgent sA:SelectSession.getFormateurs() ){
					AgentT cA = new AgentT(sA.getMatricule(), sA.getNom(), sA.getPrenom());
					ListeCandidat.add(cA);
				}
			}
			else {
				ListeCandidat = null;
			}

			return ListeCandidat;

		} else {
			return null;
		}

	} //ListeAgentSession



	/**
	 * FONCTION : Recherche d'un Session dans une liste de session à partir d'un CodeSession 
	 * @param CodeSession : Id session fourni à la session lors de sa connexion
	 * @param listeSession : Liste dans laquelle la session est recherché
	 * @return La session correspondant à un code de session
	 */
	public SerSession rechercheSession( int CodeSession, List<SerSession> listeSession ){
		for(SerSession s:listeSession){
			if( s.getId() == CodeSession ){
				return s;
			}
		}		
		return null;
	}






	/**
	 * Suppression ou demande de suppression de la candidature
	 * d'un agent à une session
	 * @param ImpCliSession
	 * @param String : Clé de hashage
	 */
	@DELETE
	@Path("/delete")
	public synchronized void annuleCandidat(@PathParam("cleHashage") String cle, @QueryParam("session") int idSession) {
		System.err.println("id="+idSession);

		SerAgent agent=new SerAgent();
		SerSession ss=rechercheSession(idSession,donnees.lSession);
		agent=rechercheAgent(cle, donnees.lAgent);
		if(ss!=null){
			if((rechercheSession(idSession,donnees.lSession).getCandidatsAp().contains(agent))) {
				rechercheSession(idSession,donnees.lSession).getCandidatsAp().remove(agent);
			}
			else if(rechercheSession(idSession,donnees.lSession).getCandidatsFo().contains(agent)) {
				rechercheSession(idSession,donnees.lSession).getCandidatsFo().remove(agent);
			}
			else if(rechercheSession(idSession,donnees.lSession).getApprenants().contains(agent)) {
				rechercheSession(idSession,donnees.lSession).getApprenants().remove(agent);
			}
			else if(rechercheSession(idSession,donnees.lSession).getFormateurs().contains(agent)) {
				rechercheSession(idSession,donnees.lSession).getFormateurs().remove(agent);
			}				

		}


	}
	/**
	 * @param cle
	 * @param rol
	 * @return Liste des Stages pour lesquelles l'agent connect� est directeur
	 */
	@GET
	@Path("/directeur")
	public List<Stage> ListeStageDirecteur(@PathParam("cleHashage") String cle, @QueryParam("role") String rol) {
		List<Stage> listeStage=new ArrayList<Stage>();
		if(rol.equals("directeur")){
		for(SerStage stage:donnees.lStage){
			if(stage.getDirecteurSer().getCleHashage().equals(cle)){
				System.err.println("directeur");
				List<SessionT> listeSession=new ArrayList<SessionT>();
				for(SerSession s:stage.getListeSerSessions()){
					SessionT session=new SessionT(s.getId(),new UV(s.getUv().getNumero(),s.getUv().getNom()), s.getDate(), s.getLieu(), s.getNbMin(), s.getNbMax(), s.getNbFormateur());
					listeSession.add(session);
				}
				Stage nouveau=new Stage(stage.getTitle(),listeSession,new AgentT(stage.getDirecteurSer().getMatricule(),stage.getDirecteurSer().getNom(),stage.getDirecteurSer().getPrenom()));
			listeStage.add(nouveau);
			}
		}
		return listeStage;
		}
		else {return null;}
	}



	@POST
	@Path("/submit")
	public void ajouterSession(@PathParam("cleHashage")String cle,@QueryParam("role") String rol,
			@QueryParam("session") int code,@QueryParam("prio") String priorite){


		SerSession sers = rechercheSession(code, donnees.lSession);
		SerAgent agent = rechercheAgent(cle, donnees.lAgent);

		if(rol.equals("Apprenant")){ 
			sers.getCandidatsAp().add(agent);
		}
		else if(rol.equals("Formateur")){
			sers.getCandidatsFo().add(agent);			   
		}
	}

}
