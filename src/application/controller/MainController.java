package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button btnCreateBudget;

    @FXML
    private Button btnEditBudget;

    @FXML
    void createBudget(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/CreateBudgetView.fxml").toURI().toURL();
    	AnchorPane mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    	
    }

    @FXML
    void editBudget(ActionEvent event) throws IOException {
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Budget File");
    	File file = fileChooser.showOpenDialog(window);
    	
    	if(file == null) return;
    	if(!file.getName().endsWith(".bajetto")) {
    		Alert a = new Alert(Alert.AlertType.ERROR);
    		a.setContentText("The file you chose is not compatible.");
    		a.show();
    		return;
    	}
    	
    	System.out.println(file.getName());
    	
    	URL url = new File("src/application/view/InfoView.fxml").toURI().toURL();
    	AnchorPane mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);

    	window.setScene(scene);
    	window.show();
    }

}
