package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.TcketService;

public class TicketController implements Initializable {

	@FXML
	private MenuItem menuItemNewTicket;
	
	@FXML
	private MenuItem menuItemAbout;
	
	
	@FXML
	public void OnActionMenuItemNewTicket() {
		loadView2("/gui/TicketController.fxml");
	}
	
	@FXML
	public void OnActionMenuItemAbout() {
		loadView("/gui/About.fxml");
	}

	@Override
	public void initialize(URL ur, ResourceBundle rb) {
	
	}
	
	//funcao para abrir uma outra tela
	private synchronized void loadView(String absoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVBox = loader.load();
		
		//instancia vinda da classe principal (referencia)
		Scene mainScene = Main.getMainScene();
		
		//referencia de nodos do FXML onde ScrollPane tem o seu nodo vbox e content.
		VBox mainVBox =(VBox)( (ScrollPane)mainScene.getRoot()).getContent();
		
		//manipulação de janela principal 
		Node mainMenu = mainVBox.getChildren().get(0);
		mainVBox.getChildren().clear();
		mainVBox.getChildren().add(mainMenu);
		mainVBox.getChildren().addAll(newVBox.getChildren());
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro Load View", e.getMessage(), AlertType.ERROR);
		}
	}
	
	//funcao para abrir uma outra tela
		private synchronized void loadView2(String absoluteName) {
			try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			//instancia vinda da classe principal (referencia)
			Scene mainScene = Main.getMainScene();
			
			//referencia de nodos do FXML onde ScrollPane tem o seu nodo vbox e content.
			VBox mainVBox =(VBox)( (ScrollPane)mainScene.getRoot()).getContent();
			
			//manipulação de janela principal 
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			//injecao de depencia manual
			NewTicketController controller = loader.getController();
			controller.setTicketService(new TcketService());
			controller.updateTableView();
			
			}
			catch (IOException e) {
				Alerts.showAlert("IO Exception", "Erro Load View", e.getMessage(), AlertType.ERROR);
			}
		}
	
	
}
