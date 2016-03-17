package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import controller.*;
import model.*;

public class ConnexionController {
	@FXML
	private TextField matricule;
	@FXML
	private PasswordField password;
	@FXML
	private Button connect;
	
	// Reference to the main application.
	private MainApp mainApp;
	private Agent agent;
	
	 /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ConnexionController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        password.setText("password");
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void connect(){
    	//TODO chargement des données serveur
    	String matricule = this.matricule.getText();
    	String password = this.password.getText();
    	this.mainApp.connex = new ConnexionCS(matricule, password);
    	this.mainApp.showUserView();
    }
	

}
