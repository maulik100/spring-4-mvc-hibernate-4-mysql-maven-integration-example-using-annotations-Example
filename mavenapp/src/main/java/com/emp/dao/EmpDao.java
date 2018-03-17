package com.emp.dao;

import java.util.List;

import com.emp.model.Emp;

public interface EmpDao {
	
	
	public void add(Emp emp);
	
	public List<Emp> getData();
	
	public void deleteData(Integer empid);
	
	public Emp getEmp (int empid);
	
	public Emp updateData(Emp emp);
	
	public boolean checkLogin(String name, String password);
	
	
	

}
