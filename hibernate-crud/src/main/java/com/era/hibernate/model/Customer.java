package com.era.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	//private static final long Serialiversion  = 1L;
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		@Column(name = "C_ID")
		int C_ID;
		
		@Column(name = "C_NAME")
		String C_NAME;
		@Column(name = "C_ADDRESS")
		String C_ADDRESS;
		@Column(name = "SALARY")
		int SALARY;
		
		
		public Customer(){
			
		}
		
		public Customer( String c_NAME, String c_ADDRESS, int sALARY) {
			//C_ID = c_ID;
			C_NAME = c_NAME;
			C_ADDRESS = c_ADDRESS;
			SALARY = sALARY;
		}
		public Integer getC_ID() {
			return C_ID;
		}
		public void setC_ID(Integer c_ID) {
			C_ID = c_ID;
		}
		public String getC_NAME() {
			return C_NAME;
		}
		public void setC_NAME(String c_NAME) {
			C_NAME = c_NAME;
		}
		public String getC_ADDRESS() {
			return C_ADDRESS;
		}
		public void setC_ADDRESS(String c_ADDRESS) {
			C_ADDRESS = c_ADDRESS;
		}
		public int getSALARY() {
			return SALARY;
		}
		public void setSALARY(int sALARY) {
			SALARY = sALARY;
		}

		@Override
		public String toString() {
			return "Customer [C_ID=" + C_ID + ", C_NAME=" + C_NAME + ", C_ADDRESS=" + C_ADDRESS + ", SALARY=" + SALARY
					+ "]";
		}
		
		
}
