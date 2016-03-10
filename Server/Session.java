package Server;

import java.util.*;

public class Session {
	private int codeSession;
	private UV uv;
	private String lieu;
	private int nbApprenant;
	private int nbFormateur;
	private int minApprenant;
	private int minFormateur;
	private String date;
	private List<Agent> candidatsAp;
	private List<Agent> candidatsFo;
	private List<Agent> apprenants;
	private List<Agent> formateurs;
	
	/**
	 * Constructeur Session avec juste code Session
	 * @param codeS
	 */
	public Session(int codeS) {
		this.codeSession = codeS;		
		this.uv=new UV();
		this.lieu = new String();
		this.nbApprenant = 0;
		this.minFormateur = 0;
		this.minApprenant = 0;
		this.minFormateur = 0;
		this.date = new String();
		this.candidatsAp = new ArrayList<Agent>();
		this.candidatsFo = new ArrayList<Agent>();
		this.apprenants = new ArrayList<Agent>();
		this.formateurs = new ArrayList<Agent>();
	}
	
	/**
	 * Constructeur Session avec :
	 * @param codeS
	 * @param uv
	 * @param lieu
	 * @param date
	 */
	public Session(int codeS, UV uv, String lieu, String date){
		this.codeSession = codeS;
		this.uv=uv;
		this.lieu=lieu;
		this.date=date;
		this.nbApprenant = 0;
		this.minFormateur = 0;
		this.minApprenant = 0;
		this.minFormateur = 0;
		this.candidatsAp = new ArrayList<Agent>();
		this.candidatsFo = new ArrayList<Agent>();
		this.apprenants = new ArrayList<Agent>();
		this.formateurs = new ArrayList<Agent>();
	}

	/**
	 * Retourne le code de la session
	 * @return
	 */
	public int getCodeSession() {
		return codeSession;
	}

	/**
	 * change le code de la session
	 * @param codeSession
	 */
	public void setCodeSession(int codeSession) {
		this.codeSession = codeSession;
	}
	
	/**
	 * Change l'UV
	 * @param uv
	 */
	public void setUv(UV uv) {
		this.uv = uv;
	}

	/**
	 * Retourne l'UV
	 * @return
	 */
	public UV getUv() {
		return uv;
	}
	
	/**
	 * Retourne le lieu de la session
	 * @return
	 */
	public String getLieu() {
		return lieu;
	}

	/**
	 * Modifie le lieu de la formation
	 * @param lieu
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	/**
	 * Retourne le nombre d'apprenants
	 * @return
	 */
	public int getNbApprenant() {
		return nbApprenant;
	}

	/**
	 * modifie le nombre d'apprenants
	 * @param nbApprenant
	 */
	public void setNbApprenant(int nbApprenant) {
		this.nbApprenant = nbApprenant;
	}

	/**
	 * Retourne le nombre de formateurs
	 * @return
	 */
	public int getNbFormateur() {
		return nbFormateur;
	}

	/**
	 * Modifie le nombre de formateur
	 * @param nbFormateur
	 */
	public void setNbFormateur(int nbFormateur) {
		this.nbFormateur = nbFormateur;
	}

	/**
	 * Retourne le nombre minimum d'apprenants
	 * @return
	 */
	public int getMinApprenant() {
		return minApprenant;
	}

	/**
	 * Modifie le nombre minimum d'apprenants
	 * @param minApprenant
	 */
	public void setMinApprenant(int minApprenant) {
		this.minApprenant = minApprenant;
	}

	/**
	 * Retourne le minimum de formateur
	 * @return
	 */
	public int getMinFormateur() {
		return minFormateur;
	}

	/**
	 * Modifie le minimum de formateur
	 * @param minFormateur
	 */
	public void setMinFormateur(int minFormateur) {
		this.minFormateur = minFormateur;
	}

	/**
	 * Retourne la date de la session
	 * @return
	 */
	public String getDates() {
		return date;
	}

	/**
	 * Modifie la date de la session
	 * @param date
	 */
	public void setDates(String date) {
		this.date = date;
	}

	/**
	 * Retourne la liste des candidats apprenants
	 * @return
	 */
	public List<Agent> getCandidatsAp() {
		return candidatsAp;
	}

	/**
	 * Modifie la liste des candidats apprenants
	 * @param candidatsAp
	 */
	public void setCandidatsAp(List<Agent> candidatsAp) {
		this.candidatsAp = candidatsAp;
	}

	/**
	 * Retourne la liste des candidats formateurs
	 * @return
	 */
	public List<Agent> getCandidatsFo() {
		return candidatsFo;
	}

	/**
	 * Modifie la liste des candidats formateurs
	 * @param candidatsFo
	 */
	public void setCandidatsFo(List<Agent> candidatsFo) {
		this.candidatsFo = candidatsFo;
	}

	/**
	 * Retourne la liste des apprenants acceptés
	 * @return
	 */
	public List<Agent> getApprenants() {
		return apprenants;
	}

	/**
	 * Modifie la liste des apprenants acceptés
	 * @param apprenants
	 */
	public void setApprenants(List<Agent> apprenants) {
		this.apprenants = apprenants;
	}

	/**
	 * Retourne la liste des formateurs acceptés
	 * @return
	 */
	public List<Agent> getFormateurs() {
		return formateurs;
	}

	/**
	 * Modifie la liste des formateurs acceptés
	 * @param formateurs
	 */
	public void setFormateurs(List<Agent> formateurs) {
		this.formateurs = formateurs;
	}

	/**
	 * Valider un ou plusieurs candidats Apprenants (en temps que directeur)
	 * @param Apprenants
	 */
	public void validerApprenants(List<Agent> Apprenants) {
		apprenants.addAll(Apprenants);
		candidatsAp.removeAll(Apprenants);
	}
	
	/**
	 * Valider un ou plusieurs candidats formateurs (en temps que directeur)
	 * @param Formateurs
	 */
	public void validerFormateurs(List<Agent> Formateurs) {
		formateurs.addAll(Formateurs);
		candidatsFo.removeAll(Formateurs);
	}
	
}
