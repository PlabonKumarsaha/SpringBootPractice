package com.era.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.era.hibernate.model.Customer;
import com.era.hibernate.util.HibernateUtil;

public class CustomerDAO {

	public void saveCustomer(Customer customer){

		Transaction transaction = null;
		//Session session  = null;
		//transaction = session.beginTransaction();
		try(Session session  = HibernateUtil.getSessionFactory().openSession()){
			// start transactio
	
			transaction = session.beginTransaction();
			System.out.println("==>>> "+session);
			//save the customer
			session.save(customer);
			System.out.println(customer.getC_ID());
			System.out.println(customer.getC_NAME());
			System.out.println(customer.getC_ADDRESS());
			System.out.println(customer.getSALARY());
			
			//commit the transaction
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();	
			}
			e.printStackTrace();
		}
	}


public void updateCustomer(Customer customer){
	Transaction transaction = null;
	try(Session session = HibernateUtil.getSessionFactory().openSession()){
		// start transaction
		transaction = session.beginTransaction();
		//save the customer
		session.saveOrUpdate(customer);
		
		//commit the transaction
		transaction.commit();
	}catch(Exception e){
		if(transaction != null){
			transaction.rollback();	
		}
		e.printStackTrace();
	}
}

public Customer getStudentById(int id){
	Transaction transaction = null;
	Customer cus = null;
	try(Session session = HibernateUtil.getSessionFactory().openSession()){
		// start transaction
		transaction = session.beginTransaction();
		//save the customer
		 cus = session.get(Customer.class,id);
		
		//commit the transaction
		transaction.commit();
	}catch(Exception e){
		if(transaction != null){
			transaction.rollback();	
		}
		e.printStackTrace();
	}
	return cus;	
}


public List<Customer> getAllStudent(){
	Transaction transaction = null;
	 List<Customer> custs = null;
	try(Session session = HibernateUtil.getSessionFactory().openSession()){
		// start transaction
		transaction = session.beginTransaction();
		Query<Customer> query = session.createQuery("from Customer");
		//custs = (List<Customer>) session.createQuery("from Customer");
		custs = query.getResultList();
		System.out.println("Customer List size: "+custs.size());
		
		//commit the transaction
		//transaction.commit();
	}catch(Exception e){		
		e.printStackTrace();
	}
	return custs;
	
}

}
