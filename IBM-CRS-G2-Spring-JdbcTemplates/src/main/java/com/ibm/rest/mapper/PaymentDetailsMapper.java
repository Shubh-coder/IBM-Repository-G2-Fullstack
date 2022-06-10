/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.PaymentDetails;

/**
 * @author 003NRH744
 *
 */
public class PaymentDetailsMapper implements RowMapper<PaymentDetails> {

	@Override
	public PaymentDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
		PaymentDetails paymentdetails =new PaymentDetails();
		paymentdetails.setCard_Number(rs.getString("Card_Number"));
		paymentdetails.setCvv(rs.getInt("Cvv"));
		paymentdetails.setExpiry_Date(rs.getString("Expiry_Date"));
		paymentdetails.setUpi_Number(rs.getString("Upi_Number"));
		return paymentdetails;
	}

}
