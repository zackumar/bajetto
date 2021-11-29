package application;
	
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import application.model.BudgetHandler;
import application.model.BudgetItem;
import application.model.Income;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/view/Main.fxml").toURI().toURL();
			URL cssUrl = new File("src/application/view/fonts.css").toURI().toURL();
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
			
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(cssUrl.toExternalForm());
			primaryStage.setTitle("Bajetto - The Budgeting App");

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
//		BudgetHandler handler = BudgetHandler.getInstance();
//		handler.read("./Name.bajetto");
//		System.out.println(handler.toString());
//		
//		ArrayList<BudgetItem> items = handler.getItems();
//		
//		handler.setName("Bajetto Test File");
//		handler.income = new Income(Income.BudgetFreq.MONTHLY, 5000);
//		
//		items.add(new BudgetItem("Monthly", 1000, Income.BudgetFreq.MONTHLY));
//		items.add(new BudgetItem("Test 2", 2000, Income.BudgetFreq.WEEKLY));
//		items.add(new BudgetItem("Test 3", 3000, Income.BudgetFreq.BIWEEKLY));
//		items.add(new BudgetItem("Test 3", 3000, Income.BudgetFreq.ONETIME));
//		
//		handler.save();
	}
}
