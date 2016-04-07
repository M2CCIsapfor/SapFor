package view;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.*;
import controller.*;

/**
 * CONTROLLER SessionView
 * @author francoismoins
 *
 */

@SuppressWarnings("unused")
public class SessionsViewController {
	@FXML
	private TableView<SessionObs> tabSession;
	@FXML
	private TableColumn<SessionObs,String> sessionUV;
	@FXML
	private TableColumn<SessionObs,String> sessionDate;
	@FXML
	private TableColumn<SessionObs,String> sessionPlace;
	@FXML
	private TableColumn<SessionObs,Integer> priority;
	
	private ObservableList<SessionObs> sessionData;
	private ObservableList<SessionObs> sessionInscrit;
	private MainApp mainApp;
	private UserViewController userController;
	
	public SessionsViewController(){
	}
	

	public void intialize(){
		tabSession.setEditable(true);
        sessionUV.setCellValueFactory(cellData -> cellData.getValue().getIntituleUV());
        sessionDate.setCellValueFactory(cellData -> cellData.getValue().getDate());
        sessionPlace.setCellValueFactory(cellData -> cellData.getValue().getLieu());
        priority.setCellValueFactory(cellData -> cellData.getValue().getPriorite().asObject());
        //priority.setEditable(true);
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void setFather(UserViewController userController){
		this.userController = userController;
	}
	
	public void setData(){
		sessionData = (ObservableList<SessionObs>) userController.getList();
		tabSession.setItems(sessionData);
		Iterator<SessionObs> i= sessionData.iterator();
		SessionObs temp;
		while(i.hasNext()){
			temp = i.next();
			System.out.println("Session:"+temp.getIntituleUV().get() + " - " + temp.getDate().get() + " - " + temp.getLieu().get() +"\n");
		}
		tabSession.setVisible(true);
	}
	
//	public void setData(){
//		if (!userController.getRole()){ //Apprenant
//			sessionData = (ObservableList<SessionObs>) Tools.listeSessionObs(this.mainApp.connex.getListSessionApprenant());
//		}
//		else {							//Formateur
//			sessionData = (ObservableList<SessionObs>) Tools.listeSessionObs(this.mainApp.connex.getListSessionFormateur());
//			Iterator<SessionObs> it = sessionData.iterator(); 
//			while(it.hasNext()){
//				System.out.println(it.next().getIntituleUV());
//			}
//		}
//		tabSession.setItems(sessionData);
//	}
	
	public void listPrioriy(UserViewController userController){
		ObservableList<SessionObs> list = tabSession.getItems();
		Iterator<SessionObs> it = list.iterator();
		while (it.hasNext()){
			if(it.next().getPriorite().asObject().get()!=0){
				sessionInscrit.add((SessionObs) it.next());
			}
		}
		//userController.addSessionInscrit(sessionInscrit);
		//userController.setSessionBilan(sessionInscrit);
	}

}