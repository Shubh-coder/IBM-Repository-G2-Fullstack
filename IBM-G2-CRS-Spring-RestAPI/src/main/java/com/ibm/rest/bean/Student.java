package com.ibm.rest.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"StudentId","StudentName","StudentQualifiaction","StudentBranch","StudentContactNo","StudentAddress,StudentGrade"})
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
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	private String StudentName;
	private String StudentQualification;
	private String StudentBranch;
	private String StudentContactNo;
	private String StudentAddress;
	private String studentGrade;
	 
	
	public Student(int studentId, String studentName, String studentQualification, String studentBranch,
			String studentContactNo, String studentAddress, String studentGrade) {
		super();
		this.StudentId = studentId;
		this.StudentName = studentName;
		this.StudentQualification = studentQualification;
		this.StudentBranch = studentBranch;
		this.StudentContactNo = studentContactNo;
		this.StudentAddress = studentAddress;
		this.studentGrade = studentGrade;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

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
