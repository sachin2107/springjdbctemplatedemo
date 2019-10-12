package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Employee;
import com.model.FileData;
import com.service.EmployeeService;

@Controller
public class EmployeeController{
		
	@Autowired
	private EmployeeService employeeService;
	public EmployeeService getEmployeeService() {
		return employeeService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
		System.out.println("inside... ");
	}

	
	@RequestMapping(value="/signup")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		return new ModelAndView("detail");
	}
	
	@RequestMapping(value="/wel")
	public ModelAndView welcome1(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		return new ModelAndView("welcome");
	}
	

	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		return new ModelAndView("login","msg","login() method..");
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("Employee")Employee e) throws IOException
	{
//		List emp = this.employeeService.getAllEmployees();
//		this.employeeService.save(e);
//		if(e.getName().equalsIgnoreCase("delete"))
//		{
//			int x = this.employeeService.deleteEmployeeById(e.getId());
//			System.out.println(x);
//		}else if(e.getName().equalsIgnoreCase("save"))
//		{
			//this.employeeService.save(e);
			this.employeeService.insert(e);
			MultipartFile mpFile = e.getFile();
 			FileData fileData = new FileData();
			fileData.setField(1);
  			fileData.setFileContent(mpFile.getBytes());
			fileData.setTempFlag("A");
			this.employeeService.insertFileData(fileData);
		System.out.println("record saved....");
/*		}else if(e.getName().equalsIgnoreCase("get"))
		{
			Employee emp = this.employeeService.getEmployeeById(e.getId());
			System.out.println(emp);
		}else if(e.getName().equalsIgnoreCase("getall"))
		{
			List<Employee> listOfEmployee = this.employeeService.getAllEmployees();
			System.out.println(listOfEmployee);
		}*/
		return new ModelAndView("login");
	}

	/*@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("login");
	}*/
	
	@RequestMapping(value="/header")
	public ModelAndView header()
	{
		return new ModelAndView("header");
	}
	
}
