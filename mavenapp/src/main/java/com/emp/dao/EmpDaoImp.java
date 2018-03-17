package com.emp.dao;

import java.util.List;

import javax.management.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.model.Emp;

@Repository
public class EmpDaoImp  implements EmpDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void add(Emp emp) {

		sessionFactory.getCurrentSession().saveOrUpdate(emp);

		
	}


	@Override
	public List<Emp> getData() {
		
		return sessionFactory.getCurrentSession().createQuery("from Emp").list();
	}


	@Override
	public void deleteData(Integer empid) {
		
		Emp emp = (Emp) sessionFactory.getCurrentSession().load(Emp.class, empid);
		
		if(emp != null) {
			
			this.sessionFactory.getCurrentSession().delete(emp);
		}
		
	}


	@Override
	public Emp getEmp(int empid) {
		
		
		return (Emp) sessionFactory.getCurrentSession().get(Emp.class, empid);
	}


	@Override
	public Emp updateData(Emp emp) {
		
		sessionFactory.getCurrentSession().update(emp);
		
		return emp;
	}


	@Override
	public boolean checkLogin(String name, String password) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
	
		String QUERY =" from Emp as o where o.name=? and o.password=?";
		Query query = (Query) session.createQuery(QUERY);
		((org.hibernate.Query) query).setParameter(0,name);
		((org.hibernate.Query) query).setParameter(1,password);
		List list = ((org.hibernate.Query) query).list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;             
	}

	


}
