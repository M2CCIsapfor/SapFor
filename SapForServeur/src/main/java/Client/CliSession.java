package Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

/**
 *
 * @author Yannick - Abdourahman
 */
public class CliSession {

    private int id;
	private CliUV uv;
    private String date;
    private String lieu;
    private Integer nbMin;
    private Integer nbMax;
    private Integer nbFormateur;


    public CliSession() {
    	this.id = new Integer(0);
        this.date = new String();
        this.lieu = new String();
        this.nbFormateur = new Integer(0);
        this.nbMax = new Integer(0);
        this.nbMin = new Integer(0);
        this.uv = new CliUV();
    }

    public CliSession(int id,CliUV uv, String date, String lieu, Integer nbMin, Integer nbMax, Integer nbFormateur) {
        this.id = id;
    	this.uv = uv;
        this.date = date;
        this.lieu = lieu;
        this.nbMin = nbMin;
        this.nbMax = nbMax;
        this.nbFormateur = nbFormateur;
    }
    
    public CliSession(int id,CliUV uv, String lieu, String date){
        this.id = id;
    	this.uv = uv;
        this.date = date;
        this.lieu = lieu;
        this.nbFormateur = new Integer(0);
        this.nbMax = new Integer(0);
        this.nbMin = new Integer(0);
    }

    public int getId() {
		return id;
	}

	public CliUV getCliUv() {
        return uv;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public Integer getNbMin() {
        return nbMin;
    }

    public Integer getNbMax() {
        return nbMax;
    }

    public Integer getNbFormateur() {
        return nbFormateur;
    }

	public void setId(int id) {
		this.id = id;
	}

    public void setCliUv(CliUV uv) {
        this.uv = uv;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setNbMin(Integer nbMin) {
        this.nbMin = nbMin;
    }

    public void setNbMax(Integer nbMax) {
        this.nbMax = nbMax;
    }

    public void setNbFormateur(Integer nbFormateur) {
        this.nbFormateur = nbFormateur;
    }
}