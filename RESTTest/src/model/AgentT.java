package model;

import javax.xml.bind.annotation.XmlRootElement;

/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

/**
 *
 * @author Yannick
 */
@XmlRootElement
public class AgentT {

	protected String matricule = new String();
	protected String nom = new String();
	protected String prenom = new String();

	/**
	 * constructeur vide de l'agent
	 */
	public AgentT() {

	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 */
	public AgentT(String matricule) {
		setMatricule(matricule);

	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 *            de l'agent
	 * @param nom
	 *            de l'agent
	 */
	public AgentT(String matricule, String nom) {
		setMatricule(matricule);
		setNom(nom);

	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 * @param nom
	 * @param prenom
	 */
	public AgentT(String matricule, String nom, String prenom) {
		setMatricule(matricule);
		setNom(nom);
		setPrenom(prenom);
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