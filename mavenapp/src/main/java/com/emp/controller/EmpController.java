package com.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emp.model.Emp;
import com.emp.service.EmpService;






@Controller
public class EmpController {
	
	private static final Logger logger = Logger
			.getLogger("EmpController.class");

	public EmpController() {
		System.out.println("EmpController()");
	}
	
	@Autowired
	
	private EmpService empService;
	
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) throws IOException {
		model.setViewName("login");
		return model;
	}
	

	@RequestMapping(value = "/show")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Emp> list = empService.getData();
		model.addObject("list",list);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Emp emp = new Emp();
		model.addObject("emp", emp);
		model.setViewName("EmployeeForm");
		return model;
	}
	
	@RequestMapping(value = "/new1", method = RequestMethod.GET)
	public ModelAndView new1(ModelAndView model) {
		Emp emp = new Emp();
		model.addObject("emp", emp);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Emp emp) {
		if (emp.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			empService.add(emp);
		} else {
			empService.updateData(emp);
		}
		return new ModelAndView("redirect:/show");
	}
	
	@RequestMapping(value = "/deleteData", method = RequestMethod.GET)
	public ModelAndView deleteData(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("id"));
		empService.deleteData(empid);
		return new ModelAndView("redirect:/show");
	}
	
	
	@RequestMapping(value = "/editData" , method = RequestMethod.GET)
	public ModelAndView editData(HttpServletRequest request) {
		
		int empid = Integer.parseInt(request.getParameter("id"));
		Emp emp = empService.getEmp(empid);
		ModelAndView model1 = new ModelAndView("EmployeeForm");
		model1.addObject("emp", emp);
		
		return model1;
		
	}
	
	
	@RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
	public ModelAndView loginEmp(@ModelAttribute Emp emp) {
		
		
		boolean userExists = empService.checkLogin(emp.getName(),emp.getPassword());
		if(userExists){
			ModelAndView model1 = new ModelAndView("userhome");
			model1.addObject("emp", emp);
			return model1;
		}else{
			ModelAndView model1 = new ModelAndView("login");
			return model1;
		}
		
	}
	
	
	
	
	
}
