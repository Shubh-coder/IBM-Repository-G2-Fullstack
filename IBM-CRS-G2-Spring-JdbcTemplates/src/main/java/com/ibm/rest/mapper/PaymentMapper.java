/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Payment;
import com.ibm.rest.bean.TotalFees;

/**
 * @author 003NRH744
 *
 */
public class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException{
		Payment payment = new Payment();
		payment.setPayment_Method(rs.getString("Payment_Method"));
		payment.setTotal_Amount(rs.getInt("Total_Amount"));
		payment.setStudent_Id(rs.getInt("Student_Id"));
		return payment;

	}

}
