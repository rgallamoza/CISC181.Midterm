package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	static Course C1 = new Course(UUID.randomUUID(),"Computer Science",3);
	static Course C2 = new Course(UUID.randomUUID(),"Calculus",4);
	static Course C3 = new Course(UUID.randomUUID(),"Physics",4);
	static ArrayList<Course> CourseList = new ArrayList<Course>(3);
	
	static Date FallStart = new Date(116,9,1);
	static Date FallEnd = new Date(116,12,15);
	static Semester Fall = new Semester(UUID.randomUUID(),FallStart,FallEnd);
	static Date SpringStart = new Date(117,2,6);
	static Date SpringEnd = new Date(117,5,25);
	static Semester Spring = new Semester(UUID.randomUUID(),SpringStart,SpringEnd);
	static ArrayList<Semester> SemesterList = new ArrayList<Semester>(2);

	
	static Section CompSci1 = new Section(C1.getCourseID(),Fall.getSemesterID(),UUID.randomUUID(),100);
	static Section CompSci2 = new Section(C1.getCourseID(),Spring.getSemesterID(),UUID.randomUUID(),100);
	static Section Calc1 = new Section(C2.getCourseID(),Fall.getSemesterID(),UUID.randomUUID(),206);
	static Section Calc2 = new Section(C2.getCourseID(),Spring.getSemesterID(),UUID.randomUUID(),206);
	static Section Phys1 = new Section(C3.getCourseID(),Fall.getSemesterID(),UUID.randomUUID(),200);
	static Section Phys2 = new Section(C3.getCourseID(),Spring.getSemesterID(),UUID.randomUUID(),200);
	static ArrayList<Section> SectionList = new ArrayList<Section>(6);

	@BeforeClass
	public static void setup() throws PersonException{
		CourseList.add(C1);
		CourseList.add(C2);
		CourseList.add(C3);

		SemesterList.add(Fall);
		SemesterList.add(Spring);
		
		SectionList.add(CompSci1);
		SectionList.add(CompSci2);
		SectionList.add(Calc1);
		SectionList.add(Calc2);
		SectionList.add(Phys1);
		SectionList.add(Phys2);
	}

	@Test
	public void TestStudentGPA() throws PersonException {
		
		Student S1 = new Student("Don","X.","Jon",new Date(90,1,1),eMajor.BUSINESS,"123 OneTwoThree Ave",
				"3023023023","urboydon@gmail.com");
		Student S2 = new Student("Jon","X.","Don",new Date(90,2,1),eMajor.CHEM,"234 TwoThreeFour Ave",
				"1010101010","urboyjon@gmail.com");
		Student S3 = new Student("Ron","X.","Jon",new Date(90,3,1),eMajor.COMPSCI,"345 ThreeFourFive Ave",
				"1234567890","urboyron@gmail.com");
		Student S4 = new Student("Jake","X.","Steel",new Date(90,4,1),eMajor.NURSING,"456 FourFiveSix Ave",
				"0987654321","urboyjake@gmail.com");
		Student S5 = new Student("Big","X.","Smoke",new Date(90,5,1),eMajor.PHYSICS,"567 FiveSixSeven Ave",
				"1111111111","urboysmoke@gmail.com");
		Student S6 = new Student("Carl","X.","Johnson",new Date(90,6,1),eMajor.BUSINESS,"678 SixSevenEight Ave",
				"2222222222","urboycj@gmail.com");
		Student S7 = new Student("Trevor","X.","Phillips",new Date(90,7,1),eMajor.CHEM,"789 SevenEightNine Ave",
				"3333333333","urboytrevor@gmail.com");
		Student S8 = new Student("Frank","X.","Clinton",new Date(90,8,1),eMajor.COMPSCI,"890 EightNineZero Ave",
				"4444444444","urboyfrank@gmail.com");
		Student S9 = new Student("Lamar","X.","Davis",new Date(90,9,1),eMajor.NURSING,"901 NineZeroOne Ave",
				"5555555555","urboylamar@gmail.com");
		Student S10 = new Student("Kim","X.","Jong-Un",new Date(90,10,1),eMajor.PHYSICS,"012 ZeroOneTwo Ave",
				"6666666666","supremeleaderkimjong@gmail.com");
		ArrayList<Student> StudentList = new ArrayList<Student>(10);
		StudentList.add(S1);
		StudentList.add(S2);
		StudentList.add(S3);
		StudentList.add(S4);
		StudentList.add(S5);
		StudentList.add(S6);
		StudentList.add(S7);
		StudentList.add(S8);
		StudentList.add(S9);
		StudentList.add(S10);
		
		ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		for(Section section : SectionList){
			for (Student student : StudentList){
				EnrollmentList.add(new Enrollment(section.getSectionID(),student.getStudentID()));
			}
		}
		
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S1.getStudentID()){
				enrollment.setGrade(4.0);
			}
			else if(enrollment.getStudentID()==S2.getStudentID()){
				enrollment.setGrade(4.0);
			}
			else if(enrollment.getStudentID()==S3.getStudentID()){
				enrollment.setGrade(3.5);
			}
			else if(enrollment.getStudentID()==S4.getStudentID()){
				enrollment.setGrade(3.5);
			}
			else if(enrollment.getStudentID()==S5.getStudentID()){
				enrollment.setGrade(3.0);
			}
			else if(enrollment.getStudentID()==S6.getStudentID()){
				enrollment.setGrade(3.0);
			}
			else if(enrollment.getStudentID()==S7.getStudentID()){
				enrollment.setGrade(2.5);
			}
			else if(enrollment.getStudentID()==S8.getStudentID()){
				enrollment.setGrade(2.5);
			}
			else if(enrollment.getStudentID()==S9.getStudentID()){
				enrollment.setGrade(2.0);
			}
			else{
				enrollment.setGrade(2.0);
			}
		}
		
		double TotalGP = 0;
		for(Section s : SectionList){
			if(s.getCourseID()==C1.getCourseID()){
				TotalGP+=C1.getGradePoints();
			}
			else if(s.getCourseID()==C2.getCourseID()){
				TotalGP+=C2.getGradePoints();
			}
			else{
				TotalGP+=C3.getGradePoints();
			}
		}

		double S1Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S1.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S1Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S1Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S1Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S1Avg /= TotalGP;
		assertEquals(S1Avg,4,0.001);

		double S2Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S2.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S2Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S2Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S2Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S2Avg /= TotalGP;
		assertEquals(S2Avg,4,0.001);
		
		double S3Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S3.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S3Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S3Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S3Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S3Avg /= TotalGP;
		assertEquals(S3Avg,3.5,0.001);
		
		double S4Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S4.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S4Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S4Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S4Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S4Avg /= TotalGP;
		assertEquals(S4Avg,3.5,0.001);
		
		double S5Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S5.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S5Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S5Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S5Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S5Avg /= TotalGP;
		assertEquals(S5Avg,3,0.001);
		
		double S6Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S6.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S6Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S6Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S6Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S6Avg /= TotalGP;
		assertEquals(S6Avg,3,0.001);
		
		double S7Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S7.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S7Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S7Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S7Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S7Avg /= TotalGP;
		assertEquals(S7Avg,2.5,0.001);
		
		double S8Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S8.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S8Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S8Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S8Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S8Avg /= TotalGP;
		assertEquals(S8Avg,2.5,0.001);
		
		double S9Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S9.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S9Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S9Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S9Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S9Avg /= TotalGP;
		assertEquals(S9Avg,2,0.001);
		
		double S10Avg = 0;
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S10.getStudentID()){
				if(enrollment.getSectionID()==CompSci1.getSectionID() || enrollment.getSectionID()==CompSci2.getSectionID()){
					S10Avg += enrollment.getGrade()*C1.getGradePoints();
				}
				else if(enrollment.getSectionID()==Calc1.getSectionID() || enrollment.getSectionID()==Calc2.getSectionID()){
					S10Avg += enrollment.getGrade()*C2.getGradePoints();
				}
				else{
					S10Avg += enrollment.getGrade()*C3.getGradePoints();
				}
			}
		}
		S10Avg /= TotalGP;
		assertEquals(S10Avg,2,0.001);
	}
	
	@Test
	public void TestCourseAvg() throws PersonException {
		Student S1 = new Student("Don","X.","Jon",new Date(90,1,1),eMajor.BUSINESS,"123 OneTwoThree Ave",
				"3023023023","urboydon@gmail.com");
		Student S2 = new Student("Jon","X.","Don",new Date(90,2,1),eMajor.CHEM,"234 TwoThreeFour Ave",
				"1010101010","urboyjon@gmail.com");
		Student S3 = new Student("Ron","X.","Jon",new Date(90,3,1),eMajor.COMPSCI,"345 ThreeFourFive Ave",
				"1234567890","urboyron@gmail.com");
		Student S4 = new Student("Jake","X.","Steel",new Date(90,4,1),eMajor.NURSING,"456 FourFiveSix Ave",
				"0987654321","urboyjake@gmail.com");
		Student S5 = new Student("Big","X.","Smoke",new Date(90,5,1),eMajor.PHYSICS,"567 FiveSixSeven Ave",
				"1111111111","urboysmoke@gmail.com");
		Student S6 = new Student("Carl","X.","Johnson",new Date(90,6,1),eMajor.BUSINESS,"678 SixSevenEight Ave",
				"2222222222","urboycj@gmail.com");
		Student S7 = new Student("Trevor","X.","Phillips",new Date(90,7,1),eMajor.CHEM,"789 SevenEightNine Ave",
				"3333333333","urboytrevor@gmail.com");
		Student S8 = new Student("Frank","X.","Clinton",new Date(90,8,1),eMajor.COMPSCI,"890 EightNineZero Ave",
				"4444444444","urboyfrank@gmail.com");
		Student S9 = new Student("Lamar","X.","Davis",new Date(90,9,1),eMajor.NURSING,"901 NineZeroOne Ave",
				"5555555555","urboylamar@gmail.com");
		Student S10 = new Student("Kim","X.","Jong-Un",new Date(90,10,1),eMajor.PHYSICS,"012 ZeroOneTwo Ave",
				"6666666666","supremeleaderkimjong@gmail.com");
		ArrayList<Student> StudentList = new ArrayList<Student>(10);
		StudentList.add(S1);
		StudentList.add(S2);
		StudentList.add(S3);
		StudentList.add(S4);
		StudentList.add(S5);
		StudentList.add(S6);
		StudentList.add(S7);
		StudentList.add(S8);
		StudentList.add(S9);
		StudentList.add(S10);
		
		ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		for(Section section : SectionList){
			for (Student student : StudentList){
				EnrollmentList.add(new Enrollment(section.getSectionID(),student.getStudentID()));
			}
		}
		
		for(Enrollment enrollment : EnrollmentList){
			if(enrollment.getStudentID()==S1.getStudentID()){
				enrollment.setGrade(4.0);
			}
			else if(enrollment.getStudentID()==S2.getStudentID()){
				enrollment.setGrade(4.0);
			}
			else if(enrollment.getStudentID()==S3.getStudentID()){
				enrollment.setGrade(3.5);
			}
			else if(enrollment.getStudentID()==S4.getStudentID()){
				enrollment.setGrade(3.5);
			}
			else if(enrollment.getStudentID()==S5.getStudentID()){
				enrollment.setGrade(3.0);
			}
			else if(enrollment.getStudentID()==S6.getStudentID()){
				enrollment.setGrade(3.0);
			}
			else if(enrollment.getStudentID()==S7.getStudentID()){
				enrollment.setGrade(2.5);
			}
			else if(enrollment.getStudentID()==S8.getStudentID()){
				enrollment.setGrade(2.5);
			}
			else if(enrollment.getStudentID()==S9.getStudentID()){
				enrollment.setGrade(2.0);
			}
			else{
				enrollment.setGrade(2.0);
			}
		}
		
		double CompSciAvg = 0; 
		double CalcAvg = 0;
		double PhysAvg = 0;
		for(Enrollment e : EnrollmentList){
			if(e.getSectionID()==CompSci1.getSectionID() || e.getSectionID()==CompSci2.getSectionID()){
				CompSciAvg += e.getGrade();
			}
			else if(e.getSectionID()==Calc1.getSectionID() || e.getSectionID()==Calc2.getSectionID()){
				CalcAvg += e.getGrade();
			}
			else{
				PhysAvg += e.getGrade();
			}
		}
		CompSciAvg /= 20;
		CalcAvg /= 20;
		PhysAvg /= 20;
		
		assertEquals(CompSciAvg,3,0.01);
		assertEquals(CalcAvg,3,0.01);
		assertEquals(PhysAvg,3,0.01);
	}
	
	@Test
	public void ChangeMajor() throws PersonException {
		Student S1 = new Student("Don","X.","Jon",new Date(90,1,1),eMajor.BUSINESS,"123 OneTwoThree Ave",
				"3023023023","urboydon@gmail.com");
		S1.setMajor(eMajor.CHEM);
		assertTrue(S1.getMajor()==eMajor.CHEM);
		S1.setMajor(eMajor.BUSINESS);
	}
}