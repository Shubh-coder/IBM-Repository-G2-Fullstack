package com.ibm.rest.bean;

public class Professor {


	public int getProfessorId() {
		return ProfessorId;
	}

	public void setProfessorId(int professorId) {
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

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getContact() {
		return Contact;
	}

	public void setContact(Long contact) {
		Contact = contact;
	}

	 
	 
	private int ProfessorId;
	private String ProfessorName;
	private String TeachCourse;
	private String Department;
	private String Qualification;
	private String Address;
	private Long Contact;
	
	@Override
	public String toString() {
		return "Professor [ProfessorId=" + ProfessorId + ", ProfessorName=" + ProfessorName + ", TeachCourse="
				+ TeachCourse + ", Department=" + Department + ", Qualification=" + Qualification + ", Address="
				+ Address + ", Contact=" + Contact + "]";
	}
	
 
}
