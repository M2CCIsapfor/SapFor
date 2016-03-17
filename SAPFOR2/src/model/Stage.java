/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yannick - Abdourahman
 */
public class Stage {
    private List<Session> listeSessions = new ArrayList<Session>();
    private String title = new String();
    private Agent directeur =  new Agent();

    public Stage() {
    }

    public Stage(String name, List<Session> listeSessions, Agent directeur) {
    	setTitle(name);
        setListeSessions(listeSessions);
        setDirecteur(directeur);
    }
 
    public List<Session> getListeSessions() {
        return listeSessions;
    }

    public Agent getDirecteur() {
        return directeur;
    }
    
    public String getTitle(){
    	return title;
    }

    public void setListeSessions(List<Session> listeSessions) {
        this.listeSessions = listeSessions;
    }

    public void setDirecteur(Agent directeur) {
        this.directeur = directeur;
    }
    
    public void setTitle(String title){
    	this.title = title;
    }
}
