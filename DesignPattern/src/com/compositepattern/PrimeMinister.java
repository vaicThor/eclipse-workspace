package com.compositepattern;

public class PrimeMinister extends SimpleEmployer implements Employee{
	
	private final double SALARY = 30000d;

	public PrimeMinister() {
		new MinistreOfHealth();
	}
	
	public double getBudget() {
		
		double budget = SALARY;
		
		for(Employee employee:getEmployees()) {
			budget =+ employee.getBudget();
		}
		return budget;
	}


	
	
}
