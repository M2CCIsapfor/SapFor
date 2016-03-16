package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick Melin
 * 
 */
@XmlRootElement
public class SessionT {

	protected int id;
	protected UV uv;
	protected int prio;
	protected Date date;
	protected String lieu;
	protected Integer nbMin;
	protected Integer nbMax;
	protected Integer nbFormateur;

	public SessionT() {
		this.id = 0;
		this.date = new Date();
		this.lieu = new String();
		this.nbFormateur = new Integer(0);
		this.nbMax = new Integer(0);
		this.nbMin = new Integer(0);
		this.uv = new UV();

	}

	public SessionT(int id, UV uv, Date date, String lieu, Integer nbMin, Integer nbMax, Integer nbFormateur) {
		setId(id);
		setUV(uv);
		setDate(date);
		setLieu(lieu);
		setNbMin(nbMin);
		setNbMax(nbMax);
		setNbFormateur(nbFormateur);

	}

	public int getPrio() {
		return prio;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}

	public int getId() {
		return id;
	}

	public UV getUV() {
		return uv;
	}

	public Date getDate() {
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

	public void setUV(UV uv) {
		this.uv = uv;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
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
