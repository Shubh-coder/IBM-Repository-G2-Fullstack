package com.ibm.rest.bean;

public class Professor {


	private String ProfessorId;
	public String getProfessorId() {
		return ProfessorId;
	}
	public void setProfessorId(String professorId) {
		ProfessorId = professorId;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public String getTeachCourse() {
		return TeachCourse;
	}
	public void setTeachCourse(String teachCourse) {
		TeachCourse = teachCourse;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	private String ProfessorName;
	private String TeachCourse;
	private String Department;

}
