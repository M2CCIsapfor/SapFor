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

public class testClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * test connexion
		 */

		String cle=new String();

		// Get access to the service object
		ClientConfig config = new DefaultClientConfig();		
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI()+"/login?login=555&password=ch");

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
		 * test affichage des sessions auxquelles un apprenant à candidater avant annulation
		 */
	

		//Affichage Candidature
		List<SessionT> listeSessionCandidatAvant=new ArrayList<SessionT>();
		WebResource service6=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatAvant=service6.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Liste des sessions où je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatAvant);
		System.err.println("******************************************");
		
		
		/**
		 * test Liste des agents qui ont candidater à la session en tant que apprenant :
		 */
		
		List<AgentT> listeAgent=new ArrayList<AgentT>();
		int i=listeSessionAccessibleCandidat.get(1).getId();
		WebResource service9=client.resource(getBaseURI()+"/"+cle+"/session/"+i+"/candidats?role=ApprenantCandidat");
		listeAgent=service9.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AgentT>>(){});
		System.err.println("Liste des agents qui ont candidater à la session en tant que apprenant :");
		afficherAgent(listeAgent);
		System.err.println("******************************************");
		

		
		/**
		 * test suppression d'une candidature par un candidat
		 */
		int ssup=listeSessionAccessibleCandidat.get(1).getId();	
		WebResource service7=client.resource(getBaseURI()+"/"+cle+"/delete?session="+ssup);
		service7.accept(MediaType.APPLICATION_JSON).delete();
		
		
		
		/**
		 * test affichage des sessions auxquelles un apprenant à candidater après annulation
		 */
		
		List<SessionT> listeSessionCandidatApres=new ArrayList<SessionT>();
		WebResource service8=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatApres=service8.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>(){});
		System.err.println("Après une annulation : Liste des sessions où je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatApres);
		System.err.println("******************************************");
		
		

		
		
		/**
		 * Test Liste des stages où l'agent est directeur
		 */
		
		List<Stage> listeStage=new ArrayList<Stage>();
		
		WebResource service10=client.resource(getBaseURI()+"/"+cle+"/directeur?role=directeur");
		listeStage=service10.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Stage>>(){});
		System.err.println("Liste des stages où je suis directeur :");
		afficherStage(listeStage);
		System.err.println("******************************************");
	
	}
	
	
	

	private static void afficher(String cle) {
		System.err.println("clé à  rechercher : " +cle);
	}

	private static void afficherSessionAccessible(List<SessionT> lsession){
		for(SessionT s:lsession){
			System.err.println("*"+s.getCliUv().getNom()+" idSession="+s.getId());}
	}
	private static void afficherAgent(List<AgentT> lAgent){
		for(AgentT s:lAgent){
			System.err.println("*"+s.getMatricule());}
	}
	private static void afficherStage(List<Stage> lStage){
		for(Stage s:lStage){
			System.err.println("*"+s.getTitle());}
	}

	private static java.net.URI getBaseURI() {
		java.net.URI uri =
				UriBuilder.fromUri("http://localhost:8080/s").build();
		return uri;
	}
	
}
