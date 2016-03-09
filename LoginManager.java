package sapfor.test;
import java.util.ArrayList;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;



@Singleton
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LoginManager {
	@GET
	@Path("/simple")
	public String simple(){
		return "Hello Vicky";
	}
	private List<Login> loginTEST;
	public LoginManager(){
		loginTEST = new ArrayList<Login>();
		loginTEST.add(new Login("Julien", "ju"));
		loginTEST.add(new Login("Vicky", "vi"));
		loginTEST.add(new Login("Mamadou", "ma"));
		loginTEST.add(new Login("Sebastien", "se"));
		loginTEST.add(new Login("Mouktar", "mo"));
		System.out.println(loginTEST);
	}
	
	//Vérification du login et du mot de passe
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public synchronized Login getProduitByUID(@QueryParam("login") String log, @QueryParam("password") String pass) {
	System.out.println(log +" :"+ pass);
	// DEBUG
	for (Login p : loginTEST) {
		System.out.println((p.getLogin().equals(log) & p.getPassword().equals(pass)));
		if (p.getLogin().equals(log)&& p.getPassword().equals(pass)){ System.out.println("t2"); return p;}
	}
	return null;                              // Aucun produit correspondant à l'uid
	}
	
	

}
