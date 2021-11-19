package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InfoController {

    @FXML
    private TextField fieldNewTransaction;

    @FXML
    private PieChart pieSpendings;

    @FXML
    private TextArea fieldTransaction;

    @FXML
    private Button btnAddTransaction;

    @FXML
    private Text textName;

    @FXML
    private TextArea fieldTransaction1;

    @FXML
    private Button btnAddTransaction1;

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
    void addTransaction(ActionEvent event) {

    }

}
