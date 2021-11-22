package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.BudgetHandler;
import application.model.BudgetItem;
import application.model.Income.BudgetFreq;
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
	private Text txtSpent;

	@FXML
	private Text txtFreq;

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
	private Text txtIncome;

	@FXML
	void initialize() {

		BudgetHandler handler = BudgetHandler.getInstance();
		textName.setText(handler.getName());
		txtIncome.setText(String.format("%.2f",handler.income.income));
		txtFreq.setText(handler.income.freq + "");

		double reccuring = 0;
		double onetime = 0;
		double total = 0;

		for (BudgetItem item : handler.getItems()) {
			total += item.price;

			if (item.freq == BudgetFreq.ONETIME) {
				onetime += item.price;
				fieldTransaction.appendText(item.name + " - $" + String.format("%.2f", item.price) + "\n");
			} else {
				reccuring += item.price;
				fieldTransaction1.appendText(item.name + " - $" + String.format("%.2f", item.price) + "\n");
			}
		}

		txtSpent.setText(total + "");

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Recurring - %" + (int) ((reccuring / handler.income.income) * 100), reccuring),
				new PieChart.Data("One-Time - %" + (int) ((onetime / handler.income.income) * 100), onetime),
				new PieChart.Data(
						"Remaining - %" + (int) (((handler.income.income - total) / handler.income.income) * 100),
						handler.income.income - total));

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
