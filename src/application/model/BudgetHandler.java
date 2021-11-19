package application.model;

import java.util.ArrayList;

public class BudgetHandler {
	public String name;
	public ArrayList<BudgetItem> items;
	public Income income;
	
	public BudgetHandler(String name, Income income){
		this.name = name;
		this.items = new ArrayList<BudgetItem>();
		this.income = income;
	}

}
