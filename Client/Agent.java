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
 * @author Yannick - Abdourahman - François
 */
public class Agent {

    private String matricule = new String();
    private String nom = new String();
    private String prenom = new String();
    private String cleHashage = new String();
    private List<Session> listeSessionsApprenantInscrit = new ArrayList<Session>();
    private List<Session> listeSessionsApprenantAccessibles = new ArrayList<Session>();
    private List<Session> listeSessionsFormateurInscrit = new ArrayList<Session>();
    private List<Session> listeSessionsFormateurAccessibles = new ArrayList<Session>();
    private List<UV> uvValidees =  new ArrayList<UV>();
    private List<Stage> listStages = new ArrayList<Stage>(); // pour le directeur

    /**
     * constructeur vide de l'agent
     */
    public Agent() {
    	super();
    }

    /**
     * constructeur de l'agent
     *
     * @param matricule
     */
    public Agent(String matricule) {
        setMatricule(matricule);
    }

    /**
     * constructeur de l'agent
     *
     * @param matricule de l'agent
     * @param nom de l'agent
     */
    public Agent(String matricule, String nom) {
        setMatricule(matricule);
        setNom(nom);
    }

    /**
     * constructeur de l'agent
     *
     * @param matricule
     * @param nom
     * @param prenom
     */
    public Agent(String matricule, String nom, String prenom) {
        setMatricule(matricule);
        setNom(nom);
        setPrenom(prenom);
    }

    /**
     *
     * @return matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     *
     * @return nom de l'agent
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return prenom de l'agent
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return liste de sessions auxquelles l'agent est inscrit en tant qu'Apprenant
     */
    public List<Session> getListeSessionsApprenantInscrit() {
        return listeSessionsApprenantInscrit;
    }
    
    /**
    *
    * @return liste de sessions auxquelles l'agent est candidat en tant qu'Apprenant
    */
   public List<Session> getListeSessionsApprenantCandidat() {
       return listeSessionsApprenantCandidat;
   }

    /**
     *
     * @return liste de sessions sessions auxquelles l'agent est inscrit tant que formateur
     */
    public List<Session> getListeSessionsFormateurInscrit() {
        return listeSessionsFormateurInscrit;
    }
    
    /**
    *
    * @return liste de sessions sessions auxquelles l'agent est candidat tant que formateur
    */
   public List<Session> getListeSessionsFormateurCandidat() {
       return listeSessionsFormateurCandidat;
   }

    /**
     * setter du matricule de l agent
     *
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * setter du nom de l'agent
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * setter du prenom de l'agent
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * setter de la liste des sessions auxquelles l'agent est inscrit en tant qu
     * apprenant
     *
     * @param listeSessionsApprenant
     */
    public void setListeSessionsApprenantInscrit(List<Session> listeSessionsApprenant) {
        this.listeSessionsApprenantInscrit = listeSessionsApprenant;
    }
    
    /**
     * setter de la liste des sessions auxquelles l'agent est candidat en tant qu
     * apprenant
     *
     * @param listeSessionsApprenant
     */
    public void setListeSessionsApprenantCandidat(List<Session> listeSessionsApprenant) {
        this.listeSessionsApprenantCandidat = listeSessionsApprenant;
    }

    /**
     * setter de la liste des sessions auxquelles l'agent est inscrit en tant qu
     * formateur
     *
     * @param listeSessionsApprenant
     */
    public void setListeSessionsFormateurtInscrit(List<Session> listeSessionsFormateur) {
        this.listeSessionsFormateurInscrit = listeSessionsFormateur;
    }
    
    /**
     * setter de la liste des sessions auxquelles l'agent est candidat en tant qu
     * formateur
     *
     * @param listeSessionsApprenant
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
}
