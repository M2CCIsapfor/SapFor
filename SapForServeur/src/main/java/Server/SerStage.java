package Server;

import java.util.ArrayList;
import java.util.List;

import Client.CliAgent;
import Client.CliSession;

public class SerStage extends Client.CliStage {

	private String title;
	private List<SerSession> listeSerSessions;
    private SerAgent directeurSer;
	
	public SerStage() {
		this.title = new String();
		this.directeurSer = new SerAgent();
		this.listeSerSessions = new ArrayList<SerSession>();
	}


	public SerStage(String title, SerAgent directeur){
		this.title = title;
		this.directeurSer = directeur;
		this.listeSerSessions = new ArrayList<SerSession>();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
