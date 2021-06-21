package com.era.hibernate;

import java.util.List;

import com.era.hibernate.dao.CustomerDAO;
import com.era.hibernate.model.Customer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO cdao = new CustomerDAO();
		Customer cus1 = new Customer("Plabon","Dhaka",20000);
		Customer cus3 = new Customer("Hello","N.gonk",30000);
		Customer cus4 = new Customer("Nil","N.gonk",30000);
		Customer cus5 = new Customer("Hello","G.gonj",10000);
		
		
		
		cdao.saveCustomer(cus1);
		cdao.saveCustomer(cus3);
		cdao.saveCustomer(cus4);
		
//		Customer cus2 = cdao.getStudentById(cus1.getC_ID());
		
		List<Customer> cusList = cdao.getAllStudent();
		for (Customer customer : cusList) {			
			System.out.println(customer);
		}
		//cusList.forEach(cusLists -> System.out.print(cusLists.getC_ID()));
	}

}
