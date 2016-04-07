/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Christophe
 */
public class SessionBilan extends SessionObs{

    private BooleanProperty role; //true=formateur; false=apprenant
    private BooleanProperty statut; //true=inscrit; false=candidat
    
    public SessionBilan(Session session, boolean role, boolean statut){
        super(session);
        this.role = new SimpleBooleanProperty(role);
        this.statut = new SimpleBooleanProperty(statut);
    }
    
    public SessionBilan(){
        super();
        this.role = new SimpleBooleanProperty(false);
        this.statut = new SimpleBooleanProperty(false);
    }

    public BooleanProperty getRole() {
        return role;
    }

    public void setRole(BooleanProperty role) {
        this.role = role;
    }

    public BooleanProperty getStatut() {
        return statut;
    }

    public void setStatut(BooleanProperty statut) {
        this.statut = statut;
    }
    
    public StringProperty getRoleString(){
        if(this.role==new SimpleBooleanProperty(true)){
            return new SimpleStringProperty("Formateur");
        }
        else{
            return new SimpleStringProperty("Apprenant");
        }
    }
    
    public StringProperty getStatutString(){
        if(this.statut==new SimpleBooleanProperty(true)){
        	return new SimpleStringProperty("Inscrit");
        }
        else{
        	return new SimpleStringProperty("Candidat");
        }
    }
    
}
