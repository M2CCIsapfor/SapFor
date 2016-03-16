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
		/**********************************
		 * *******test connexion***********
		 ***********************************/

		String cle=new String();

		// Get access to the service object
		ClientConfig config = new DefaultClientConfig();		
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI()+"/login?login=666&password=ju");

		// Get all products
		cle = service.accept(MediaType.APPLICATION_JSON).get(new GenericType<String>(){});            

		afficher(cle);
		System.err.println("******************************************");

		/**********************************
		 test session accessible par l'apprenant
		 ***********************************/
		List<CliSession> listeSessionAccessibleCandidat=new ArrayList<CliSession>();
		WebResource service2=client.resource(getBaseURI()+"/"+cle+"/sessionsAcc?role=apprenant");
		listeSessionAccessibleCandidat=service2.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CliSession>>(){});
		System.err.println("Liste des sessions accessibles en tant qu'apprenant :");
		afficherSessionAccessible(listeSessionAccessibleCandidat);
		System.err.println("******************************************");
		/**********************************
		 test session accessible par le formateur
		 ***********************************/

		List<CliSession> listeSessionAccessibleFormateur=new ArrayList<CliSession>();
		WebResource service3=client.resource(getBaseURI()+"/"+cle+"/sessionsAcc?role=formateur");
		listeSessionAccessibleFormateur=service3.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CliSession>>(){});
		System.err.println("Liste des sessions accessibles en tant que formateur :");
		afficherSessionAccessible(listeSessionAccessibleFormateur);
		System.err.println("******************************************");
		
		
		/**********************************
		 test ajout d'une candidature par un candidat apprenant
		 ***********************************/
		/*List<CliSession> listeSessionAccessibleFormateur=new ArrayList<CliSession>();
		WebResource service3=client.resource(getBaseURI()+"/"+cle+"/submit?role=Apprenant&session=idSession&prio=priorite");
		listeSessionAccessibleFormateur=service3.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CliSession>>(){});
		System.err.println("Liste des sessions accessibles en tant que formateur :");
		afficherSessionAccessible(listeSessionAccessibleFormateur);*/
		System.err.println("******************************************");
		
		
		
		

		/**********************************
		 test suppression d'une candidature par un candidat
		 ***********************************/

		//Affichage Candidature
		List<CliSession> listeSessionCandidatAvant=new ArrayList<CliSession>();
		WebResource service6=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatAvant=service6.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CliSession>>(){});
		System.err.println("Liste des sessions où je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatAvant);
		System.err.println("******************************************");
		
		
		int ssup=005;

		/*JSONObject inputJsonObj = new JSONObject();
		try {inputJsonObj.put("ssup", ssup);} 
			catch (JSONException e) {e.printStackTrace();}*/
		WebResource service7=client.resource(getBaseURI()+"/"+cle+"/delete?session="+ssup);
		service7.accept(MediaType.APPLICATION_JSON).delete();
		// Affichage Candidature
		
		List<CliSession> listeSessionCandidatApres=new ArrayList<CliSession>();
		WebResource service8=client.resource(getBaseURI()+"/"+cle+"/sessions?role=ApprenantCandidat");
		listeSessionCandidatApres=service8.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<CliSession>>(){});
		System.err.println("Liste des sessions où je suis inscrit :");
		afficherSessionAccessible(listeSessionCandidatApres);
		System.err.println("******************************************");
	}

	private static void afficher(String cle) {
		System.err.println("clÃ© Ã  rechercher : " +cle);
	}

	private static void afficherSessionAccessible(List<CliSession> lsession){
		for(CliSession s:lsession){
			System.err.println("*"+s.getCliUv().getNom()+" idSession="+s.getId());}
	}

	private static java.net.URI getBaseURI() {
		java.net.URI uri =
				UriBuilder.fromUri("http://localhost:8080/s").build();
		return uri;
	}
	
}