package rslive;

/**
*
* @author 
* 		Ibrahima Toure
* 		Yannick Melin
* 		
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.AgentT;
import model.SessionT;
import model.Stage;
import model.UV;

@Path("census")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Census {

	private List<UV> listeUV;
	private List<SessionT> listeST;
	private List<AgentT> listAgentT;
	private List<Stage> listStage;
	private String cleHachage = new String();
	

	public Census() {

		listeUV = new ArrayList<UV>();
		listeUV.add(new UV(1, "uv1"));
		listeUV.add(new UV(2, "uv2"));
		listeUV.add(new UV(3, "uv3"));

		listeST = new ArrayList<SessionT>();
		listeST.add(new SessionT(1, new UV(1, "uv1"), new Date(), "Rennes", 5, 10, 2));
		listeST.add(new SessionT(2, new UV(2, "uv2"), new Date(), "Rennes", 5, 10, 2));
		listeST.add(new SessionT(3, new UV(2, "uv2"), new Date(), "Rennes", 5, 10, 2));

		listAgentT = new ArrayList<AgentT>();
		listAgentT.add(new AgentT("mat1", "Toure", "Ibra"));
		listAgentT.add(new AgentT("mat2", "Toure2", "Ibra2"));
		listAgentT.add(new AgentT("mat3", "Toure3", "Ibra3"));

		listStage = new ArrayList<Stage>();	
	
	
		
		
		
		
		
		
		
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/login")

	public String getInfo(@QueryParam("login") String login, @QueryParam("password") String mdp) {
		cleHachage = login + mdp;
		return cleHachage;

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	@Path("/agent")
	public synchronized List<UV> getListUVs() {
		return this.listeUV;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/sessionT")
	public synchronized List<SessionT> getListSessionsT() {
		return this.listeST;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/sessionsAcc")
	public synchronized List<SessionT> getListSessions(@QueryParam("role") String role) {
		return this.listeST;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/sessions")
	public synchronized List<SessionT> getListSessionsc(@QueryParam("role") String role) {
		return this.listeST;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/sessions/23/candidats")
	public synchronized List<AgentT> getListSession(@QueryParam("role") String role) {
		return this.listAgentT;
	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/agentT")
	public List<AgentT> getListAgentT() {
		return this.listAgentT;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cleHachage}/directeur")
	public List<Stage> getListStage() {
		return this.listStage;
	}
	
	
	
	
	
	
	
}
