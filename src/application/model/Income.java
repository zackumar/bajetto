package application.model;

public class Income {
	public enum BudgetFreq {
		WEEKLY, BIWEEKLY, MONTHLY, ONETIME
	}
	public BudgetFreq freq;
	
	//positive values
	public double income;
	public Income(BudgetFreq freq, double income){
		this.freq = freq;
		this.income = income;
	}
}
