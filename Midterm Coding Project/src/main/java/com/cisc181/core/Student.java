package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.Exceptions.PersonException;
import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private Enum Major;
	private UUID StudentID;
	private double GPA;
	
	public Enum getMajor ( )
    {
        return this.Major;
    }
    public void setMajor (Enum Major)
    {
        this.Major = Major;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
	public Student(String FirstName, String MiddleName, String LastName,Date DOB, Enum Major,
			String Address, String Phone_number, String Email) throws PersonException
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;
		
	}
	
	private int numCourses;
	public void setGPA(Enrollment e, int GradePoints) {
		int origNum = numCourses;
		if (origNum == 0) {
			numCourses = 0;
		}
		numCourses++;
		double grade = e.getGrade();
		int gradeScale = GradePoints;
		double where = (100.00-grade)/(double)gradeScale;
		double weight = 5.0 - Math.ceil(where);
		if (GPA == 0.0) {
			GPA = weight/(double)numCourses;
		}else {
			GPA = (GPA*origNum + weight)/(double)numCourses;
		}
		
	}
	
	public double getGPA() {
		return GPA;
	}
	
	@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}
}