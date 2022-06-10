/**
 * 
 */
package com.ibm.rest.bean;

/**
 * @author 003NRH744
 *
 */
public class PaymentDetails {

	private String Card_Number;
	private String Upi_Number;
	private String Expiry_Date;
	private Integer Cvv;
	private Integer Student_Id;
	public String getCard_Number() {
		return Card_Number;
	}
	public void setCard_Number(String card_Number) {
		Card_Number = card_Number;
	}
	public String getUpi_Number() {
		return Upi_Number;
	}
	public void setUpi_Number(String upi_Number) {
		Upi_Number = upi_Number;
	}
	public String getExpiry_Date() {
		return Expiry_Date;
	}
	public void setExpiry_Date(String expiry_Date) {
		Expiry_Date = expiry_Date;
	}
	public Integer getCvv() {
		return Cvv;
	}
	public void setCvv(Integer cvv) {
		Cvv = cvv;
	}
	public Integer getStudent_Id() {
		return Student_Id;
	}
	public void setStudent_Id(Integer student_Id) {
		Student_Id = student_Id;
	}
	@Override
	public String toString() {
		return "PaymentDetails [Card_Number=" + Card_Number + ", Upi_Number=" + Upi_Number + ", Expiry_Date="
				+ Expiry_Date + ", Cvv=" + Cvv + ", Student_Id=" + Student_Id + "]";
	}
} 
