package entities;

public class IndividualTax extends Tax {

	private Double healthExpenditures;

	public IndividualTax(String name, Double anualIncome) {
		super(name, anualIncome);
	}

	public IndividualTax(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double taxPaid() {
		double tax = 0.0;
		if (getAnualIncome() <= 20000.00) {
			tax = getAnualIncome() * 0.15;
		} else if (getAnualIncome() > 20000.00) {
			tax = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.5);
		}
		return tax;
	}

}
