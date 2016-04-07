package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Agent du Serveur
 * @author Equipe Serveur
 */
public class SerAgent {

	private String matricule ;
	private String nom ;
	private String prenom ;
	private String password;
	private String cleHashage;
	private List<SerUV> aptitude;
	
	/**
	 * Constructeur vide de l'agent
	 */
	public SerAgent() {
		this.matricule = new String();
		this.nom = new String();
		this.prenom = new String();
		this.password = new String();
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}

	/**
	 * Constructeur de l'agent
	 * @param matricule Matricule de l'Agent
	 * @param password Mot de passe de l'Agent
	 */
	public SerAgent(String matricule, String password){
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();
		this.password = password;
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}

	/**
	 * Constructeur de l'agent
	 * @param matricule Matricule de l'Agent
	 * @param password Mot de passe de l'Agent
	 * @param aptitude Liste des UVs que l'Agent a deja obtenu
	 */
	public SerAgent(String matricule, String password, List<SerUV> aptitude){
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();;
		this.password=password;
		this.cleHashage = new String();
		this.aptitude=aptitude;
	}
	
	//Accesseurs et Modifieurs
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
	 * Accesseur Mot de passe de l'Agent
	 * @return Mot de passe de l'Agent
	 */
	public String getPassword() {
		return password;
	}

	/**.
	 * Accesseur Cle de hachage renvoye a l'Agent lors de sa connexion
	 * @return Cle de hachage renvoye a l'Agent lors de sa connexion
	 */
	public String getCleHashage() {
		return cleHashage;
	}
	
	/**
	 * Accesseur Liste des UVs obtenues par l'Agent
	 * @return Liste des UVs obtenues par l'Agent
	 */
	public List<SerUV> getAptitude() {
		return aptitude;
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

	/**
	 * Modifieur Mot de passe de l'Agent
	 * @param password Mot de passe de l'Agent
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Cle de hachage renvoye a l'Agent lors de sa connexion
	 * @param cleHashage Cle de hachage renvoye a l'Agent lors de sa connexion
	 */
	public void setCleHashage(String cleHashage) {
		this.cleHashage = cleHashage;
	}
	
	/**
	 * Liste des UVs obtenues par l'Agent
	 * @param aptitude Liste des UVs obtenues par l'Agent
	 */
	public void setAptitude(List<SerUV> aptitude) {
		this.aptitude = aptitude;
	}
	
	/**
	 * Ajout d'un UV a la liste des UVs obtenus par l'Agent
	 * @param newUV UV a ajouter a la liste des UVs obtenus par l'Agent
	 */
	public void addUV(SerUV newUV) {
		this.aptitude.add(newUV);
	}
}
