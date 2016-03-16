package Server;

import java.util.ArrayList;
import java.util.List;

import Client.CliUV;

public class SerSession extends Client.CliSession {

	private SerUV uv;
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
		super();
		this.uv = (SerUV) this.getCliUv();		// A vérifier !!!
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
		super(id,(CliUV) uv, lieu, date);		// A vérifier !!!
		this.uv = uv;
		this.nbApprenant = new Integer(0);
		this.minFormateur = new Integer(0);
		this.candidatsAp = new ArrayList<SerAgent>();
		this.candidatsFo = new ArrayList<SerAgent>();
		this.apprenants = new ArrayList<SerAgent>();
		this.formateurs = new ArrayList<SerAgent>();
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