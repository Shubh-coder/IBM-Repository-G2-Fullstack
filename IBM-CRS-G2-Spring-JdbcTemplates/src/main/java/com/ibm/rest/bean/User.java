package com.ibm.rest.bean;

public class User {

 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	private String name;
	private String email;
	private String role;
	protected String password;
	private int approval;

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", role=" + role + ", password=" + password + ", approval="
				+ approval + "]";
	}

}
