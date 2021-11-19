package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class InfoController {

    @FXML
    private PieChart pieSpendings;

    @FXML
    private TextArea fieldTransaction;

    @FXML
    private Button btnAddOneTime;

    @FXML
    private Text textName;

    @FXML
    private TextArea fieldTransaction1;

    @FXML
    private Button btnAddRecurring;
    
    @FXML 
    void initialize() {
    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
    			   new PieChart.Data("RENT", 500), 
    			   new PieChart.Data("NET", 25), 
    			   new PieChart.Data("MOTO G", 10), 
    			   new PieChart.Data("Nokia Lumia", 22)); 
    	
    	pieSpendings.setData(pieChartData);
    	
    	
    }
    

    @FXML
    void addOneTime(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/ExpensesView.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(url);
    	
  
    	ExpensesController controller = new ExpensesController(true);
    	loader.setController(controller);
  
    	AnchorPane mainPane = loader.load();
    	
    	Scene scene = new Scene(mainPane);
    	
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }

    @FXML
    void addRecurring(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/ExpensesView.fxml").toURI().toURL();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(url);
    	
  
    	ExpensesController controller = new ExpensesController();
    	loader.setController(controller);
  
    	AnchorPane mainPane = loader.load();
    	
    	Scene scene = new Scene(mainPane);
    	
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }

}


