package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {

	public void save(Employee e);
	public int insert(Employee e);
	
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public int deleteEmployeeById(int id);
	public int deleteEmpByIdUsingBeanProp(Employee e);
}
