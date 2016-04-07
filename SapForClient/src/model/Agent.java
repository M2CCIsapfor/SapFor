/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick - Abdourahman
 */
@XmlRootElement
public class Agent  {
	private AgentT agentT;
	private List<UV> listeUV = new ArrayList<UV>();
	private List<Session> listeSessionsApprenantAccessible = new ArrayList<Session>();
	private List<Session> listeSessionsFormateurAccessible = new ArrayList<Session>();
	private List<Session> listeSessionsInscrit = new ArrayList<Session>();
	private List<Session> listeSessionsCandidat = new ArrayList<Session>();

	private List<Session> listeSessionsFormateurInscrit = new ArrayList<Session>();
	private List<Session> listeSessionsFormateurCandidat = new ArrayList<Session>();

	private List<Session> listeSessionsStage = new ArrayList<Session>();

	private List<Stage> listStages = new ArrayList<Stage>();

	/**
	 * constructeur vide de l'agent
	 */
	public Agent() {
		this.agentT = new AgentT();
	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 */
	public Agent(String matricule) {
		this.agentT = new AgentT(matricule); 
	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 *            de l'agent
	 * @param nom
	 *            de l'agent
	 */
	public Agent(String matricule, String nom) {
		this.agentT = new AgentT(matricule, nom);
	}

	/**
	 * constructeur de l'agent
	 *
	 * @param matricule
	 * @param nom
	 * @param prenom
	 */
	public Agent(String matricule, String nom, String prenom) {
		this.agentT = new AgentT(matricule, nom, prenom);
	}

	/**
	 * getter de la liste des sessions d'un stage
	 * 
	 * @return
	 */
	public List<Session> getListeSessionsStage() {
		return listeSessionsStage;
	}

	/**
	 * getter de la liste des sessions accessibles par l'agent en tans
	 * qu'apprenant
	 * 
	 * @return listeSessionsApprenantAccessible
	 */
	public List<Session> getListeSessionsApprenantAccessible() {
		return listeSessionsApprenantAccessible;
	}

	/**
	 * setter de la liste des sesions accessibles par l'agent en tans
	 * qu'apprenant
	 * 
	 * @param listeSessionsApprenantAccessible
	 */
	public void setListeSessionsApprenantAccessible(List<Session> listeSessionsApprenantAccessible) {
		this.listeSessionsApprenantAccessible = listeSessionsApprenantAccessible;
	}

	/**
	 * getter de la liste des sesions accessibles par l'agent en tans que
	 * formateur
	 * 
	 * @return ListeSessionsFormateurAccessible
	 */
	public List<Session> getListeSessionsFormateurAccessible() {
		return listeSessionsFormateurAccessible;
	}

	/**
	 * setter de la liste des sesions accessibles par l'agent en tans que
	 * formateur
	 * 
	 * @param listeSessionsFormateurAccessible
	 */
	public void setListeSessionsFormateurAccessible(List<Session> listeSessionsFormateurAccessible) {
		this.listeSessionsFormateurAccessible = listeSessionsFormateurAccessible;
	}

	/**
	 * 
	 * @return liste des UV deja obtenu par l'agent
	 */
	public List<UV> getListeUV() {
		return listeUV;
	}

	/**
	 *
	 * @return liste de sessions auxquelles l'agent est inscrit en tant
	 *         qu'Apprenant
	 */
	public List<Session> getListeSessionsInscrit() {
		return listeSessionsInscrit;
	}

	/**
	 *
	 * @return liste de sessions auxquelles l'agent est candidat en tant
	 *         qu'Apprenant
	 */
	public List<Session> getListeSessionsCandidat() {
		return listeSessionsCandidat;
	}

	/**
	 *
	 * @return liste de sessions sessions auxquelles l'agent est inscrit tant
	 *         que formateur
	 */
	public List<Session> getListeSessionsFormateurInscrit() {
		return listeSessionsFormateurInscrit;
	}

	/**
	 *
	 * @return liste de sessions sessions auxquelles l'agent est candidat tant
	 *         que formateur
	 */
	public List<Session> getListeSessionsFormateurCandidat() {
		return listeSessionsFormateurCandidat;
	}

	/**
	 * Setter de la liste des sessions d'un stage
	 * 
	 * @param listeSessionsStage
	 */
	public void setListeSessionsStage(List<Session> listeSessionsStage) {
		this.listeSessionsStage = listeSessionsStage;
	}

	/**
	 * setter de la liste des UV obtenus par l'agent
	 * 
	 * @param listeUV
	 */
	public void setListeUV(List<UV> listeUV) {
		this.listeUV = listeUV;
	}

	/**
	 * setter de la liste des sessions auxquelles l'agent est inscrit en tant qu
	 * apprenant
	 *
	 * @param listeSessionsApprenant
	 */
	public void setListeSessionsInscrit(List<Session> listeSessionsApprenant) {
		this.listeSessionsInscrit = listeSessionsApprenant;
	}

	/**
	 * setter de la liste des sessions auxquelles l'agent est candidat en tant
	 * qu apprenant
	 *
	 * @param listeSessionsApprenant
	 */
	public void setListeSessionsCandidat(List<Session> listeSessionsApprenant) {
		this.listeSessionsCandidat = listeSessionsApprenant;
	}

	/**
	 * setter de la liste des sessions auxquelles l'agent est inscrit en tant qu
	 * formateur
	 *
	 * @param listeSessionsFormateur
	 */
	public void setListeSessionsFormateurtInscrit(List<Session> listeSessionsFormateur) {
		this.listeSessionsFormateurInscrit = listeSessionsFormateur;
	}

	/**
	 * setter de la liste des sessions auxquelles l'agent est candidat en tant
	 * qu formateur
	 *
	 * @param listeSessionsFormateur
	 */
	public void setListeSessionsFormateurtCandidat(List<Session> listeSessionsFormateur) {
		this.listeSessionsFormateurCandidat = listeSessionsFormateur;
	}

	/**
	 *
	 * @return liste des stage que dirige l agent
	 */
	public List<Stage> getListStages() {
		return listStages;
	}

	/**
	 * setter de la liste des stages que dirige l agent
	 *
	 * @param listStages
	 */
	public void setListStages(List<Stage> listStages) {
		this.listStages = listStages;
	}

	public AgentT getAgentT() {
		return agentT;
	}

	public void setAgentT(AgentT agentT) {
		this.agentT = agentT;
	}

	public void setListeSessionsFormateurInscrit(List<Session> listeSessionsFormateurInscrit) {
		this.listeSessionsFormateurInscrit = listeSessionsFormateurInscrit;
	}

	public void setListeSessionsFormateurCandidat(List<Session> listeSessionsFormateurCandidat) {
		this.listeSessionsFormateurCandidat = listeSessionsFormateurCandidat;
	}
	
	
}