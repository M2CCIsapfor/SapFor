package Server;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.spi.resource.Singleton;

import Client.CliSession;


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
	public List<Client.ImpCliSession> SessionAccessibles(@PathParam("cleHashage") String cle, @QueryParam("role") String rol){
		List<Client.ImpCliSession> sess=new ArrayList<Client.ImpCliSession>();
		Agent agent=rechercheAgent(cle,donnees.lAgent);

		//Liste des sessions accessibles en tant qu'apprenant
		if (rol.equals("apprenant")){
			for(Session s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getUv())!=true){
					Client.ImpCliSession nouvelle=new Client.ImpCliSession();
					nouvelle.setLieu(s.getLieu());
					nouvelle.setUv(new CliUV(s.getUv().getId(),s.getUv().getNom()));
					nouvelle.setDate(s.getDates());
					sess.add(nouvelle);}
			}
			return sess;
		}
		//Liste des sessions accessibles en tant que formateur
		else if (rol.equals("formateur")){
			for(Session s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getUv())==true){
					Client.ImpCliSession nouvelle=new Client.ImpCliSession();
					nouvelle.setLieu(s.getLieu());
					nouvelle.setUv(new CliUV(s.getUv().getId(),s.getUv().getNom()));
					nouvelle.setDate(s.getDates());
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
	public Agent rechercheAgent(String cle, List<Agent> listeAgent){
		for(Agent a:listeAgent){
			if(a.getCleHashage().equals(cle)==true){
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
	public boolean rechercheUVrequis(Agent agent, Session session){
		boolean requisAcquis=true;
		for(UV uvprerequis:session.getUv().getListeUV()){
			if(agent.getAptitude().contains(uvprerequis)==false){requisAcquis=false;}
		}
		return requisAcquis;
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
		for(Server.Session ss : donnees.lSession) {
			if(clSess.getUv().equals(ss.getUv()) && clSess.getLieu().equals(ss.getLieu()) && clSess.getDate().equals(ss.getDates())) {
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
