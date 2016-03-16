package Client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class Stage {
	private String title;
	private List<SessionT> listeCliSessions;
    private AgentT directeurCli;

    public Stage() {
    	this.title = new String();
    	listeCliSessions = new ArrayList<SessionT>();
    	directeurCli = new AgentT();
    }

    public Stage(String title, AgentT directeur) {
    	this.title = title;
    	this.listeCliSessions = new ArrayList<SessionT>();
        this.directeurCli = directeur;
    }
    
    public Stage(String title, List<SessionT> listeSessions, AgentT directeur) {
    	this.title = title;
    	this.listeCliSessions = listeSessions;
        this.directeurCli = directeur;
    }
 
    public String getTitle() {
		return title;
	}

    public List<SessionT> getCliListeSessions() {
        return listeCliSessions;
    }

    public AgentT getCliDirecteur() {
        return directeurCli;
    }

	public void setTitle(String title) {
		this.title = title;
	}

    public void setCliListeSessions(List<SessionT> listeSessions) {
        this.listeCliSessions = listeSessions;
    }

    public void setCliDirecteur(AgentT directeur) {
        this.directeurCli = directeur;
    }
}