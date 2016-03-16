package rslive;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * User: Yannick Date: 2016-03 Time: 10:17
 */

public class ConnexLogin {
	public void connectLogin(String Login, String MotDePasse) {

		// Session nouvelleSession;
		String connexion;
		
		String log = "/login=" + Login + "&password=" + MotDePasse;
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		System.out.println(service.path("rest").path("census").accept(MediaType.TEXT_PLAIN).get(String.class));
		// Get connexion

		/*
		 * connexion =
		 * service.path(log).accept(MediaType.APPLICATION_JSON).get(String.class
		 * ); afficher(connexion);
		 */
	}

	private static void afficher(String connexion) {
		System.out.println(connexion);

	}

	private static URI getBaseURI() {
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTTest").build();
		return uri;
	}

	public static void main(String[] args) {
		ConnexLogin cl = new ConnexLogin();
		cl.connectLogin("momo", "mdp");
	}
	// http://localhost:8082/RESTTest/rest/caos/login?login=momo&password=mdp
}