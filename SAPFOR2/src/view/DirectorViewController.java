package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import controller.MainApp;
import model.*;

public class DirectorViewController {
	@FXML
	private TableView StudentsView;
	@FXML 
	private TableView TeachersView;
	@FXML
	private Tab students;
	@FXML
	private TableColumn studentStage;
	@FXML
	private TableColumn studentStageListSessions;
	@FXML
	private TableColumn studentSessionListCandidates;
	@FXML
	private TableColumn studentPriority;
	@FXML
	private Tab teachers;
	@FXML
	private TableColumn teacherStage;
	@FXML
	private TableColumn teacherStageListSessions;
	@FXML
	private TableColumn teacherSessionListCandidates;
	@FXML
	private TableColumn teacherPriority;
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	@FXML
	private Button back;
	// Reference to the main application.
	private MainApp mainApp;
	
	// Reference to the model Agent
	private Agent director;
		
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public DirectorViewController() {
		super();
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		//TODO remplir le tableau de stage
		/*
		 * int n = director.listStages.size();
		 * int i = 0;
		 * while (i<n){
		 * studentStage[i].setText(listStages.get(i).getTitle());
		 * teacherStage[i].setText(listStages.get(i).getTitle());
		 * ...
		 * }
		 */
	}
	
	public void back(){
		this.mainApp.showUserView();
	}
	
	public void cancel(){
		initialize();
	}
	
	public void confirm(){
		//TODO envoyer les modifications au serveur
		this.mainApp.showUserView();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
}
