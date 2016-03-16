package rslive;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.UV;

@Path("UV")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestServer {

	private List<UV> listeUV;

	public TestServer() {
		listeUV = new ArrayList<UV>();
		listeUV.add(new UV(1, "uv1"));
		listeUV.add(new UV(2, "uv2"));
		listeUV.add(new UV(3, "uv3"));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("auth")
	public String getInfo(@QueryParam("login") String login2, @QueryParam("password") String mdp2) {
		return "<html>Bonjour " + login2 + ", vous avez bien comme mot de passe : " + mdp2 + "</html>";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("pass")
	public String getString() {
		return "Bonjour";
	}

	@GET
	@Path("/census")
	@Produces(MediaType.APPLICATION_JSON)
	public synchronized List<UV> getListUVs() {
		return this.listeUV;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public synchronized UV addUV(UV uv) {
		this.listeUV.add(uv);
		return uv;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{numero}")
	public synchronized UV getUVByNum(@PathParam("numero") String num) {
		for (UV uv : listeUV) {
			if (uv.getNumero().toString().equals(num))
				return uv;
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find")
	public synchronized UV getUVByName(@QueryParam("nom") String name) {
		for (UV uv : listeUV) {
			if (uv.getNumero().equals(name))
				return uv;
		}
		return null;
	}

	@GET
	@Path("first")
	@Produces({ MediaType.APPLICATION_JSON })
	public synchronized UV premierUV() {
		if (!listeUV.isEmpty()) {
			return listeUV.get(0);
		} else {
			return null;
		}
	}

	@DELETE
	@Path("{numero}")
	public synchronized void deleteUV(@PathParam("numero") String num) {
		UV uvRemove = null;
		for (UV uv : listeUV) {
			if (uv.getNumero().toString().equals(num)) {
				uvRemove = uv;
				break;
			}
		}
		if (uvRemove != null) {
			listeUV.remove(uvRemove.getNumero());
		}
	}

}
