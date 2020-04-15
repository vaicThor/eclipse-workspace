package com.compositepattern;

public class ChefHospital extends HospitalPublicDirector implements Employee{

	private final double SALARY = 2500d; 
	
	public ChefHospital() {
		super.addEmployee(this);
	}
	
	@Override
	public double getBudget() {
		return SALARY;
	}
}
