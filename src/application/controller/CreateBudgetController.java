package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.BudgetHandler;
import application.model.Income;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CreateBudgetController {

    @FXML
    private MenuItem menuMonthly;

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
		String budname;
		double incomeDub;
		BudgetHandler newBud;
    	
    	try {
    		budname = fieldName.getText();
    		incomeDub = Double.parseDouble(fieldIncome.getText());
    		Income income = new Income(incomeDub,BIWEEKLY);
    		BudgetHandler newbud = new BudgetHandler(budname,income);
    	} catch( Exception e){
    		
    	}
    }

    @FXML
    void setBiWeekly(ActionEvent event) {

    }

    @FXML
    void setMonthly(ActionEvent event) {

    }

    @FXML
    void setWeekly(ActionEvent event) {

    }

}
