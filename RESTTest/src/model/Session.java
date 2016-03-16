/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yannick - Abdourahman
 */

@XmlRootElement
public class Session {
	private SessionT sessionT;
	private List<Agent> listeApprenants;
	private List<Agent> listeFormateurs;

	public Session() {
		this.sessionT = new SessionT();
		this.listeApprenants = new ArrayList<Agent>();
		this.listeFormateurs = new ArrayList<Agent>();

	}

	public Session(int id, UV uv, Date date, String lieu, Integer nbMin, Integer nbMax, Integer nbFormateur) {
		this.sessionT = new SessionT(id, uv, date, lieu, nbMin, nbMax, nbFormateur);
		this.listeApprenants = new ArrayList<Agent>();
		this.listeFormateurs = new ArrayList<Agent>();

	}

	public int getPrio() {
		return sessionT.getPrio();
	}

	public void setPrio(int prio) {
		this.sessionT.setPrio(prio);
	}

	public int getId() {
		return this.sessionT.id;
	}

	public UV getUV() {
		return this.sessionT.uv;
	}

	public Date getDate() {
		return this.sessionT.date;
	}

	public String getLieu() {
		return this.sessionT.lieu;
	}

	public Integer getNbMin() {
		return this.sessionT.nbMin;
	}

	public Integer getNbMax() {
		return this.sessionT.nbMax;
	}

	public Integer getNbFormateur() {
		return this.sessionT.nbFormateur;
	}

	public List<Agent> getListeApprenants() {
		return listeApprenants;
	}

	public List<Agent> getListeFormateurs() {
		return listeFormateurs;
	}

	public void setUV(UV uv) {
		this.sessionT.setUV(uv);
	}

	public void setId(int id) {
		this.sessionT.setId(id);
	}

	public void setDate(Date date) {
		this.sessionT.setDate(date);
	}

	public void setLieu(String lieu) {
		this.sessionT.setLieu(lieu);
	}

	public void setNbMin(Integer nbMin) {
		this.sessionT.setNbMin(nbMin);
	}

	public void setNbMax(Integer nbMax) {
		this.sessionT.setNbMax(nbMax);
	}

	public void setNbFormateur(Integer nbFormateur) {
		this.sessionT.setNbFormateur(nbFormateur);
	}

	public void setListeApprenants(List<Agent> listeApprenants) {
		this.listeApprenants = listeApprenants;
	}

	public void setListeFormateurs(List<Agent> listeFormateurs) {
		this.listeFormateurs = listeFormateurs;
	}

	public SessionT getSessionT() {
		return sessionT;
	}

	public void setSessionT(SessionT sessionT) {
		this.sessionT = sessionT;
	}

}
