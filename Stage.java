
import java.util.*;

public class Stage {

	private int id;
	private int directeur; // id Agent directeur
	private List<Session> listeSessions;
	
	public Stage() {
		this.id = 0;
		this.directeur = 0;
		this.listeSessions = new ArrayList<Session>();
	}

	public Stage(int id, int directeur, List<Session> listeSessions){
		this.id=id;
		this.directeur=directeur;
		this.listeSessions=listeSessions;
	}
	
	
	// Accesseurs et Modifieurs
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDirecteur() {
		return directeur;
	}
	
	public void setDirecteur(int directeur) {
		this.directeur = directeur;
	}
	
	public List<Session> getIdSessions() {
		return listeSessions;
	}
	
	public void setIdSessions(List<Session> listeSessions) {
		this.listeSessions = listeSessions;
	}
	
}
