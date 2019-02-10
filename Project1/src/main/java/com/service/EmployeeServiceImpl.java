package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void save(Employee e) {
		this.employeeDao.save(e);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return this.employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return this.employeeDao.getAllEmployees();
	}

	@Override
	public int deleteEmployeeById(int id) {
		return this.employeeDao.deleteEmployeeById(id);
	}

	@Override
	public int deleteEmpByIdUsingBeanProp(Employee e) {
		return this.employeeDao.deleteEmpByIdUsingBeanProp(e);
	}

	@Override
	public int insert(Employee e) {
		return this.employeeDao.insert(e);
	}
	
	
}
