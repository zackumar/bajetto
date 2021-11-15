package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class CreateBudgetController {
	
	@FXML
    private MenuButton menuButton;
	
	@FXML
	private MenuItem action1;

	@FXML
	private MenuItem action2;
	
	@FXML
    void action1Clicked(ActionEvent event) {
		System.out.println("action 1 clicked");
	}
}
