package com.emp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmpDao;
import com.emp.model.Emp;

@Service
@Transactional
public class EmpServiceImp implements EmpService{

	@Autowired
	private EmpDao empDao;
	
	
	@Override
	public void add(Emp emp) {
		
		empDao.add(emp);
		
	}


	@Override
	public List<Emp> getData() {
		// TODO Auto-generated method stub
		return empDao.getData();
	}


	@Override
	public void deleteData(Integer empid) {
		
		empDao.deleteData(empid);
		
	}


	@Override
	public Emp getEmp(int empid) {
		
		return empDao.getEmp(empid);
	}


	@Override
	public Emp updateData(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.updateData(emp);
	}
	
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}


	@Override
	public boolean checkLogin(String name, String password) {
		return empDao.checkLogin(name, password);
	}
	
	
	

}
