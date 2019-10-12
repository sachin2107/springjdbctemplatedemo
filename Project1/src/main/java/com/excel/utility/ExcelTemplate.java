package com.excel.utility;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.HubBean;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelTemplate<T> {
	
	private Integer noOfRows;
	private Integer noOfColumns;
	private List<String> colNames;
//	private Map<Integer,String> propColNameMapping = new HashMap<>();
	private Map<Integer, HubBean> allRowDetails = new HashMap<>();
	private Workbook workbook;
	private Sheet sheet0;
	private T beanClass;
	private Map<String, Method> methodMap = new HashMap<>();
	
	public Integer getNoOfRows() {
		return noOfRows;
	}
	public void setNoOfRows(Integer noOfRows) {
		this.noOfRows = noOfRows;
	}
	public Integer getNoOfColumns() {
		return noOfColumns;
	}
	public void setNoOfColumns(Integer noOfColumns) {
		this.noOfColumns = noOfColumns;
	}
	public List<String> getColNames() {
		return colNames;
	}
	public void setColNames(List<String> colNames) {
		this.colNames = colNames;
	}
	/*public Map<Integer, String> getPropColNameMapping() {
		return propColNameMapping;
	}
	public void setPropColNameMapping(Map<Integer, String> propColNameMapping) {
		this.propColNameMapping = propColNameMapping;
	}*/
	public Map<Integer, HubBean> getAllRowDetails() {
		return allRowDetails;
	}
	public void setAllRowDetails(Map<Integer, HubBean> allRowDetails) {
		this.allRowDetails = allRowDetails;
	}
	public Workbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
		this.sheet0 = this.workbook.getSheet(0);
	}
	public Sheet getSheet0() {
		return sheet0;
	}
	public void setSheet0(Sheet sheet0) {
		this.sheet0 = sheet0;
	}
	public T getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(T beanClass) {
		this.beanClass = beanClass;
	}
	public Map<String, Method> getMethodMap() {
		return methodMap;
	}
	public void setMethodMap(Map<String, Method> methodMap) {
		this.methodMap = methodMap;
	}
	
}
