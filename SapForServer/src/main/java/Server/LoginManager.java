package Server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.spi.resource.Singleton;

/**
 * Classe de traitement de connexion de l'agent
 * par le matricule et mot de passe
 * @author Equipe Serveur
 *
 */
@Singleton
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LoginManager {

	/**
	 * Methode de test de la classe
	 * @return "Hello"
	 */
	@GET
	@Path("/simple")
	@Produces({MediaType.TEXT_PLAIN})
	public String simple(){
		return "Hello";
	}
	Data donnees=new Data();

	/**
	 * Fonction de traitement du matricule et mot de passe
	 * @param log matricule de l'Agent
	 * @param pass Mot de passe de l'Agent
	 * @return Cle de hachage genere aleatoirement
	 */
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
