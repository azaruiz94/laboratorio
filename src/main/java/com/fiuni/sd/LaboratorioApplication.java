package com.fiuni.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.ImportResource;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

@SpringBootApplication
//@ImportResource("classpath:memcached.xml")
@EnableCaching
public class LaboratorioApplication {
	
	private static final Logger logger = Logger.getLogger(LaboratorioApplication.class);

	public static void main(String[] args) {
		System.out.println(getLocalCurrentDate());
		SpringApplication.run(LaboratorioApplication.class, args);
	}
	
	private static String getLocalCurrentDate() {

		if (logger.isDebugEnabled()) {
			logger.debug("getLocalCurrentDate() is executed!");
		}

		LocalDate date = new LocalDate();
		return date.toString();
	}
}