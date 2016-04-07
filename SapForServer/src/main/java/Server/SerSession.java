package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Session du Serveur
 * @author Equipe Serveur
 */
public class SerSession {

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
     * Constructeur vide de la Session
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
	 * Constructeur de la Session
     * @param id Identifiant de la Session
     * @param uv UV reliée à la Session
     * @param lieu Lieu de la Session
     * @param date Date de la Session
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

    /**.
     * Accesseur identifiant de la Session
     * @return Identifiant de la Session
     */
	public int getId() {
		return id;
	}

    /**
     * Accesseur UV de la Session
     * @return UV relié à la Session
     */
	public SerUV getUv() {
		return uv;
	}

	/**
	 * Accesseur date de la Session
	 * @return Date de la Session
	 */
	public String getDate() {
		return date;
	}

    /**
     * Accesseur lieu de la Session
     * @return Lieu de la Session
     */
	public String getLieu() {
		return lieu;
	}

    /**
     * Accesseur nombre minimum de participants de la Session
     * @return Nombre minimum de participants de la Session
     */
	public Integer getNbMin() {
		return nbMin;
	}

	/**
     * Accesseur nombre maximum de participants de la Session
     * @return nombre maximum de participants de la Session
     */
	public Integer getNbMax() {
		return nbMax;
	}

    /**
     * Accesseur nombre de formateurs de la Session
     * @return Nombre de formateurs de la Session
     */
	public Integer getNbFormateur() {
		return nbFormateur;
	}

    /**
     * Accesseur nombre d'apprenants de la Session
     * @return Nombre d'apprenants de la Session
     */
	public int getNbApprenant() {
		return nbApprenant;
	}

    /**
     * Accesseur nombre minimum de formateurs de la Session
     * @return Nombre minimum de formateurs de la Session
     */
	public int getMinFormateur() {
		return minFormateur;
	}

    /**
     * Accesseur liste des candidats apprenants de la Session
     * @return Liste des candidats apprenants de la Session
     */
	public List<SerAgent> getCandidatsAp() {
		return candidatsAp;
	}

    /**
     * Accesseur liste des candidats formateurs de la Session
     * @return Liste des candidats formateurs de la Session
     */
	public List<SerAgent> getCandidatsFo() {
		return candidatsFo;
	}

    /**
     * Accesseur liste des apprenants acceptés pour la Session
     * @return Liste des apprenants acceptés pour la Session
     */
	public List<SerAgent> getApprenants() {
		return apprenants;
	}

    /**
     * Accesseur liste des formateurs acceptés pour la Session
     * @return Liste des formateurs acceptés pour la Session
     */
	public List<SerAgent> getFormateurs() {
		return formateurs;
	}

    /**
     * Modifieur de l'identifiant de la Session
     * @param id Identifiant de la Session
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Modifieur de l'UV de la Session
	 * @param uv UV relié à la Session
	 */
	public void setUv(SerUV uv) {
		this.uv = uv;
	}

    /**
     * Modifieur de la date de la Session
     * @param date Date de la Session
     */
	public void setDate(String date) {
		this.date = date;
	}

    /**
     * Modifieur du lieu de la Session
     * @param lieu Lieu de la Session
     */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

    /**
     * Modifieur du nombre minimum de participants de la Session
     * @param nbMin Nombre minimum de participants de la Session
     */
	public void setNbMin(int nbMin) {
		this.nbMin = nbMin;
	}

    /**
     * Modifieur du nombre maximum de participants de la Session
     * @param nbMax Nombre maximum de participant à la Session
     */
	public void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}

    /**
     * Modifieur du nombre de formateurs de la Session
     * @param nbFormateur Nombre de formateurs de la Session
     */
	public void setNbFormateur(int nbFormateur) {
		this.nbFormateur = nbFormateur;
	}

    /**
     * Modifieur du nombre d'apprenants de la Session
     * @param nbApprenant Nombre d'apprenants de la Session
     */
	public void setNbApprenant(int nbApprenant) {
		this.nbApprenant = nbApprenant;
	}

    /**
     * Modifieur du nombre minimum de formateurs de la Session
     * @param minFormateur Nombre minimum de formateurs de la Session
     */
	public void setMinFormateur(int minFormateur) {
		this.minFormateur = minFormateur;
	}

    /**
     * Modifieur du nombre de candidats apprenants de la Session
     * @param candidatsAp Nombre de candidats apprenants de la Session
     */
	public void setCandidatsAp(List<SerAgent> candidatsAp) {
		this.candidatsAp = candidatsAp;
	}

	/**
     * Modifieur du nombre de candidats formateurs de la Session
     * @param candidatsFo Nombre de candidats formateurs de la Session
     */
	public void setCandidatsFo(List<SerAgent> candidatsFo) {
		this.candidatsFo = candidatsFo;
	}

	/**
     * Modifieur du nombre d'apprenants acceptés pour la Session
     * @param apprenants Nombre d'apprenants acceptés pour la Session
     */
	public void setApprenants(List<SerAgent> apprenants) {
		this.apprenants = apprenants;
	}

	/**
     * Modifieur du nombre de formateurs acceptés pour la Session
     * @param formateurs Nombre de formateurs acceptés pour la Session
     */
	public void setFormateurs(List<SerAgent> formateurs) {
		this.formateurs = formateurs;
	}
	
	/**
	 * Valider un  candidat Apprenant (en temps que directeur)
	 * @param Apprenant Agent validé en tant que candidat
	 */
	public void validerApprenant(SerAgent Apprenant) {
		apprenants.add(Apprenant);
		candidatsAp.remove(Apprenant);
	}
	
	/**
	 * Valider un  candidat formateur (en temps que directeur)
	 * @param Formateur Agent validé en tant que formateur
	 */
	public void validerFormateur(SerAgent Formateur) {
		formateurs.add(Formateur);
		candidatsFo.remove(Formateur);
	}

	/**
	 * Fonction de retrait d'un agent dans une liste de Session par un Candidat
	 * @param agent Agent a supprimer des listes de la Session
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
