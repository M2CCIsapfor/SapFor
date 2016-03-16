package ClientCAOS2016;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import model.Agent;
import model.Session;
import model.UV;

public class AccesConnexion {

	private String idconnexion;

	public static final ClientConfig config = new DefaultClientConfig();

	public static final Client client = Client.create(config);
	public static WebResource service = client.resource(getBaseURI());

	public AccesConnexion() {

	}

	public AccesConnexion(String idconnexion) {
		this.idconnexion = idconnexion;
	}

	
	public String Authentification(String login, String mdp) {
		String logger = null;
		logger = service.path("login?login=" + login + "&password=" + mdp).accept(MediaType.TEXT_PLAIN).get(String.class);
		return logger;
	}

	public List<Session> getListeSessions(String referent) {
		List<Session> listeS = new ArrayList<Session>();
		listeS = service.path(idconnexion + "/" + referent).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Session>>() {
				});

		return listeS;
	}

	public List<Agent> getListeAgents(String referent) {
		List<Agent> listeA = new ArrayList<Agent>();
		listeA = service.path(idconnexion + "/" + referent).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Agent>>() {
				});

		return listeA;
	}

	public List<UV> getListeUV(String referent) {
		List<UV> listeUV = new ArrayList<UV>();
		listeUV = service.path(referent).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<UV>>() {
				});
		return listeUV;
	}

	private static void afficher(List<UV> listeuv) {
		for (UV uv : listeuv) {
			System.err.println(uv.getNom());
		}
	}

	private static URI getBaseURI() {
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTTest/rest/UV").build();
		return uri;
	}

	public static void main(String[] args) {
		
		AccesConnexion ac = new AccesConnexion();
		afficher(ac.getListeUV("census"));
		System.out.println(ac.Authentification("test", "toto")); 
	}

}
