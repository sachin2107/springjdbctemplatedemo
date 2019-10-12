package com.excel.utility;
//need jxl-2.6 and common-beanutils-1.7.0 jars
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.model.HubBean;

import jxl.Sheet;
import jxl.Workbook;

public class Test {
	public static void main(String[] args) throws Exception {
		String excelFilePath = "C:\\Users\\HP1\\Desktop\\DummyExcel.xls";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		List<String> hubBeanProperties = beanProperties();
		
		ExcelTemplate<HubBean> excelTemplate = new ExcelTemplate<>();
		HubBean beanObj = new HubBean();
		excelTemplate.setBeanClass(beanObj);
		
		ExcelUtil.createExcelTemplate(inputStream,excelTemplate, hubBeanProperties);
		ExcelUtil.createHeaderMapping(excelTemplate, beanObj);
		System.out.println(excelTemplate);
		ExcelUtil.createDetailsFromExcel(excelTemplate, beanObj);
		System.out.println("end...");
	}

	private static List<String> beanProperties() {
		List<String> hubBeanProperties = new ArrayList<>();
		hubBeanProperties.add("tranche");
		hubBeanProperties.add("subAcctNum");
		hubBeanProperties.add("subProdCode");
		hubBeanProperties.add("cardType");
		hubBeanProperties.add("actualOwnerKey");
		hubBeanProperties.add("cardHldName");
		hubBeanProperties.add("eStmtIndicator");
		hubBeanProperties.add("stmtFrequency");
		hubBeanProperties.add("hubBranchNumber");
		hubBeanProperties.add("errorMsg");
		return hubBeanProperties;
	}
}
