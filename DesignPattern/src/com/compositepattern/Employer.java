package com.compositepattern;

import java.util.List;

public interface Employer {
	
	public void addEmployee(Employee employee);
	public void removeEmployee(Employee employee);
	public List<Employee> getEmployee();
}
