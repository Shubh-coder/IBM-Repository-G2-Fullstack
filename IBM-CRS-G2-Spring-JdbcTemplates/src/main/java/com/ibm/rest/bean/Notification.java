package com.ibm.rest.bean;

public class Notification {
	@Override
	public String toString() {
		return "Notification []";
	}
	public void success() {
		System.out.println("registered successfully");
	}
	public void exception() {
		System.out.println("error occured");
	}
}
