/**
 * 
 */
package com.crs.ibm.configuration;

import org.springframework.context.annotation.Bean;

import com.crs.ibm.service.UserInterface;
import com.crs.ibm.service.UserService;

/**
 * @author 003NRH744
 *
 */
public class UserConfig {
	@Bean(name="userBean")
    public UserInterface userInterface() {
        return new UserService();
    }

}
