package sapfor.test;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Path("{cleHashage}")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SessionManager {
	
	Data donnees=new Data();

	@GET
	@Path("/simple")
	public String simple(){
		return "Hello Vicky";
	}
	
	
	@GET
	@Path("/sessions")
	public List<client.Session> SessionAccessibles(@PathParam("cleHashage") String cle, @QueryParam("role") String rol){
		List<client.Session> sess=new ArrayList<client.Session>();
		Agent agent=rechercheAgent(cle,donnees.lAgent);
		
		//Liste des sessions accessibles en tant qu'apprenant
		if (rol.equals("apprenant")){
		for(Session s:donnees.lSession){
			if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getUv())!=true){
				client.Session nouvelle=new client.Session();
				nouvelle.setLieu(s.getLieu());
				nouvelle.setUv(new client.UV(s.getUv().getId(),s.getUv().getNom()));
				nouvelle.setDate(s.getDates());
				sess.add(nouvelle);}
			}
		
		return sess;}
		//Liste des sessions accessibles en tant que formateur
		else if (rol.equals("formateur")){
			for(Session s:donnees.lSession){
				if(rechercheUVrequis(agent,s)==true && agent.getAptitude().contains(s.getUv())==true){
					client.Session nouvelle=new client.Session();
					nouvelle.setLieu(s.getLieu());
					nouvelle.setUv(new client.UV(s.getUv().getId(),s.getUv().getNom()));
					nouvelle.setDate(s.getDates());
					sess.add(nouvelle);}
				}
		return sess;	
		}
		else {return null;}
	}
	
	//Recherche d'un Agent dans une liste d'Agent à partir d'une clef de hashage
	public Agent rechercheAgent(String cle, List<Agent> listeAgent){
		for(Agent a:listeAgent){
			if(a.getCleHashage().equals(cle)==true){
				return a;
			}
		}		
		return null;
	}
	
	//Rend true si tous les UV requis pour une sessions sont validés par l'agent
	public boolean rechercheUVrequis(Agent agent, Session session){
		boolean requisAcquis=true;
		for(UV uvprerequis:session.getUv().getListeUV()){
			if(agent.getAptitude().contains(uvprerequis)==false){requisAcquis=false;}
		}
		return requisAcquis;
}
}
