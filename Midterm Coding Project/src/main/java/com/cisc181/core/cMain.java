package com.cisc181.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.Exceptions.PersonException;
import com.cisc181.core.*;
import com.cisc181.eNums.*;
public class cMain {
	public static void main(String[] args) throws PersonException {


		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		ArrayList<Section> sections = new ArrayList<Section>();
		
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
			Course science = new Course();
			science.setCourseID(UUID.randomUUID());
			Course english = new Course();
			science.setCourseID(UUID.randomUUID());
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
			
			ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
			int i = 0;
			for (Student stu : students) {
				for (Section s : sections) {
					enrollments.add(new Enrollment(stu.getStudentID(),s.getSectionID()));
					enrollments.get(i).SetGrade(65.0 + Math.random()*35);
					i++;
				}
			}
			double d = 0;
			for (Student stu : students) {
				double GPA = 0;
				int numCourses = 0;
				for (int a = 0; a<10; a++) {
					if (enrollments.size() == 0) {
						break;
					}else {
						int origNum = numCourses;
						numCourses++;
						double grade = enrollments.remove(0).getGrade();
						int gradeScale = 7;
						double where = (100.00-grade)/(double)gradeScale;
						double weight = 5.0 - Math.ceil(where);
						GPA = (GPA*origNum + weight)/numCourses;
						
					}
				}
			}
			for (Section sec : sections) {
				sec.setSectionID(UUID.randomUUID());
			}
			int a = 0;
			for (Student stu : students) {
				int b = (int)Math.random()*8;
				for (Section s : sections) {
					enrollments.add(new Enrollment(stu.getStudentID(),s.getSectionID()));
					enrollments.get(a).SetGrade(85+b);
					a++;
					b+=2;
				}
			}
			System.out.println(enrollments.get(0).getStudentID());
			System.out.println(enrollments.get(0).getGrade());
			System.out.println(enrollments.get(1).getStudentID());
			System.out.println(enrollments.get(1).getGrade());
			System.out.println(enrollments.get(2).getStudentID());
			System.out.println(enrollments.get(2).getGrade());
			System.out.println(enrollments.get(3).getStudentID());
			System.out.println(enrollments.get(3).getGrade());
			System.out.println(enrollments.get(4).getStudentID());
			System.out.println(enrollments.get(4).getGrade());
			System.out.println(enrollments.get(5).getStudentID());
			System.out.println(enrollments.get(5).getGrade());
			System.out.println(enrollments.get(6).getStudentID());
			System.out.println(enrollments.get(6).getGrade());
			
			
			
	}
}
