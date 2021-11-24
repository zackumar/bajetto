package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.BudgetHandler;
import application.model.Income;
import application.model.Income.BudgetFreq;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateBudgetController {

    @FXML
    private MenuItem menuMonthly;
    
    @FXML
    private MenuButton menuText;

    @FXML
    private MenuItem menuWeekly;

    @FXML
    private MenuItem menuBiweekly;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldIncome;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnBack;
    
    @FXML 
    private Text txtPayError;
    
    private BudgetFreq curFreq = BudgetFreq.ONETIME;

    @FXML
    void back(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Main.fxml").toURI().toURL();
    	AnchorPane mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void create(ActionEvent event) {
    	if(curFreq==BudgetFreq.ONETIME) {
    		return;
    	}else if(fieldIncome.getText().trim().isEmpty()||fieldName.getText().trim().isEmpty()){
    	}
    	Income newIncome;
    	try {
    		newIncome = new Income(curFreq,Double.parseDouble(fieldIncome.getText()));
    	}catch(NumberFormatException e) {
    		return;
    	}
    	BudgetHandler handler = BudgetHandler.getInstance();
    	handler.income= newIncome;
    	handler.name = fieldName.getText();
    	handler.save();
    	try {
    		URL url = new File("src/application/view/InfoView.fxml").toURI().toURL();
        	AnchorPane mainPane = FXMLLoader.load(url);
        	Scene scene = new Scene(mainPane);
        	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	window.setScene(scene);
        	window.show();
    	}catch(IOException e) {
    		System.out.print("Jacob Messed up");
    		return;
    	}
    	
    }

    @FXML
    void setBiWeekly(ActionEvent event) {
    	menuText.setText("Bi-Weekly");
    	curFreq = BudgetFreq.BIWEEKLY;
    }

    @FXML
    void setMonthly(ActionEvent event) {
    	menuText.setText("Monthy");
    	curFreq = BudgetFreq.MONTHLY;
    }

    @FXML
    void setWeekly(ActionEvent event) {
    	menuText.setText("Weekly");
   	 	curFreq = BudgetFreq.WEEKLY;
    }

}
