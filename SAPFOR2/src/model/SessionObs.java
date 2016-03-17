/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Christophe
 */
public class SessionObs implements Observable {
    
    protected StringProperty intituleUV;
    protected StringProperty date;
    protected StringProperty lieu;
    protected IntegerProperty priorite;

    public SessionObs(Session session){
        this.intituleUV = new SimpleStringProperty(session.getUV().getNom());
        this.date = new SimpleStringProperty(session.getDate());
        this.lieu = new SimpleStringProperty(session.getLieu());
        this.priorite = new SimpleIntegerProperty(0);
    }
    
    public SessionObs(){
        this.intituleUV = new SimpleStringProperty("");
        this.date = new SimpleStringProperty("");
        this.lieu = new SimpleStringProperty("");
        this.priorite = new SimpleIntegerProperty(0);
    }
    
    public StringProperty getIntituleUV() {
        return intituleUV;
    }

    public void setIntituleUV(StringProperty intituleUV) {
        this.intituleUV = intituleUV;
    }

    public StringProperty getDate() {
        return date;
    }

    public void setDate(StringProperty date) {
        this.date = date;
    }

    public StringProperty getLieu() {
        return lieu;
    }

    public void setLieu(StringProperty lieu) {
        this.lieu = lieu;
    }

    public IntegerProperty getPriorite() {
        return priorite;
    }

    public void setPriorite(IntegerProperty integerProperty) {
        this.priorite = integerProperty;
    }

    
    
    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
