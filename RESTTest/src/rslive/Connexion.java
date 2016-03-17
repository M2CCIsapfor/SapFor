package rslive;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import model.Session;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 * User: Yannick Date: 2016-03 Time: 10:17
 */

public class Connexion {

	public void connect() {

		// Session nouvelleSession;
		List<Session> sessions;

		// Get access to the service object
		ClientConfig config = new DefaultClientConfig();

		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// Get all sessions

		sessions = service.path("sessions").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Session>>() {
		});
		afficher(sessions);
	}

	private static void afficher(List<Session> sessions) {
		for (Session p : sessions) {
			System.err.println(p.getLieu());
		}
	}

	private static URI getBaseURI() {
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTTest/rest/caos").build();
		return uri;
	}

	public static void main(String[] args) {
		Connexion c = new Connexion();
		c.connect();

	}
}