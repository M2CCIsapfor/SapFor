
import java.util.*;

public class Stage {

	private int id;
	private String matriculeDir; // matricule Agent directeur
	private List<Session> listeSessions;
	
	public Stage() {
		this.id = 0;
		this.matriculeDir = new String();
		this.listeSessions = new ArrayList<Session>();
	}

	public Stage(int id, String directeur){
		this.id=id;
		this.matriculeDir=directeur;
	}
	
	public Stage(int id, String directeur, List<Session> listeSessions){
		this.id=id;
		this.matriculeDir=directeur;
		this.listeSessions=listeSessions;
	}
	
	
	// Accesseurs et Modifieurs
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDirecteur() {
		return matriculeDir;
	}
	
	public void setDirecteur(String directeur) {
		this.matriculeDir = directeur;
	}
	
	public List<Session> getIdSessions() {
		return listeSessions;
	}
	
	public void setIdSessions(List<Session> listeSessions) {
		this.listeSessions = listeSessions;
	}
	
	public void addSession(Session newSession) {
		this.listeSessions.add(newSession);
	}
	
}
