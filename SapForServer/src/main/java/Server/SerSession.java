package Server;

import java.util.ArrayList;
import java.util.List;

import Client.UV;

public class SerSession extends Client.SessionT {

    private int id;
    private SerUV uv;
    private String date;
    private String lieu;
    private int nbMin;
    private int nbMax;
    private int nbFormateur;
	private int nbApprenant;
	private int minFormateur;
	private List<SerAgent> candidatsAp;
	private List<SerAgent> candidatsFo;
	private List<SerAgent> apprenants;
	private List<SerAgent> formateurs;

	/**
	 * Constructeur Session avec juste code Session
	 * @param id
	 */
	public SerSession() {
		this.id = new Integer(0);
		this.uv = new SerUV();
		this.date = new String();
		this.lieu = new String();
		this.nbMin = new Integer(0);
		this.nbMax = new Integer(0);
		this.nbFormateur = new Integer(0);
		this.nbApprenant = new Integer(0);
		this.minFormateur = new Integer(0);
		this.candidatsAp = new ArrayList<SerAgent>();
		this.candidatsFo = new ArrayList<SerAgent>();
		this.apprenants = new ArrayList<SerAgent>();
		this.formateurs = new ArrayList<SerAgent>();
	}


	/**
	 * Constructeur Session avec :
	 * @param id
	 * @param uv
	 * @param lieu
	 * @param date
	 */
	public SerSession(int id, SerUV uv, String lieu, String date){
		this.id = id;
		this.uv = uv;
		this.date = lieu;
		this.lieu = date;
		this.nbMin = new Integer(0);
		this.nbMax = new Integer(0);
		this.nbFormateur = new Integer(0);
		this.nbApprenant = new Integer(0);
		this.minFormateur = new Integer(0);
		this.candidatsAp = new ArrayList<SerAgent>();
		this.candidatsFo = new ArrayList<SerAgent>();
		this.apprenants = new ArrayList<SerAgent>();
		this.formateurs = new ArrayList<SerAgent>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public SerUV getUv() {
		return uv;
	}


	public void setUv(SerUV uv) {
		this.uv = uv;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public Integer getNbMin() {
		return nbMin;
	}


	public void setNbMin(int nbMin) {
		this.nbMin = nbMin;
	}


	public Integer getNbMax() {
		return nbMax;
	}


	public void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}


	public Integer getNbFormateur() {
		return nbFormateur;
	}


	public void setNbFormateur(int nbFormateur) {
		this.nbFormateur = nbFormateur;
	}


	public SerUV getSerUv() {
		return uv;
	}


	public void setSerUv(SerUV uv) {
		this.uv = uv;
	}


	public int getNbApprenant() {
		return nbApprenant;
	}


	public void setNbApprenant(int nbApprenant) {
		this.nbApprenant = nbApprenant;
	}


	public int getMinFormateur() {
		return minFormateur;
	}


	public void setMinFormateur(int minFormateur) {
		this.minFormateur = minFormateur;
	}


	public List<SerAgent> getCandidatsAp() {
		return candidatsAp;
	}


	public void setCandidatsAp(List<SerAgent> candidatsAp) {
		this.candidatsAp = candidatsAp;
	}


	public List<SerAgent> getCandidatsFo() {
		return candidatsFo;
	}


	public void setCandidatsFo(List<SerAgent> candidatsFo) {
		this.candidatsFo = candidatsFo;
	}


	public List<SerAgent> getApprenants() {
		return apprenants;
	}


	public void setApprenants(List<SerAgent> apprenants) {
		this.apprenants = apprenants;
	}


	public List<SerAgent> getFormateurs() {
		return formateurs;
	}


	public void setFormateurs(List<SerAgent> formateurs) {
		this.formateurs = formateurs;
	}
	
	/**
	 * Valider un  candidat Apprenant (en temps que directeur)
	 * @param Apprenants
	 */
	public void validerApprenant(SerAgent Apprenant) {
		apprenants.add(Apprenant);
		candidatsAp.remove(Apprenant);
	}
	
	/**
	 * Valider un  candidat formateur (en temps que directeur)
	 * @param Formateurs
	 */
	public void validerFormateur(SerAgent Formateur) {
		formateurs.add(Formateur);
		candidatsFo.remove(Formateur);
	}

	/**
	 * Fonction de retrait d'un agent dans une liste de Session par un Candidat
	 * @param agent
	 */
	public void removeAgent(SerAgent agent) {
		if(this.candidatsAp.contains(agent)) {
			this.candidatsAp.remove(agent);
		}
		else if(this.candidatsFo.contains(agent)) {
			this.candidatsFo.remove(agent);
		}
		else if(this.apprenants.contains(agent)) {
			this.apprenants.remove(agent);
		}
		else if(this.formateurs.contains(agent)) {
			this.formateurs.remove(agent);
		}
	}
	
}
