package Client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 * Classe Stage commune Client et Serveur
 * @author Equipe Serveur
 */
public class Stage {
	
	private String title;
	private List<SessionT> listeCliSessions;
    private AgentT directeurCli;

    /**
     * Constructeur vide du Stage
     */
    public Stage() {
    	this.title = new String();
    	listeCliSessions = new ArrayList<SessionT>();
    	directeurCli = new AgentT();
    }

    /**
     * Constructeur du Stage
     * @param title Titre du Stage
     * @param directeur Directeur du Stage
     */
    public Stage(String title, AgentT directeur) {
    	this.title = title;
    	this.listeCliSessions = new ArrayList<SessionT>();
        this.directeurCli = directeur;
    }
    
    /**
     * Constructeur du Stage
     * @param title Titre du Stage
     * @param directeur Directeur du Stage
     * @param listeSessions Liste des Session du Stage
     */
    public Stage(String title, List<SessionT> listeSessions, AgentT directeur) {
    	this.title = title;
    	this.listeCliSessions = listeSessions;
        this.directeurCli = directeur;
    }
 
    /**
     * Accesseur du titre du Stage
     * @return titre du Stage
     */
    public String getTitle() {
		return title;
	}

    /**
     * Accesseur de la liste des Sessions du Stage
     * @return Liste des Sessions du Stage
     */
    public List<SessionT> getCliListeSessions() {
        return listeCliSessions;
    }

    /**
     * Accesseur du directeur du Stage
     * @return Directeur du Stage
     */
    public AgentT getCliDirecteur() {
        return directeurCli;
    }

    /**
     * Modifieur du titre du Stage
     * @param title Titre du Stage
     */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Modifieur de la liste des Sessions du Stage
	 * @param listeSessions Liste des Sessions du Stage
	 */
    public void setCliListeSessions(List<SessionT> listeSessions) {
        this.listeCliSessions = listeSessions;
    }

    /**
     * Modifieur du directeur du Stage
     * @param directeur Directeur du Stage
     */
    public void setCliDirecteur(AgentT directeur) {
        this.directeurCli = directeur;
    }
}