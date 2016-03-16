package Server;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.resource.Singleton;

import Client.CliAgent;
import Client.CliSession;
import Client.CliUV;


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
	@Path("/sessions")
	public List<CliSession> SessionAccessibles(@PathParam("cleHashage") String cle, @QueryParam("role") String rol){
		List<CliSession> sess=new ArrayList<CliSession>();
		SerAgent agent = rechercheAgent(cle, donnees.lAgent);

		//Liste des sessions accessibles en tant qu'apprenant
		if (rol.equals("apprenant")){
			for(SerSession s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getSerUv())!=true){
					CliSession nouvelle=new CliSession();
					nouvelle.setId(s.getId());
					nouvelle.setLieu(s.getLieu());
					nouvelle.setCliUv(new CliUV(s.getSerUv().getNumero(),s.getSerUv().getNom()));
					nouvelle.setDate(s.getDate());
					sess.add(nouvelle);}
			}
			return sess;
		}
		//Liste des sessions accessibles en tant que formateur
		else if (rol.equals("formateur")){
			for(SerSession s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getSerUv())==true){
					CliSession nouvelle=new CliSession();
					nouvelle.setId(s.getId());
					nouvelle.setLieu(s.getLieu());
					nouvelle.setCliUv(new CliUV(s.getSerUv().getNumero(),s.getSerUv().getNom()));
					nouvelle.setDate(s.getDate());
					sess.add(nouvelle);}
			}
			return sess;	
		}
		else {return null;}
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
	@PUT
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
	public List<CliAgent> ListeAgentSession(@PathParam("codeSession") int codeS, @QueryParam("role") String rol){
		List<CliAgent> ListeCandidat=new ArrayList<CliAgent>();
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
					ListeCandidat.add((CliAgent) sA);
					}
			}
			else if ( rol.equals("FormateurCandidat") ){
				for( SerAgent sA:SelectSession.getCandidatsFo() ){
					ListeCandidat.add((CliAgent) sA);
					}
			}
			else if ( rol.equals("ApprenantInscrit") ){
				for( SerAgent sA:SelectSession.getApprenants() ){
					ListeCandidat.add((CliAgent) sA);
					}
			}
			else if ( rol.equals("ApprenantInscrit") ){
				for( SerAgent sA:SelectSession.getFormateurs() ){
					ListeCandidat.add((CliAgent) sA);
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
	@Path("/suppression/{session}")
	public synchronized void annuleCandidat(@PathParam("cleHashage") String cle, @PathParam("session") CliSession clSess) {
		for(SerSession ss : donnees.lSession) {
			if(clSess.getId()==ss.getId()) {
				if(rechercheAgent(cle, ss.getCandidatsAp()) != null) {
					ss.removeAgent(rechercheAgent(cle, ss.getCandidatsAp()));
				}
				else if(rechercheAgent(cle, ss.getCandidatsFo()) != null) {
					ss.removeAgent(rechercheAgent(cle, ss.getCandidatsFo()));
				}
				else if(rechercheAgent(cle, ss.getApprenants()) != null) {
					ss.removeAgent(rechercheAgent(cle, ss.getApprenants()));
				}
				else if(rechercheAgent(cle, ss.getFormateurs()) != null) {
					ss.removeAgent(rechercheAgent(cle, ss.getApprenants()));
				}				
			}
		}
	}
}
