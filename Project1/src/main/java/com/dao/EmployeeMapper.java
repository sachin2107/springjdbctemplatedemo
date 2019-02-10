package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Employee;

public class EmployeeMapper implements RowMapper {

	public Employee mapRow(ResultSet rs, int id) throws SQLException {
		System.out.println("into row mapper..");
		Employee e = new Employee();
		e.setId(rs.getInt("ID"));
		e.setName(rs.getString("name"));
		e.setSalary(rs.getFloat("salary"));
		return e;
	}

}
