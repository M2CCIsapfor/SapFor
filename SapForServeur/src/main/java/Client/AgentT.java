package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman - Fran�ois
 */
public class AgentT {

	private String matricule ;
	private String nom ;
	private String prenom ;

	/**
	 * constructeur vide de l'agent
	 */
	public AgentT(){
		this.matricule = new String();
		this.nom = new String();
		this.prenom = new String();
	}

	/**
	 * constructeur de l'agent
	 * @param matricule
	 */
	public AgentT(String matricule) {
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();
	}

	/**
	 * constructeur de l'agent
	 * @param matricule de l'agent
	 * @param nom de l'agent
	 */
	public AgentT(String matricule, String nom) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = new String();
	}

	/**
	 * constructeur de l'agent
	 * @param matricule
	 * @param nom
	 * @param prenom
	 */
	public AgentT(String matricule, String nom, String prenom) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 *
	 * @return matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 *
	 * @return nom de l'agent
	 */
	public String getNom() {
		return nom;
	}

	/**
	 *
	 * @return prenom de l'agent
	 */
	public String getPrenom() {
		return prenom;
	}





	/**
	 * setter du matricule de l agent
	 *
	 * @param matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * setter du nom de l'agent
	 *
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * setter du prenom de l'agent
	 *
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}