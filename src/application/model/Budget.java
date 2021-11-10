package application.model;

public class Budget extends Income {
	
	//positive values
	public double scholarships;

	//negative values
	public double rent;
	public double tuition;
	public double utilities;
	
	//one time purchase
	public double books;
	
	//tells us if it has been sorted by the Budget frequency;
	public boolean sorted = false;
	
	public Budget(Income income, double scholar, double rent, double tuition, double utilities, double books) {
		super(income.freq,income.income);
		this.scholarships = scholar;
		this.rent = rent;
		this.tuition = tuition;
		this.utilities = utilities;
		this.books = books;
		
	}
	
	//WEEKLY, BIWEEKLY, MONTHLY
	public void sortBudget(Budget bud) {
		if(bud.sorted) {
			return;
		}else {
			switch(bud.freq) {
				case MONTHLY: 
					bud.sorted = true;
					break;
					
				case WEEKLY: 
					bud.scholarships = bud.scholarships/4;
					bud.rent = bud.rent/4;
					bud.utilities = bud.utilities/4;
					bud.sorted = true;
					break;
					
				case BIWEEKLY:
					bud.scholarships = bud.scholarships/2;
					bud.rent = bud.rent/2;
					bud.utilities = bud.utilities/2;
					bud.sorted = true;
					break;
			}
		}
		return;
	}
}
	