
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

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
		WebResource service = client.resource(getBaseURI()+"/login?login=111&password=ma");
		
		// Get all products
		
		cle = service.accept(MediaType.APPLICATION_JSON).get(new GenericType<String>(){});            

		afficher(cle);
		System.err.println("******************************************");
		
		/**********************************
		 test session accessible par l'apprenant
		***********************************/
		List<Session> listeSessionAccessibleCandidat=new ArrayList();
		WebResource service2=client.resource(getBaseURI()+"/"+cle+"/sessions?role=apprenant");
		listeSessionAccessibleCandidat=service2.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Session>>(){});
		System.err.println("Liste des sessions accessibles en tant qu'apprenant :");
		afficherSessionAccessible(listeSessionAccessibleCandidat);
		System.err.println("******************************************");
		/**********************************
		 test session accessible par le formateur
		***********************************/
		
		List<Session> listeSessionAccessibleFormateur=new ArrayList();
		WebResource service3=client.resource(getBaseURI()+"/"+cle+"/sessions?role=formateur");
		listeSessionAccessibleFormateur=service3.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Session>>(){});
		System.err.println("Liste des sessions accessibles en tant que formateur :");
		afficherSessionAccessible(listeSessionAccessibleFormateur);
		System.err.println("******************************************");
	}


private static void afficher(String cle) {
	
		System.err.println("clé à rechercher :" +cle);
		
		
	
}

private static void afficherSessionAccessible(List<Session> lsession){
	for(Session s:lsession){
	System.err.println("*"+s.getUv().getNom());}
}

private static java.net.URI getBaseURI() {
	java.net.URI uri =
	 UriBuilder.fromUri("http://localhost:8080/rest").build();
	return uri;
}
}