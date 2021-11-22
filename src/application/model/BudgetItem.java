package application.model;

import application.model.Income.BudgetFreq;

public class BudgetItem {
	
	public String name;
	public double price;
	public BudgetFreq freq;
	
	public BudgetItem(String name, double price, BudgetFreq freq) {
		this.name = name;
		this.price = price;
		this.freq = freq;
	}
	
	public String toTsvRow() {
		return name + "\t" + price + "\t" + freq;
	}
	
	
}

