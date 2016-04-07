package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

/**
 * Classe Session commune Client et Serveur
 * @author Equipe Serveur
 */
public class SessionT {

    protected int id;
    protected UV uv;
    protected int prio;
    protected String date;
    protected String lieu;
    protected Integer nbMin;
    protected Integer nbMax;
    protected Integer nbFormateur;

    /**
     * Constructeur vide de la Session
     */
    public SessionT() {
    	this.id = 0;
    	this.prio = 0;
        this.date = new String();
        this.lieu = new String();
        this.nbFormateur = new Integer(0);
        this.nbMax = new Integer(0);
        this.nbMin = new Integer(0);
        this.uv = new UV();
    }

    /**
     * Constructeur de la Session
     * @param id Identifiant de la Session
     * @param uv UV reliée à la Session
     * @param date Date de la Session
     * @param lieu Lieu de la Session
     * @param nbMin Nombre minimum de participants à la Session
     * @param nbMax Nombre maximum de participants à la Session
     * @param nbFormateur Nombre de formateurs à la Session
     */
    public SessionT(int id,UV uv, String date, String lieu, Integer nbMin, Integer nbMax, Integer nbFormateur) {
        this.id = id;
    	this.prio = 0;
    	this.uv = uv;
        this.date = date;
        this.lieu = lieu;
        this.nbMin = nbMin;
        this.nbMax = nbMax;
        this.nbFormateur = nbFormateur;
    }
    
    /**
     * Constructeur de la Session
     * @param id Identifiant de la Session
     * @param uv UV reliée à la Session
     * @param lieu Lieu de la Session
     * @param date Date de la Session
     */
    public SessionT(int id,UV uv, String lieu, String date){
        this.id = id;
    	this.prio = 0;
    	this.uv = uv;
        this.date = date;
        this.lieu = lieu;
        this.nbFormateur = new Integer(0);
        this.nbMax = new Integer(0);
        this.nbMin = new Integer(0);
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
	public UV getCliUv() {
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
    public void setCliUv(UV uv) {
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
    public void setNbMin(Integer nbMin) {
        this.nbMin = nbMin;
    }

    /**
     * Modifieur du nombre maximum de participants de la Session
     * @param nbMax Nombre maximum de participant à la Session
     */
    public void setNbMax(Integer nbMax) {
        this.nbMax = nbMax;
    }

    /**
     * Modifieur du nombre de formateurs de la Session
     * @param nbFormateur Nombre de formateurs de la Session
     */
    public void setNbFormateur(Integer nbFormateur) {
        this.nbFormateur = nbFormateur;
    }
}