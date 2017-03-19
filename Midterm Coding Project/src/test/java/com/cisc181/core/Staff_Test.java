package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;
import com.cisc181.core.Person;
import com.cisc181.core.Staff;


public class Staff_Test {
	
	@BeforeClass
	public static void setup() throws PersonException {
		
	}
	
	@Test
	public void TestStaffSalary() throws PersonException {
		
		Staff s1 = new Staff("John","X.","Doe",new Date(),"123 Sesame Street","1234567890",
				"urboyjohn@gmail.com","12:00-2:00PM, MWF",4,50000.00,new Date(),eTitle.PROF);
		Staff s2 = new Staff("Don","X.","Joe",new Date(),"321 Emases Street","9991119999",
				"urbrodon@gmail.com","5:00-7:00PM, MWF",1,100000.00,new Date(),eTitle.PROF);
		Staff s3 = new Staff("Kim","X.","Jong-Un",new Date(),"666 North Korea Ave","1212121212",
				"kimjongpingpong@gmail.com","1:00-3:00PM, MWF",1,900000.00,new Date(),eTitle.MR);
		Staff s4 = new Staff("Kim","X.","Jong-Il",new Date(),"666 North Korea Ave","2121212121",
				"imthekimjongillest@gmail.com","8:00-10:00AM, MWF",1,100000.00,new Date(),eTitle.MR);
		Staff s5 = new Staff("Jane","X.","Doe",new Date(),"321 Emases Street","9991119999",
				"urgirljaney@gmail.com","4:00-5:00PM, MWF",1,100000.00,new Date(),eTitle.DR);
		
		ArrayList<Staff> StaffList = new ArrayList<Staff>(5);
		StaffList.add(s1);
		StaffList.add(s2);
		StaffList.add(s3);
		StaffList.add(s4);
		StaffList.add(s5);
		
		double AvgSalary = 0;
		for(Staff s : StaffList){
			AvgSalary += s.getSalary();
		}
		AvgSalary /= 5;
		assertTrue(AvgSalary==250000);
	}	
	
	@Test(expected = PersonException.class)
	public void TestInvalidDOB() throws PersonException{
		
		Staff exception1 = new Staff("John","X.","Doe",new Date(17,1,1),"123 Sesame Street","1234567890",
				"urboyjohn@gmail.com","12:00-2:00PM, MWF",4,50000.00,new Date(),eTitle.PROF);
	}

	@Test(expected = PersonException.class)
	public void TestInvalidPhoneNumber() throws PersonException{
		
		Staff exception2 = new Staff("John","X.","Doe",new Date(),"123 Sesame Street","SIKETHATSTHEWRONGNUMBER",
				"urboyjohn@gmail.com","12:00-2:00PM, MWF",4,50000.00,new Date(),eTitle.PROF);
	}
}
