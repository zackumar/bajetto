package application.model;

import java.util.ArrayList;

public class BudgetHandler {

	public static final BudgetHandler INSTANCE = new BudgetHandler();
	public static BudgetHandler getInstance() {
		return INSTANCE;
	}
	
	public String name;
	public ArrayList<BudgetItem> items;
	public Income income;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<BudgetItem> getItems() {
		return items;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}


}
