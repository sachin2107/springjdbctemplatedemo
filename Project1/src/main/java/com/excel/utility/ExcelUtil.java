package com.excel.utility;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtil {

	public static <E> void createDetailsFromExcel(ExcelTemplate excelTemplate, E hb1) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		int noOfRows = excelTemplate.getNoOfRows();
		int noOfCols = excelTemplate.getNoOfColumns();
		String cellContent = null;
		String cellData = null;
		
		for(int row=1; row<noOfRows; row++) {
//			HubBean hb = new HubBean();
			hb1 = (E) hb1.getClass().newInstance();
			for(int col=0; col<noOfCols; col++) {
				String propertyName = (String) excelTemplate.getColNames().get(col);
				Cell cell = excelTemplate.getSheet0().getCell(col,row);
				cellContent = cell.getContents();
				if(cellContent !=null && !cellContent.isEmpty()) {
					cellData = cellContent.trim();
					setMethod(excelTemplate, hb1, cellData, propertyName);
				}
			}
			excelTemplate.getAllRowDetails().put(row, hb1);
		}
	}

	private static <E> void setMethod(ExcelTemplate excelTemplate, E hb1, String cellData, String propertyName)
			throws IllegalAccessException, InvocationTargetException {
		Method setMethod = (Method) excelTemplate.getMethodMap().get(propertyName);
		setMethod.invoke(hb1, new Object[] {cellData});
	}

	public static <E> ExcelTemplate createHeaderMapping(ExcelTemplate excelTemplate, E hb) throws Exception {
		int noOfCols = excelTemplate.getNoOfColumns();
		String cellContent = null;
		String cellData = null;

		for(int col=0; col<noOfCols; col++) {
			
			String propertyName = (String) excelTemplate.getColNames().get(col);
			hb = (E) excelTemplate.getBeanClass();
			Cell cell = excelTemplate.getSheet0().getCell(col,0);
			cellContent = cell.getContents();
			if(cellContent !=null && !cellContent.isEmpty()) {
				cellData = cellContent.trim();
				Method setMethod = (Method) excelTemplate.getMethodMap().get(propertyName);
				setMethod.invoke(hb, new Object[] {cellData});
			}
		}
		excelTemplate.getAllRowDetails().put(0, hb);
		return excelTemplate;
	}
	
	public static ExcelTemplate createExcelTemplate(InputStream inputStream, ExcelTemplate excelTemplate, List<String> beanProperties) throws Exception {
		Workbook workbook = Workbook.getWorkbook(inputStream);
		excelTemplate.setWorkbook(workbook);
		
		int noOfRows = excelTemplate.getSheet0().getRows();
		int noOfCols = excelTemplate.getSheet0().getColumns();
		excelTemplate.setNoOfRows(noOfRows);
		excelTemplate.setNoOfColumns(noOfCols);
		excelTemplate.setColNames(beanProperties);
		BeanInfo beanInfo = null;
		beanInfo = Introspector.getBeanInfo(excelTemplate.getBeanClass().getClass());
		PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
		for(int i=0; i<properties.length; i++) {
			PropertyDescriptor propertyDescriptor = properties[i];
			String name = propertyDescriptor.getName();
			Method setMethod = propertyDescriptor.getWriteMethod();
			excelTemplate.getMethodMap().put(name, setMethod);
		}
		return excelTemplate;
}
}