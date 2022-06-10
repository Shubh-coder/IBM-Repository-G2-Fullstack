package com.crs.ibm.bean;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int StudentId;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentQualification() {
		return StudentQualification;
	}
	public void setStudentQualification(String studentQualification) {
		StudentQualification = studentQualification;
	}
	public String getStudentBranch() {
		return StudentBranch;
	}
	public void setStudentBranch(String studentBranch) {
		StudentBranch = studentBranch;
	}
	public String getStudentCourse() {
		return StudentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		StudentCourse = studentCourse;
	}
	public int getNumberOfCourse() {
		return NumberOfCourse;
	}
	public void setNumberOfCourse(int numberOfCourse) {
		NumberOfCourse = numberOfCourse;
	}
	public String getStudentContactNo() {
		return StudentContactNo;
	}
	public void setStudentContactNo(String studentContactNo) {
		StudentContactNo = studentContactNo;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	private String StudentName;
	private String StudentQualification;
	private String StudentBranch;
	private String StudentCourse;
	private int NumberOfCourse;
	private String StudentContactNo;
	private String StudentAddress;
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	private String studentGrade;

	/*
	 * public Student(int StudentId,String StudentName,String
	 * StudentQualification,String StudentBranch,String StudentContactNo,String
	 * StudentAddress) { this.StudentId=StudentId; this.StudentName=StudentName;
	 * this.StudentQualification=StudentQualification;
	 * this.StudentBranch=StudentBranch; this.StudentContactNo=StudentContactNo;
	 * this.StudentAddress=StudentAddress;
	 * 
	 * }
	 */




}
