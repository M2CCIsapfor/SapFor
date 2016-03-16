package Server;

import java.util.ArrayList;
import java.util.List;

import Client.CliAgent;
import Client.CliSession;

public class SerStage extends Client.CliStage {

	private List<SerSession> listeSerSessions;
    private SerAgent directeurSer;
	
	public SerStage() {
		super();
		this.directeurSer = (SerAgent) this.getCliDirecteur(); 		// A vérifier !!!
		this.listeSerSessions = new ArrayList<SerSession>();
		// Initialisation de liste des sessions à partir des CliSession
		for(CliSession s : this.getCliListeSessions()) {
			this.listeSerSessions.add((SerSession) s);		// A vérifier !!!
		}
	}


	public SerStage(String title, SerAgent directeur){
		super(title, (CliAgent) directeur);
		this.directeurSer = directeur;
		this.listeSerSessions = new ArrayList<SerSession>();
	}


	public List<SerSession> getListeSerSessions() {
		return listeSerSessions;
	}


	public void setListeSerSessions(List<SerSession> listeSerSessions) {
		this.listeSerSessions = listeSerSessions;
	}


	public SerAgent getDirecteurSer() {
		return directeurSer;
	}


	public void setDirecteurSer(SerAgent directeurSer) {
		this.directeurSer = directeurSer;
	}
	
	public void addSession(SerSession newSession) {
		this.listeSerSessions.add(newSession);
	}
	
}
