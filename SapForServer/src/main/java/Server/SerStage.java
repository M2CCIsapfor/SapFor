package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Stage du serveur
 * @author Equipe Serveur
 */

public class SerStage {

	private String title;
	private List<SerSession> listeSerSessions;
    private SerAgent directeurSer;

    /**
     * Constructeur vide du Stage
     */
	public SerStage() {
		this.title = new String();
		this.directeurSer = new SerAgent();
		this.listeSerSessions = new ArrayList<SerSession>();
	}

    /**
     * Constructeur du Stage
     * @param title Titre du Stage
     * @param directeur Directeur du Stage
     */
	public SerStage(String title, SerAgent directeur){
		this.title = title;
		this.directeurSer = directeur;
		this.listeSerSessions = new ArrayList<SerSession>();
	}

    /**
     * Accesseur du titre du Stage
     * @return titre du Stage
     */
	public String getTitle() {
		return title;
	}

    /**
     * Accesseur du directeur du Stage
     * @return Directeur du Stage
     */
	public SerAgent getDirecteurSer() {
		return directeurSer;
	}

    /**
     * Accesseur de la liste des Sessions du Stage
     * @return Liste des Sessions du Stage
     */
	public List<SerSession> getListeSerSessions() {
		return listeSerSessions;
	}

    /**
     * Modifieur du titre du Stage
     * @param title Titre du Stage
     */
	public void setTitle(String title) {
		this.title = title;
	}

    /**
     * Modifieur du directeur du Stage
     * @param directeurSer Directeur du Stage
     */
	public void setDirecteurSer(SerAgent directeurSer) {
		this.directeurSer = directeurSer;
	}
	
	/**
	 * Modifieur de la liste des Sessions du Stage
	 * @param listeSerSessions Liste des Sessions du Stage
	 */
	public void setListeSerSessions(List<SerSession> listeSerSessions) {
		this.listeSerSessions = listeSerSessions;
	}

	/**
	 * Ajout d'une Session à la liste des Sessions du Stage
	 * @param newSession Session a ajouter a la liste des Sessions du Stage
	 */
	public void addSession(SerSession newSession) {
		this.listeSerSessions.add(newSession);
	}
	
}
