package Server;

import java.util.ArrayList;
import java.util.List;

public class SerAgent {

	private String matricule ;
	private String nom ;
	private String prenom ;
	private String password;
	private String cleHashage;
	private List<SerUV> aptitude;
	
	public SerAgent() {
		this.matricule = new String();
		this.nom = new String();
		this.prenom = new String();
		this.password = new String();
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}

	public SerAgent(String matricule, String password){
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();
		this.password = password;
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}
	
	public SerAgent(String matricule, String password, List<SerUV> aptitude){
		this.matricule = matricule;
		this.nom = new String();
		this.prenom = new String();;
		this.password=password;
		this.cleHashage = new String();
		this.aptitude=aptitude;
	}
	
	//Accesseurs et Modifieurs
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCleHashage() {
		return cleHashage;
	}

	public void setCleHashage(String cleHashage) {
		this.cleHashage = cleHashage;
	}

	public List<SerUV> getAptitude() {
		return aptitude;
	}

	public void setAptitude(List<SerUV> aptitude) {
		this.aptitude = aptitude;
	}
	
	public void addUV(SerUV newUV) {
		this.aptitude.add(newUV);
	}
}
