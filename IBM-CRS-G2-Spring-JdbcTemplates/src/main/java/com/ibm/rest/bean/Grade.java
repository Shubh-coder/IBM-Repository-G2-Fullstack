package com.ibm.rest.bean;

public class Grade {

	
	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	private String studentGrade;

	@Override
	public String toString() {
		return "Grade [studentGrade=" + studentGrade + "]";
	}
}
