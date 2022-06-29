package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Taxpayer;
import entities.Individual;
import entities.Company;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayer> taxpayer = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) +" data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			ch = Character.toUpperCase(ch);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if (ch == 'I') {
				System.out.print("Health expenditures: ");
				Double healthExp = sc.nextDouble();
				taxpayer.add(new Individual(name, anualIncome, healthExp));
			}
			else if (ch == 'C') {
				System.out.print("Number of employees: ");
				int numEmp = sc.nextInt();
				taxpayer.add(new Company(name, anualIncome, numEmp));
				
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double totalTaxes = 0;
		for (Taxpayer tp: taxpayer ) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " 
			+ String.format("%.2f", tax));
			totalTaxes += tax; 
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $" + totalTaxes);
		
		
		sc.close();
		

	}

}
