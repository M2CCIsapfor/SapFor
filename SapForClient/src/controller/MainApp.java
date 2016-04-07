package controller;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MiniUV;
import model.Session;
import model.SessionBilan;
import model.SessionObs;
import view.ConnexionController;
import view.UserViewController;
import view.DirectorViewController;
import view.UserSessionsController;

/**
 * Main of the Application
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	public ConnexionCS connex;
	private ObservableList<SessionBilan> listeSessionBilan;

    
    /**
     * Constructor without paramaters
     */
    public MainApp(){
    }
	
    /**
     * Starting Page
     */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SapFor 2016");
		initRootLayout();
		showConnexion();
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Connection view inside the root layout.
     */
    public void showConnexion() {
    	
        try {
            // Load connexion view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/Connexion.fxml"));
            AnchorPane connexion = (AnchorPane) loader.load();
            // Set connexion into the center of root layout.
            rootLayout.setCenter(connexion);
            
            // Give the controller access to the main app.
            ConnexionController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the User view inside the root layout.
     */
    public void showUserView(){
    	try {
            // Load userView view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/UserView.fxml"));
            AnchorPane userView = (AnchorPane) loader.load();

            // Set userView into the center of root layout.
            rootLayout.setCenter(userView);
            
            // Give the controller access to the main app.
            UserViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the Director view inside the root layout.
     */
    public void showDirectorView(){
    	try {
            // Load userView view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/DirectorView.fxml"));
            AnchorPane directorView = (AnchorPane) loader.load();

            // Set userView into the center of root layout.
            rootLayout.setCenter(directorView);
            
            // Give the controller access to the main app.
            DirectorViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Shows the User sessions inside the root layout.
     */
    public void showUserSessions(){
    	try {
            // Load userView view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/UserSessions.fxml"));
            AnchorPane userSessions = (AnchorPane) loader.load();

            // Set userView into the center of root layout.
            rootLayout.setCenter(userSessions);
            UserSessionsController controller = loader.getController();
            controller.setMainApp(this);
            controller.setData(listeSessionBilan);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Setter of tje Session Bilan
     * @param listeSessionBilan List of SessionBilan
     */
    public void setSessionBilan(ObservableList<SessionBilan> listeSessionBilan){
    	this.listeSessionBilan = listeSessionBilan;
    }

    /**
     * Main
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
	}
}
