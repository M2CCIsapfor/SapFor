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
	@Produces({MediaType.TEXT_PLAIN})
	public String simple(){
		return "Hello";
	}
	Data donnees=new Data();
	
	//V�rification du login et du mot de passe
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public synchronized String Connexion(@QueryParam("login") String log, @QueryParam("password") String pass) {
	System.err.println(log +" : "+ pass);
	// DEBUG
	for (SerAgent p : donnees.lAgent ) {
		System.err.println((p.getMatricule().equals(log) && p.getPassword().equals(pass)));
		if (p.getMatricule().equals(log) && p.getPassword().equals(pass)){ return p.getCleHashage();}
	}
	return "Mot de passe ou login invalide";                              // Aucun produit correspondant à l'uid
	}
	
	

}
