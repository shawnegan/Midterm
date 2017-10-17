package com.cisc181.core;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.Exceptions.PersonException;

public class Student_Test {


	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();
	static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	@BeforeClass
	public static void setup() throws PersonException {
		
		Semester fall = new Semester();
		fall.setStartDate(new Date(116,7,28));
		fall.setSemesterID(UUID.randomUUID());
		Semester spring = new Semester();
		spring.setStartDate(new Date(117,1,7));
		spring.setSemesterID(UUID.randomUUID());
		semesters.add(fall);
		semesters.add(spring);
		
		Course math = new Course();
		math.setCourseID(UUID.randomUUID());
		math.setGradePoints(6);
		Course science = new Course();
		science.setCourseID(UUID.randomUUID());
		science.setGradePoints(7);
		Course english = new Course();
		english.setCourseID(UUID.randomUUID());
		english.setGradePoints(8);
		courses.add(math);
		courses.add(science);
		courses.add(english);
		
		Section math001fall = new Section();
		math001fall.setCourseID(math.getCourseID());
		math001fall.setSemesterID(fall.getSemesterID());
		Section math001spring = new Section();
		math001spring.setCourseID(math.getCourseID());
		math001spring.setSemesterID(spring.getSemesterID());
		
		Section science001fall = new Section();
		science001fall.setCourseID(science.getCourseID());
		science001fall.setSemesterID(fall.getSemesterID());
		Section science001spring = new Section();
		science001spring.setCourseID(science.getCourseID());
		science001spring.setSemesterID(spring.getSemesterID());
		
		Section english001fall = new Section();
		english001fall.setCourseID(english.getCourseID());
		english001fall.setSemesterID(fall.getSemesterID());
		Section english001spring = new Section();
		english001spring.setCourseID(english.getCourseID());
		english001spring.setSemesterID(spring.getSemesterID());
		
		sections.add(math001fall);
		sections.add(math001spring);
		sections.add(science001fall);
		sections.add(science001spring);
		sections.add(english001fall);
		sections.add(english001spring);
		
		for (int i = 1; i < 11; i++) {
		  students.add(new Student(null, null, null, new Date(75,1,1), null, null, "(302)-555-5555", null));
		}
		
		//enrolling all 10 students in each section
		//each student gets an 85, 87, 89, 91, 95 in mathfall, spring, sciencefall, spring, and englishfall,spring
		int i = 0;
		for (Student stu : students) {
			int b = (int)Math.random()*8;
			for (Section s : sections) {
				enrollments.add(new Enrollment(stu.getStudentID(),s.getSectionID()));
				enrollments.get(i).SetGrade(85+b);
				i++;
				b+=2;
			}
		}
		
	}

	@Test
	public void testStudent() {
		
		for (Student stu : students) {
			for (int a = 0; a<6; a++) {
				if (enrollments.size() == 0) {
					break;
				}else {
				stu.setGPA(enrollments.remove(0),7);
				}
			}
		}
		for (Student stu : students) {
			assertEquals(stu.getGPA(),3.167,0.001);
		}
		
	}
	
	@Test
	public void testCourseAvg() {
		
		
		for (Section sec : sections) {
			sec.setSectionID(UUID.randomUUID());
		}
		int i = 0;
		for (Student stu : students) {
			int b = (int)Math.random()*8;
			for (Section s : sections) {
				enrollments.add(new Enrollment(stu.getStudentID(),s.getSectionID()));
				enrollments.get(i).SetGrade(85+b);
				i++;
				b+=2;
			}
		}
		double mathFallAvg = 0;
		double mathSpringAvg = 0;
		double scienceFallAvg = 0;
		double scienceSpringAvg = 0;
		double englishFallAvg = 0;
		double englishSpringAvg = 0;
		
		UUID mathFall = sections.get(0).getSectionID();
		UUID mathSpring = sections.get(1).getSectionID();
		UUID scienceFall = sections.get(2).getSectionID();
		UUID scienceSpring = sections.get(3).getSectionID();
		UUID englishFall = sections.get(4).getSectionID();
		
		for (Enrollment e : enrollments) {
			if(e.getSectionID() == mathFall) {
				mathFallAvg += e.getGrade();
			}else if(e.getSectionID() == mathSpring) {
				mathSpringAvg += e.getGrade();
			}else if(e.getSectionID() == scienceFall) {
				scienceFallAvg += e.getGrade();
			}else if(e.getSectionID()== scienceSpring) {
				scienceSpringAvg += e.getGrade();
			}else if(e.getSectionID()==englishFall) {
				englishFallAvg += e.getGrade();
			}else { 
				englishSpringAvg += e.getGrade();
			}
			if(enrollments.get(59)==e) {
				mathFallAvg /= 10;
				mathSpringAvg /= 10;
				scienceFallAvg /= 10;
				scienceSpringAvg /= 10;
				englishFallAvg /= 10;
				englishSpringAvg /= 10;
			}
		}
		
		assertEquals(mathFallAvg,85,0);
		assertEquals(mathSpringAvg,87,0);
		assertEquals(scienceFallAvg,89,0);
		assertEquals(scienceSpringAvg,91,0);
		assertEquals(englishFallAvg,93,0);
		assertEquals(englishSpringAvg,95,0);
		
	}
}