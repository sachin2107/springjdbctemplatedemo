package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.model.Employee;

public class EmployeeDaoImpl extends NamedParameterJdbcDaoSupport implements EmployeeDao {
//added extends NamedParameterJdbcdDaoSupport-- due to this no need to inject namedParameterJdbcTemplate
//in *DaoImpl.java class.  We can directly use getNamedParameterJdbcTemplate() method
//commented namedParameterJdbcTemplate and bean also commented from spring-servlet.xml
	/*NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}*/

	@Override
	public void save(Employee e) {
		String SQL = "INSERT INTO Employee (id, name, salary) VALUES (:id, :name, :salary)";
	      Map<String,Object> namedParameters = new HashMap(); 
	      namedParameters.put("id", e.getId());
	      namedParameters.put("name", e.getName());   
	      namedParameters.put("salary", e.getSalary());
//	      this.namedParameterJdbcTemplate.update(SQL, namedParameters);
	      getNamedParameterJdbcTemplate().update(SQL, namedParameters);
	}

	
	@Override
	public int insert(Employee e) {
		String SQL = "INSERT INTO Employee (id, name, salary) VALUES (:id, :name, :salary)";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(e);
		int rowsEffected = getNamedParameterJdbcTemplate().update(SQL, namedParameters);
		return rowsEffected;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String SQL = "SELECT * FROM Employee WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
		Employee employee = (Employee) getNamedParameterJdbcTemplate().queryForObject(SQL, namedParameters, new EmployeeMapper());
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String SQL = "SELECT * FROM Employee";
		MapSqlParameterSource sqlParameters = new MapSqlParameterSource();
		List employee = getNamedParameterJdbcTemplate().query(SQL,sqlParameters,new EmployeeMapper());
		return employee;
	}

	@Override
	public int deleteEmployeeById(int id) {
		String SQL = "DELETE FROM EMPLOYEE WHERE id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
		return getNamedParameterJdbcTemplate().update(SQL, namedParameters);
	}

	@Override
	public int deleteEmpByIdUsingBeanProp(Employee e) {
		String SQL = "DELETE FROM EMPLOYEE WHERE id = :id";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(e);
		return getNamedParameterJdbcTemplate().update(SQL, namedParameters);
	}

}
