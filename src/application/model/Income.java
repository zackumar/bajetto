package application.model;

public abstract class Income {
	public enum BudgetFreq {
		WEEKLY, BIWEEKLY, MONTHLY
	}
	public BudgetFreq freq;
	
	//positive values
	public double income;
	public Income(BudgetFreq freq, double income){
		this.freq = freq;
		this.income = income;
	}
}
