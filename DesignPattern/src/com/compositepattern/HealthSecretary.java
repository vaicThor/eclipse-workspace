package com.compositepattern;

public class HealthSecretary extends HealthMinister implements Employee{

	private final double SALARY = 12000d;

	
	public HealthSecretary() {
		SimpleEmployer.addEmployee(this);
	}
	@Override
	public double getBudget() {
		return SALARY;
	}
}
