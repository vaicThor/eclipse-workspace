package com.compositepattern;

public class HospitalPublicDirector extends HealthMinister implements Employee{

	private final double SALARY = 5000d;

	public HospitalPublicDirector() {
		super.addEmployee(this);
	}
	@Override
	public double getBudget() {
		return SALARY;
	}
}

