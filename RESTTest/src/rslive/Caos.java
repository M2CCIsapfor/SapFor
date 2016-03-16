package rslive;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("caos")
public class Caos {
	private String logn;
	private String mdp;

	public Caos() {
		logn = "momo";
		mdp = "mdp";
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public void getCityInfoText(@QueryParam("login") String login2, @QueryParam("password") String mdp2) {
		System.out.println("Bonjour " + login2 + ", vous avez bien comme mot de passe : " + mdp2);
	}

}
