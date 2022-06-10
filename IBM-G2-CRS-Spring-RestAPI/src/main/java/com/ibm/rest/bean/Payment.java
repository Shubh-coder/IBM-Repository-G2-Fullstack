package com.ibm.rest.bean;

public class Payment {

	private String PaymentId;
	public String getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}
	public String getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	public int getCousrePrice() {
		return CousrePrice;
	}
	public void setCousrePrice(int cousrePrice) {
		CousrePrice = cousrePrice;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	private String PaymentDate;
	private int CousrePrice;
	private int TotalAmount;

}
