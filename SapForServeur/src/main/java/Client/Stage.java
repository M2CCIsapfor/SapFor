package Client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class Stage {
    private List<Session> listeSessions;
    private Agent directeur;

    public Stage() {
    	listeSessions=new ArrayList<Session>();
    	directeur=new Agent();
    }

    public Stage(List<Session> listeSessions, Agent directeur) {
        setListeSessions(listeSessions);
        setDirecteur(directeur);
    }
 
    public List<Session> getListeSessions() {
        return listeSessions;
    }

    public Agent getDirecteur() {
        return directeur;
    }

    public void setListeSessions(List<Session> listeSessions) {
        this.listeSessions = listeSessions;
    }

    public void setDirecteur(Agent directeur) {
        this.directeur = directeur;
    }
}