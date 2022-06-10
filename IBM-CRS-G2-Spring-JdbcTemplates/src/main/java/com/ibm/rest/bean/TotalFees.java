/**
 * 
 */
package com.ibm.rest.bean;

/**
 * @author 003NRH744
 *
 */
public class TotalFees {
private Integer Course_Price;

public Integer getCourse_Price() {
	return Course_Price;
}

public void setCourse_Price(Integer course_Price) {
	Course_Price = course_Price;
}

@Override
public String toString() {
	return "TotalFess [Course_Price=" + Course_Price + "]";
}
}
