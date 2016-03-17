package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.SessionBilan;
import model.SessionObs;
import controller.MainApp;

/**
 * CONTROLLER UserSessions
 * @author francoismoins
 *
 */

public class UserSessionsController {
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	@FXML
	private Button back;
	@FXML
	private TableView<SessionBilan> tab;
	@FXML
	private TableColumn<SessionBilan, String> sessionUV;
	@FXML
	private TableColumn<SessionBilan, String> sessionDate;
	@FXML
	private TableColumn<SessionBilan, String> sessionPlace;
	@FXML
	private TableColumn<SessionBilan, String> agentRole;
	@FXML
	private TableColumn<SessionBilan, String> sessionStatus;
	
	private MainApp mainApp;
	
	public UserSessionsController(){
		super();
	}
	
	@FXML
	public void initialize(){
		sessionUV.setCellValueFactory(cellData -> cellData.getValue().getIntituleUV());
        sessionDate.setCellValueFactory(cellData -> cellData.getValue().getDate());
        sessionPlace.setCellValueFactory(cellData -> cellData.getValue().getLieu());
        agentRole.setCellValueFactory(cellData -> cellData.getValue().getRoleString());
        sessionStatus.setCellValueFactory(cellData -> cellData.getValue().getStatutString());
		tab.setEditable(true);
	}
	
	public void setData(ObservableList<SessionBilan> listSessionBilan){
		tab.setItems(listSessionBilan);
	}
	
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void back(){
		this.mainApp.showUserView();
	}
	
	public void cancel(){
		this.initialize();
	}
	
	public void confirm(){
		//TODO envoyer au serveur les mises à jour de statut des sessions
	}
}

