/**
 * 
 */
package com.crs.ibm.configuration;

import org.springframework.context.annotation.Import;

/**
 * @author 003NRH744
 *
 */
@Import({AdminConfig.class,ProfessorConfig.class,StudentConfig.class,UserConfig.class})
public class ApplicationConfig {

}
