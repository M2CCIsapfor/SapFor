package Server;
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
	
	//V�rification du login et du mot de passe
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public synchronized String Connexion(@QueryParam("login") String log, @QueryParam("password") String pass) {
	System.out.println(log +" :"+ pass);
	// DEBUG
	for (Agent p : donnees.lAgent ) {
		System.out.println((p.getMatricule().equals(log) & p.getPassword().equals(pass)));
		if (p.getMatricule().equals(log) & p.getPassword().equals(pass)){ return p.getCleHashage();}
	}
	return "Mot de passe ou login invalide";                              // Aucun produit correspondant à l'uid
	}
	
	

}
