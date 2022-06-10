package com.ibm.rest.bean;

public class Course {

	
	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseName=" + CourseName + ", CourseSection=" + CourseSection
				+ ", CourseDuration=" + CourseDuration + ", CourseType=" + CourseType + ", CourseStatus=" + CourseStatus
				+ ", CoursePrice=" + CoursePrice + ", ProfessorId=" + ProfessorId + "]";
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
 

	public String getCourseSection() {
		return CourseSection;
	}
	public void setCourseSection(String courseSection) {
		CourseSection = courseSection;
	}
	
	public String getCourseType() {
		return CourseType;
	}
	public void setCourseType(String courseType) {
		CourseType = courseType;
	}
	public String getCourseStatus() {
		return CourseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		CourseStatus = courseStatus;
	}
	public int getCoursePrice() {
		return CoursePrice;
	}
	public void setCoursePrice(int total) {
		CoursePrice = total;
	}

	 
	public int getCourseDuration() {
		return CourseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		CourseDuration = courseDuration;
	}
	 
	public int getProfessorId() {
		return ProfessorId;
	}
	public void setProfessorId(int professorId) {
		ProfessorId = professorId;
	}
	 
	private int CourseId;
 	private String CourseName;
	private String CourseSection;
	private int CourseDuration;
	private String CourseType;
	private String CourseStatus;
	private int CoursePrice;
	private int ProfessorId;
	 
	 


}
