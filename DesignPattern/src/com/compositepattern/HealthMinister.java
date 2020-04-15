package com.compositepattern;

import java.util.List;

public class HealthMinister extends PrimeMinister implements Employer {

	private final double SALARY = 40000d; 
	
	public HealthMinister() {
		new MinistreOfHealth();
	}
	
	
	public double getBudgetTotal() {
		double budget = SALARY;
		
		for(Employee employee: employees) {
			budget += employee.getBudget();
		}
	return budget;
	}


	@Override
	public List<Employee> getEmployee() {
		return super.employees;
		
		
	}
	
	
}
