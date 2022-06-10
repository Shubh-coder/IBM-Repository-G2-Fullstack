/**
 * 
 */
package com.crs.ibm.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.ibm.service.AdminInterface;
import com.crs.ibm.service.AdminService;



/**
 * @author 003NRH744
 *
 */
public class AdminConfig {
	@Bean(name="adminBean")
    public AdminInterface AdminInterface() {
        return new AdminService();
    }

}
