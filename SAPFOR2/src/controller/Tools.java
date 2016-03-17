package controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christophe
 */
public class Tools {
	
    /**
     * 
     * @param listeSessions
     * @return
     */
    static public ObservableList<MiniUV> listeMiniUV(List<Session> listeSessions){
        ObservableList<MiniUV> data = FXCollections.observableArrayList();
        Iterator<Session> iterator = listeSessions.listIterator();
        List<UV> temp = new ArrayList<UV>();
        while (iterator.hasNext()) {
            Session session = iterator.next();
            if (!temp.contains(session.getUV())){
            MiniUV miniUV = new MiniUV(session.getUV());
            if(!data.contains(miniUV)){
                data.add(miniUV);
            }
            temp.add(session.getUV());
            }
        }
        return data;
    }
    
    /**
     * 
     * @param listeSessions
     * @return
     */
    static public ObservableList<SessionObs> listeSessionObs(List<Session> listeSessions){
        ObservableList<SessionObs> data = FXCollections.observableArrayList();
        Iterator<Session> iterator = listeSessions.listIterator();
        while (iterator.hasNext()) {
            Session session = iterator.next();
            SessionObs sessionObs = new SessionObs(session);
            if(!data.contains(sessionObs)){
                data.add(sessionObs);
            }
        }
        return data;
    }
    
    /**
     * 
     * @param liste
     * @param miniUV
     * @return
     */
    static public ObservableList<SessionObs> listeSession(List<Session> liste, MiniUV miniUV){
        ObservableList<SessionObs> data = FXCollections.observableArrayList();
        Iterator<Session> iterator = liste.listIterator();
        while (iterator.hasNext()){
            Session session = iterator.next();
            StringProperty nomUVSession = new SimpleStringProperty(session.getUV().getNom());
            if((nomUVSession==miniUV.getIntituleProperty()) && (!data.contains(session))){
                SessionObs so = new SessionObs(session);
                data.add(so);
            }
        }
        return data;
    }
    /**
     * 
     * @param liste
     * @return
     */
    static public List<MiniUV> listeMiniUVSelectionnees(ObservableList<MiniUV> liste){
        List<MiniUV> miniUVSelectionnees = new ArrayList<MiniUV>();
        Iterator<MiniUV> iterator = liste.listIterator();
        while(iterator.hasNext()){
            MiniUV miniUV = iterator.next();
            if(miniUV.getChecked()){
                miniUVSelectionnees.add(miniUV);
            }
        }
        return miniUVSelectionnees;
    }
    /**
     * 
     * @param listeS
     * @param listeUV
     * @return
     */
    static public ObservableList<SessionObs> listeSession(List<Session> listeS, List<MiniUV> listeUV){
        ObservableList<SessionObs> data = FXCollections.observableArrayList();
        Iterator<Session> iterator = listeS.listIterator();
        while (iterator.hasNext()){
            Session session = iterator.next();
            //StringProperty nomUVSession = new SimpleStringProperty(session.getUV().getNom());
            Iterator<MiniUV> iterator2 = listeUV.listIterator();
            while (iterator2.hasNext()){
                MiniUV miniUV = iterator2.next();
                    if((session.getUV().getNom()==miniUV.getIntituleProperty().getValue()) ){
                        SessionObs so = new SessionObs(session);
                        if(!data.contains(so)){
                            data.add(so);
                        }
                    }
            }
        }
        return data;
    }

    /**
     * 
     * @param listeSAC
     * @param listeSAI
     * @param listeSFC
     * @param listeSFI
     * @param role
     * @param liste
     * @return
     */
    static public ObservableList<SessionBilan> listeSessionBilan(List<Session> listeSAC, List<Session> listeSAI, List<Session> listeSFC, 
            List<Session> listeSFI, boolean role, ObservableList<SessionObs> liste){
        
        ObservableList<SessionBilan> data = FXCollections.observableArrayList();
        
        Iterator<Session> iterator = listeSAC.listIterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            SessionBilan sb = new SessionBilan(s,false,false);
            data.add(sb);
        }
        iterator = listeSAI.listIterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            SessionBilan sb = new SessionBilan(s,false,true);
            data.add(sb);
        }
        iterator = listeSFC.listIterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            SessionBilan sb = new SessionBilan(s,true,false);
            data.add(sb);
        }
        iterator = listeSFI.listIterator();
        while(iterator.hasNext()){
            Session s = iterator.next();
            SessionBilan sb = new SessionBilan(s,true,true);
            data.add(sb);
        }
        
        Iterator<SessionObs> iterator2 = liste.listIterator();
        while(iterator2.hasNext()){
            SessionObs so = iterator2.next();
            SessionBilan sb = new SessionBilan();
            sb.setIntituleUV(so.getIntituleUV());
            sb.setDate(so.getDate());
            sb.setLieu(so.getLieu());
            sb.setPriorite(so.getPriorite());
            sb.setRole(new SimpleBooleanProperty(role));
            sb.setStatut(new SimpleBooleanProperty(false));
            data.add(sb);
        }
        return data;
    }
    static public List<Session> listePasObs(ObservableList<SessionObs> liste, List<Session> listeRef){
        List<Session> listeRetour = new ArrayList<Session>();
        Iterator<SessionObs> iterator = liste.listIterator();
        while(iterator.hasNext()){
            SessionObs so = iterator.next();
            Session s = new Session((int)Math.random(),getUVNom(so.getIntituleUV().getValue(),listeRef),so.getDate().getValue(),so.getLieu().getValue(),0,0,0);
            listeRetour.add(s);
        }
        return listeRetour;
    }
    
    static public UV getUVNom(String nom, List<Session> listeRef){
        Iterator<Session> itr = listeRef.listIterator();
        while(itr.hasNext()){
            Session s = itr.next();
            if(nom==s.getUV().getNom()){
                return s.getUV();
            }
        }
        return null;
    }
    
}