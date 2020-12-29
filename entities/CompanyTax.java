package entities;

public class CompanyTax extends Tax {

	private Integer numberEmployee;

	public CompanyTax(String name, Double anualIncome) {
		super(name, anualIncome);
	}

	public CompanyTax(String name, Double anualIncome, Integer numberEmployee) {
		super(name, anualIncome);
		this.numberEmployee = numberEmployee;
	}

	public Integer getNumberEmployee() {
		return numberEmployee;
	}

	public void setNumberEmployee(Integer numberEmployee) {
		this.numberEmployee = numberEmployee;
	}

	@Override
	public double taxPaid() {
		double tax = 0.0;
		if (numberEmployee > 10) {
			tax = getAnualIncome() * 0.14;
		} else {
			tax = getAnualIncome() * 0.16;
		}
		return tax;
	}

}
