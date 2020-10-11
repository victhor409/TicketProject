package gui;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import entities.Ticket;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.service.TcketService;

public class NewTicketController implements Initializable {
	
	//depencia
	private TcketService service;
	
	@FXML
	private TableView<Ticket> tableviewTicket;
	
	@FXML
	private TableColumn<Ticket, Integer> tablecolumnId;
	
	@FXML
	private TableColumn<Ticket, String>  tablecolumnName;
	
	@FXML
	private TableColumn<Ticket, String>  tablecolumnClient;
	
	@FXML
	private TableColumn<Ticket, String>  tablecolumnCNPJ;
	
	@FXML
	private TableColumn<Ticket, String>  tablecolumnEndereco;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Ticket> obsList;
	
	public void setTicketService(TcketService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		createDialogForm("/gui/Ticketform.fxml",parentStage);
		
	}
	
	@Override
	public void initialize(URL ur, ResourceBundle rb) {
		
		initializeNodes();
		
	}
//iniciar comportamento de coluna para os atributos da classe que sao colunas 
	private void initializeNodes() {
		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tablecolumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tablecolumnClient.setCellValueFactory(new PropertyValueFactory<>("client"));
		tablecolumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		tablecolumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
		//tableview acompanhar o tamanho da janela 
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableviewTicket.prefHeightProperty().bind(stage.heightProperty());
		
		
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Ticket> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableviewTicket.setItems(obsList);
	}
	
	//metodo para ler a janela de dialogo
	private void createDialogForm(String absoluteName,Stage parentStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Ticket data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		}
		catch(IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(),AlertType.ERROR);
		}
	}
	
	
	
	
}
