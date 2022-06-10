package com.ibm.rest.bean;

public class Payment {

	private String Payment_Method;
	private Integer Total_Amount;
	private Integer Student_Id;
	public String getPayment_Method() {
		return Payment_Method;
	}
	@Override
	public String toString() {
		return "Payment [Payment_Method=" + Payment_Method + ", Total_Amount=" + Total_Amount + ", Student_Id="
				+ Student_Id + "]";
	}
	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}
	public Integer getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(Integer total_Amount) {
		Total_Amount = total_Amount;
	}
	public Integer getStudent_Id() {
		return Student_Id;
	}
	public void setStudent_Id(Integer student_Id) {
		Student_Id = student_Id;
	}

}
