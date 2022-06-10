/**
 * 
 */
package com.crs.ibm.configuration;

import org.springframework.context.annotation.Bean;


import com.crs.ibm.service.ProfessorInterface;
import com.crs.ibm.service.ProfessorService;

/**
 * @author 003NRH744
 *
 */
public class ProfessorConfig {
	@Bean(name="professorBean")
    public ProfessorInterface professorInterface() {
        return new ProfessorService();
    }

}
