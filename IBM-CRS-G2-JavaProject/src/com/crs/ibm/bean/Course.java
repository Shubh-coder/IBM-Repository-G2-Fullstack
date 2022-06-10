package com.crs.ibm.bean;

public class Course {

	private String CourseId;
	
	
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getMaxStudent() {
		return MaxStudent;
	}
	public void setMaxStudent(int maxStudent) {
		MaxStudent = maxStudent;
	}
	public int getMinStudent() {
		return MinStudent;
	}
	public void setMinStudent(int minStudent) {
		MinStudent = minStudent;
	}
	public int getCurrentStudent() {
		return CurrentStudent;
	}
	public void setCurrentStudent(int currentStudent) {
		CurrentStudent = currentStudent;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	public String getCourseSection() {
		return CourseSection;
	}
	public void setCourseSection(String courseSection) {
		CourseSection = courseSection;
	}
	private String CourseName;
	private int MaxStudent;
	private int MinStudent;
	private int CurrentStudent;
	private String Instructor;
	private String CourseSection;


}
