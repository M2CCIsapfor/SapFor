package view;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import controller.MainApp;
import controller.Tools;
import model.*;

/**
 * CONTROLLER UserView
 * @author francoismoins
 *
 */

public class UserViewController {
	private boolean role; 
		//role = false -> apprenant
		//role = true -> formateur
	
	private boolean uv = false;
	private boolean session = false;
	private UVViewController uvController;
	private SessionsViewController sessionController;
	private ObservableList<SessionObs> listSession;
	private ObservableList<SessionBilan> sessionBilan;
	private List<Session> listInscrit;

	@FXML
	private Button director;
	@FXML
	private Button teacher;
	@FXML
	private Button student;
	@FXML
	private BorderPane listView;
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	@FXML
	private Button sessions;
	
	// Reference to the main application.
	private MainApp mainApp;
	
	/**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public UserViewController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void directorView(){
    	//TODO autorisé l'accès uniquement si l'agent a un rôle de directeur
    	mainApp.showDirectorView();
    }
    
    public void userSessions(){
    	mainApp.showUserSessions();
    }
    
    public void accessListApprenant(){
    	//TODO trier les UV en fonction du rôle de l'agent
    	role = false;
    	try {
    		listView.getChildren().clear();
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(MainApp.class.getResource("/view/UVView.fxml"));
	    	AnchorPane uvView = (AnchorPane) loader.load();
			listView.setCenter(uvView);
			uvController = loader.getController();
			uvController.setMainApp(mainApp);
			uvController.setFather(this);
			uvController.setData();
			uv = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void accessListFormateur(){
	    	//TODO trier les UV en fonction du rôle de l'agent
    	role = true;
    	try {
    		listView.getChildren().clear();
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(MainApp.class.getResource("/view/UVView.fxml"));
	    	AnchorPane uvView = (AnchorPane) loader.load();
			listView.setCenter(uvView);
			uvController = loader.getController();
			uvController.setMainApp(mainApp);
			uvController.setFather(this);
			uvController.setData();
			uv = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	
    }
    
    public void cancel(){
    	if (session){
    		try {
        		listView.getChildren().clear();
    	    	FXMLLoader loader = new FXMLLoader();
    	    	loader.setLocation(MainApp.class.getResource("/view/UVView.fxml"));
    	    	AnchorPane uvView = (AnchorPane) loader.load();
    	    	uv = true;
    			session = false;
    			listView.setCenter(uvView);
    			uvController = loader.getController();
    			uvController.setMainApp(mainApp);
    			uvController.setFather(this);
    			uvController.setData();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    	}
    	else if (uv){
        	listView.getChildren().clear();
    	}
    	else{this.mainApp.showConnexion();}
    }
    
    public void confirm(){
    	if (uv){
    		try {
    			uvController.selected();
        		listView.getChildren().clear();
    	    	FXMLLoader loader = new FXMLLoader();
    	    	loader.setLocation(MainApp.class.getResource("/view/SessionsView.fxml"));
    	    	AnchorPane sessionsView = (AnchorPane) loader.load();
    			listView.setCenter(sessionsView);
    	    	sessionController = loader.getController();
    	    	sessionController.setMainApp(mainApp);
    	    	sessionController.setFather(this);
    	    	sessionController.setData();
    	    	uv = false;
    			session = true;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else if (session){
    		//TODO mise à jour serveur
    		sessionController.listPrioriy(this);
    		this.mainApp.showUserSessions();
    	}
    }
    
    public void setList(ObservableList<SessionObs> listSession){
    	this.listSession = listSession;
    }
    
    public ObservableList<SessionObs> getList(){
    	return this.listSession;
    }
    
    public void setSessionBilan(ObservableList<SessionObs> listSession){
    	sessionBilan = Tools.listeSessionBilan(mainApp.connex.getListSessionCandidatApprenant(), mainApp.connex.getListSessionInscritApprenant(),
    			mainApp.connex.getListSessionCandidatFormateur(), mainApp.connex.getListSessionInscritFormateur(), role, listSession);
    	mainApp.setSessionBilan(sessionBilan);
    }
    
    public void addSessionInscrit(ObservableList<SessionObs> listS){
    	List<Session> list = new ArrayList<Session>();
    	if (!role){
    		list = this.mainApp.connex.getListSessionApprenant();
    		List<Session> result = Tools.listePasObs(listS,list);
    		this.mainApp.connex.postulerApprenant(result);
    	}
    	else{
    		list = this.mainApp.connex.getListSessionFormateur();
    		List<Session> result = Tools.listePasObs(listS,list);
    		this.mainApp.connex.postulerFormateur(result);
    	}
    	
    }
    
    public boolean getRole(){
    	return this.role;
    }
    
	
}
