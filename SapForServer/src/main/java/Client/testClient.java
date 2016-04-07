package Client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de test de connexion avec le serveur
 * @author Equipe Serveur
 *
 */
public class testClient {

	/**
	 * Main permettant de tester la connexion Serveur
	 * @param args
	 */
	public static void main(String[] args) {

		String cle=new String();

		// Get access to the service object
		ClientConfig config = new DefaultClientConfig();		
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI()+"/login?login=666&password=ju");

		// Get all products
		cle = service.accept(MediaType.APPLICATION_JSON).get(new GenericType<String>(){});            

		afficher(cle);
		System.err.println("******************************************");

		
		/**
		 * test session accessible par l'apprenant
		 */
		List<SessionT> listeSessionAccessibleCandidat=new ArrayList<SessionT>();
		WebResource service2=client.resource(getBaseURI()+"/"+cle+"/sessionsAcc?role=apprenant");
		listeSessionAccessibleCandidat=service2.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Liste des sessions accessibles en tant qu'apprenant :");
		afficherSessionAccessible(listeSessionAccessibleCandidat);
		System.err.println("******************************************");
		
		
		/**
		 *test session accessible par le formateur
		 */
		List<SessionT> listeSessionAccessibleFormateur=new ArrayList<SessionT>();
		WebResource service3=client.resource(getBaseURI()+"/"+cle+"/sessionsAcc?role=formateur");
		listeSessionAccessibleFormateur=service3.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Liste des sessions accessibles en tant que formateur :");
		afficherSessionAccessible(listeSessionAccessibleFormateur);
		System.err.println("******************************************");
		
		
		/**
		 * test ajout d'une candidature par un candidat apprenant
		 */
		int id=listeSessionAccessibleCandidat.get(1).getId();
		WebResource service5=client.resource(getBaseURI()+"/"+cle+"/submit?role=Apprenant&session="+id+"&prio=priorite");
		service5.accept(MediaType.APPLICATION_JSON).post();
		System.err.println("******************************************");
		

		/**
		 * test affichage des sessions auxquelles un apprenant � candidater avant annulation
		 */
		//Affichage Candidature
		List<SessionT> listeSessionCandidatAvant=new ArrayList<SessionT>();
		WebResource service6=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatAvant=service6.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Liste des sessions o� je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatAvant);
		System.err.println("******************************************");
	
		
		/**
		 * test suppression d'une candidature par un candidat
		 */
		int ssup=listeSessionAccessibleCandidat.get(1).getId();	
		WebResource service7=client.resource(getBaseURI()+"/"+cle+"/delete?session="+ssup);
		service7.accept(MediaType.APPLICATION_JSON).delete();
		
		/**
		 * test affichage des sessions auxquelles un apprenant � candidater apr�s annulation
		 */
		List<SessionT> listeSessionCandidatApres=new ArrayList<SessionT>();
		WebResource service8=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatApres=service8.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Apr�s une annulation : Liste des sessions o� je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatApres);
		System.err.println("******************************************");
		
	
		/**
		 * En tant que directeur :
		 * Test Liste des stages o� l'agent est directeur
		 */
		List<Stage> listeStage=new ArrayList<Stage>();
		
		WebResource service10=client.resource(getBaseURI()+"/"+cle+"/directeur?role=directeur");
		listeStage=service10.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Stage>>(){});
		System.err.println("Liste des stages o� je suis directeur :");
		afficherStage(listeStage);
		System.err.println("******************************************");
	
	
		/**
		 * En tant que directeur
		 * test Liste des agents qui ont candidater � la session en tant que apprenant :
		 */
		List<AgentT> listeAgent=new ArrayList<AgentT>();
		int i=listeStage.get(0).getCliListeSessions().get(0).getId();
		WebResource service9=client.resource(getBaseURI()+"/"+cle+"/session/"+i+"/candidats?role=ApprenantCandidat");
		listeAgent=service9.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AgentT>>(){});
		System.err.println("Liste des agents qui ont candidater � la session en tant que apprenant :");
		afficherAgent(listeAgent);
		System.err.println("******************************************");
		
		/**
		 * Le directeur passe un candidat du statut candidat au statut inscrit
		 */
		/*int code=listeStage.get(0).getCliListeSessions().get(0).getId();
		String matricule=listeAgent.get(0).getMatricule();
		WebResource service11=client.resource(getBaseURI()+"/"+cle+"/session/"+code+"/"+matricule);
		service11.accept(MediaType.APPLICATION_JSON).post();
		System.err.println("******************************************");
		
		List<AgentT> listeAgentInscrit=new ArrayList<AgentT>();
		WebResource service12=client.resource(getBaseURI()+"/"+cle+"/session/"+i+"/candidats?role=ApprenantInscrit");
		listeAgentInscrit=service12.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AgentT>>(){});
		System.err.println("Liste des agents qui sont inscrits � la session :");
		afficherAgent(listeAgentInscrit);
		System.err.println("******************************************");*/
	
	}
	
	/**
	 * Affichage de la cle a rechercher
	 * @param cle Cle a rechercher
	 */
	private static void afficher(String cle) {
		System.err.println("cle a rechercher : " +cle);
	}

	/**
	 * Affichage de la liste des Sessions accessibles
	 * @param lsession Liste des Sessions accessibles
	 */
	private static void afficherSessionAccessible(List<SessionT> lsession){
		for(SessionT s:lsession){
			System.err.println("*"+s.getCliUv().getNom()+" idSession="+s.getId());}
	}
	
	/**
	 * Affichage de la liste des Agents
	 * @param lAgent Liste des Agents
	 */
	private static void afficherAgent(List<AgentT> lAgent){
		for(AgentT s:lAgent){
			System.err.println("*"+s.getMatricule());}
	}

	/**
	 * Affichage de la liste des Stages
	 * @param lStage Liste des Stages
	 */
	private static void afficherStage(List<Stage> lStage){
		for(Stage s:lStage){
			System.err.println("*"+s.getTitle());
			System.err.println("**Session du stage :");
			for(SessionT session: s.getCliListeSessions()){
				System.err.println("***"+session.getId());
			}
		}
	}

	/**
	 * Construction de l'URL de connexion
	 * @return URL de connexion
	 */
	private static java.net.URI getBaseURI() {
		java.net.URI uri =
				UriBuilder.fromUri("http://localhost:8080/s").build();
		return uri;
	}
	
}