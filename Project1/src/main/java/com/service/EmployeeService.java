package com.service;

import java.util.List;

import com.model.Employee;
import com.model.FileData;

public interface EmployeeService {

	public void save(Employee e);
	public int insert(Employee e);
	
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public int deleteEmployeeById(int id);
	public int deleteEmpByIdUsingBeanProp(Employee e);
	public void insertFileData(FileData fileData);
}
