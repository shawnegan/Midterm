package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.cisc181.Exceptions.PersonException;
import com.cisc181.eNums.eTitle;
public class Staff_Test {
	
	@Test
	public void testSalary() throws PersonException{
		ArrayList<Staff> people = new ArrayList<Staff>();
		Staff s1 = new Staff("s1", "s1", "s1",
				new Date(35,1,1), "s1 add", "(302)-555-5555", "s1 email",
				"1-2", 5, 28000.98, new Date(99,4,5),
				eTitle.MR);
		Staff s2 = new Staff("s2", "s2", "s2",
				new Date(36,1,1), "s2 add", "(302)-555-5555", "s2 email",
				"1-2", 10, 35987.67, new Date(79,4,5),
				eTitle.MRS);
		Staff s3 = new Staff("s3", "s3", "s3",
				new Date(44,1,1), "s3 add", "(302)-555-5555", "s3 email",
				"1-2", 5, 99967.75, new Date(72,4,5),
				eTitle.MS);
		Staff s4 = new Staff("s4", "s4", "s4",
				new Date(55,1,1), "s4 add", "(302)-555-5555", "s4 email",
				"1-2", 5, 78954.32, new Date(88,4,5),
				eTitle.MR);
		Staff s5 = new Staff("s5", "s5", "s5",
				new Date(49,1,1), "s5 add", "(302)-555-5555", "s5 email",
				"1-2", 5, 67495.73, new Date(79,4,5),
				eTitle.MRS);
		people.add(s1);
		people.add(s2);
		people.add(s3);
		people.add(s4);
		people.add(s5);
		
		double avg = 62081.29;
		double methodavg = 0;
		for (Staff s : people) {
			methodavg += s.getSalary();
			
		}
		methodavg = methodavg/5;
		assertEquals(methodavg, avg, 0);
	}
	
	@Test (expected = PersonException.class)
	public void testPhone() throws PersonException {
		Staff s1 = new Staff("s1", "s1", "s1",
				new Date(38,1,1), "s1 add", "302-555-5555", "s1 email",
				"1-2", 5, 28000.98, new Date(99,4,5),
				eTitle.MR);
	}
	
	@Test (expected = PersonException.class)
	public void testDOB() throws PersonException {
		Staff s1 = new Staff("s1", "s1", "s1",
				new Date(1,1,1), "s1 add", "(302)-555-5555", "s1 email",
				"1-2", 5, 28000.98, new Date(99,4,5),
				eTitle.MR);
	}
	

}
