package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *	Classe Agent commune Client et Serveur
 * @author Equipe Serveur
 */
public class AgentT {

	private String matricule ;
	private String nom ;
	private String prenom ;

	/**
	 * Constructeur vide de l'agent
	 */
	public AgentT(){
		this.matricule = new String();
		this.nom = new String();
		this.prenom = new String();
	}

	/**
	 * Constructeur de l'agent
	 * @param matricule Matricule de l'Agent
	 */
	public AgentT(String matricule) {
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();
	}

	/**
	 * Constructeur de l'agent
	 * @param matricule Matricule de l'Agent
	 * @param nom Nom de l'Agent
	 */
	public AgentT(String matricule, String nom) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = new String();
	}

	/**
	 * Constructeur de l'agent
	 * @param matricule Matricule de l'Agent
	 * @param nom Nom de l'Agent
	 * @param prenom Prenom de l'Agent
	 */
	public AgentT(String matricule, String nom, String prenom) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Accesseur Matricule de l'Agent
	 * @return Matricule de l'Agent
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Accesseur Nom de l'Agent
	 * @return Nom de l'Agent
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur Prenom de l'Agent
	 * @return Prenom de l'Agent
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Modifieur Matricule de l'Agent
	 * @param matricule Matricule de l'Agent
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Modifieur Nom de l'Agent
	 * @param nom Nom de l'Agent
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Modifieur prenom de l'Agent
	 * @param prenom Prenom de l'Agent
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}