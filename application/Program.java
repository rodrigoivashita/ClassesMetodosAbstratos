package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyTax;
import entities.IndividualTax;
import entities.Tax;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Tax> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		System.out.println("-------------------------------");
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new IndividualTax(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employee: ");
				int numberEmployee = sc.nextInt();
				list.add(new CompanyTax(name, anualIncome, numberEmployee));
			}

		}
		System.out.println("-------------------------------");
		System.out.println("TAXES PAID:");
		for (Tax tax : list) {
			System.out.println(tax.getName() + ": $ " + String.format("%.2f", tax.taxPaid()));
		}
		double sum = 0.0;
		for (Tax tax1 : list) {
			sum += tax1.taxPaid();
		}
		System.out.println("-------------------------------");
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();
	}
}
