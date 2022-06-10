/**
 * 
 */
package com.crs.ibm.configuration;
import org.springframework.context.annotation.Bean;
import com.crs.ibm.service.StudentInterface;
import com.crs.ibm.service.StudentService;

/**
 * @author 003NRH744
 *
 */
public class StudentConfig {
	@Bean(name="studentBean")
	public StudentInterface studentInterface() {
        return new StudentService();
        
	}

}
