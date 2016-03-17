package view;

import java.util.Iterator;
import java.util.List;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import model.*;
import controller.*;

/**
 * CONTROLLER UVView
 * @author francoismoins
 *
 */

public class UVViewController {
	@FXML
	private TableView<MiniUV> tab;
	@FXML
	private TableColumn<MiniUV,String> listUV;
	@FXML
	private TableColumn<MiniUV,Boolean> select;

	private ObservableList<MiniUV> UVData;	
	private MainApp mainApp;
	private UserViewController userController;
	private List<MiniUV> listSelect;
	private ObservableList<MiniUV> listMiniUV;

	public UVViewController(){
	}
	
	@FXML
	public void initialize(){		
		listUV.setCellValueFactory(cellData -> cellData.getValue().getIntituleProperty());
        select.setCellValueFactory(cellData -> cellData.getValue().checkedProperty());
		select.setCellFactory(CheckBoxTableCell.forTableColumn(select));
		select.setEditable(true);
		tab.setEditable(true);
		}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	public void setFather(UserViewController userController){
		this.userController = userController;
	}
	
	public void setData(){
		if (!userController.getRole()){ //Apprenant
			UVData = (ObservableList<MiniUV>) Tools.listeMiniUV(this.mainApp.connex.getListSessionApprenant());
		}
		else {							//Formateur
			UVData = (ObservableList<MiniUV>) Tools.listeMiniUV(this.mainApp.connex.getListSessionFormateur());
		}
		tab.setItems(UVData);
	}
	
	public void selected(){
		listMiniUV = tab.getItems();
		try{
			listSelect = Tools.listeMiniUVSelectionnees(listMiniUV);
			if (!userController.getRole()){
				this.userController.setList(Tools.listeSession(this.mainApp.connex.getListSessionApprenant(), listSelect));
				}
			else{
				this.userController.setList(Tools.listeSession(this.mainApp.connex.getListSessionFormateur(), listSelect));
				}
			}
		catch (NullPointerException o){
			
		}
		
	}
			

}