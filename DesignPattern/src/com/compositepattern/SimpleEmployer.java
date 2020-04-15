package com.compositepattern;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleEmployer {

	protected List<Employee> employees;
	
	public SimpleEmployer() {
		this.employees = new ArrayList<Employee>();
	}
	
	public List<Employee> getEmployees(){
		return this.employees;
	}
	
	public void addEmployee(Employee employee) {
		 employees.add(employee);
	}
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}
	
}
