package Server;

import java.util.*;

public class Agent {


	private String matricule;
	private String password;
	private String cleHashage;
	private String nom;
	private String prenom;
	private List<UV> aptitude;
	
	
	public Agent() {
		this.matricule = new String();
		this.password=new String();
		this.nom = new String();
		this.prenom = new String();
		this.aptitude = new ArrayList<UV>(); 
	}
	
	public Agent(String matricule, String password){
		this.matricule=matricule;
		this.password=password;
	}
	
	public Agent(String matricule, String password, List<UV> aptitude){
		this.matricule=matricule;
		this.password=password;
		this.aptitude=aptitude;
	}
	
	//Accesseurs et Modifieurs
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setId(String matricule) {
		this.matricule = matricule;
	}
	
	public String getPassword() {
		return password;
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
	
	public List<UV> getAptitude() {
		return aptitude;
	}
	
	public void setAptitude(List<UV> aptitude) {
		this.aptitude = aptitude;
	}
	
	public void addUV(UV newUV) {
		this.aptitude.add(newUV);
	}

	public String getCleHashage() {
		return cleHashage;
	}

	public void setCleHashage(String cleHashage) {
		this.cleHashage = cleHashage;
	}
}
