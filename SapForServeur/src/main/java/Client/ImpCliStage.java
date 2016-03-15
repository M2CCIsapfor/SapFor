package Client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class ImpCliStage implements CliStage {
	private String title;
	private List<CliSession> listeCliSessions;
    private CliAgent directeurCli;

    public ImpCliStage() {
    	this.title = new String();
    	listeCliSessions = new ArrayList<CliSession>();
    	directeurCli = new ImpCliAgent();
    }

    public ImpCliStage(String title, CliAgent directeur) {
    	this.title = title;
    	this.listeCliSessions = new ArrayList<CliSession>();
        this.directeurCli = directeur;
    }
    
    public ImpCliStage(String title, List<CliSession> listeSessions, CliAgent directeur) {
    	this.title = title;
    	this.listeCliSessions = listeSessions;
        this.directeurCli = directeur;
    }
 
    public String getTitle() {
		return title;
	}

    public List<CliSession> getCliListeSessions() {
        return listeCliSessions;
    }

    public CliAgent getCliDirecteur() {
        return directeurCli;
    }

	public void setTitle(String title) {
		this.title = title;
	}

    public void setCliListeSessions(List<CliSession> listeSessions) {
        this.listeCliSessions = listeSessions;
    }

    public void setCliDirecteur(CliAgent directeur) {
        this.directeurCli = directeur;
    }
}