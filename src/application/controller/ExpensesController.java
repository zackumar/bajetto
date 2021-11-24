package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.BudgetHandler;
import application.model.BudgetItem;
import application.model.Income;
import application.model.Income.BudgetFreq;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExpensesController {

    @FXML
    private TextField fieldName;

    @FXML
    private Text textMain;

    @FXML
    private MenuItem menuMonthly;

    @FXML
    private MenuItem menuWeekly;

    @FXML
    private MenuItem menuBiweekly;

    @FXML
    private TextField fieldCost;
    
    @FXML
    private Label costerrLabel;
    
    @FXML
    private Label errLabel;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnBack;
    
    @FXML
    private MenuButton freqMenuButton;
    
    private boolean isOneTime = false;
    
    private BudgetFreq curFreq = BudgetFreq.ONETIME;
    public ExpensesController() {}
    
    public ExpensesController(boolean isOneTime) {
    	this.isOneTime = isOneTime;
    }
    
    @FXML
    private void initialize() {
    	if(isOneTime) {
    		textMain.setText("Add One-Time Transaction");
    		freqMenuButton.setOpacity(0);
    		freqMenuButton.setDisable(true);
    	}
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/InfoView.fxml").toURI().toURL();
    	AnchorPane mainPane = FXMLLoader.load(url);
    	Scene scene = new Scene(mainPane);
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void create(ActionEvent event) throws Exception {
    	if((fieldName.getText().equals("")) && (fieldCost.getText().equals(""))) {
    		errLabel.setText("Both Fields cannot be blank!");
    		throw new Exception("Both Fields cannot be blank!");
    	}
    	else if(fieldCost.getText().equals("")) {
    		errLabel.setText("Transaction Cost cannot be blank!");
    		throw new Exception("Transaction Cost cannot be blank!");
    	}
    	else if((fieldName.getText().equals(""))) {
    		errLabel.setText("Transaction Name cannot be blank!");
    		throw new Exception("Transaction Name cannot be blank!");
    	}
		try
		{
		  Double.parseDouble(fieldCost.getText());
		}
		catch(NumberFormatException e)
		{
			costerrLabel.setText("Transaction Cost is not a double!");
			throw new Exception("Transaction Cost is not a double!");
		}
		
    	BudgetHandler handler = BudgetHandler.getInstance();
    	BudgetItem newItem = new BudgetItem(null, 0, curFreq);
    	//handler.addItem((fieldName.getText(), fieldCost.getText(), curFreq);
    	try {
    		URL url = new File("src/application/view/InfoView.fxml").toURI().toURL();
        	AnchorPane mainPane = FXMLLoader.load(url);
        	Scene scene = new Scene(mainPane);
        	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	window.setScene(scene);
        	window.show();
    	}catch(IOException e) {
    		return;
    	}
		
    }

    @FXML
    void setBiWeekly(ActionEvent event) {
    	freqMenuButton.setText("BiWeekly");
    	curFreq = BudgetFreq.BIWEEKLY;
    }

    @FXML
    void setMonthly(ActionEvent event) {
    	freqMenuButton.setText("Monthly");
    	curFreq = BudgetFreq.MONTHLY;
    }

    @FXML
    void setWeekly(ActionEvent event) {
    	freqMenuButton.setText("Weekly");
    	curFreq = BudgetFreq.WEEKLY;
    }

}
