package com.compositepattern;

public class MinistreOfHealth extends HealthMinister implements Employee{

	private final double SALARY = 15000d;

	public MinistreOfHealth() {
		super.addEmployee(this);
	}
	@Override
	public double getBudget() {
		return SALARY;
	}
	
	

}
