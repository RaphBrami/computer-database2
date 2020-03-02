package com.excilys.log4j;
import org.slf4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Log4J {
	
		
	final static Logger logger = org.slf4j.LoggerFactory.getLogger(Log4J.class);
	

	 public static void afficherMessage(String message) {
		 
		 PropertyConfigurator.configure(Log4J.class.getClassLoader().getResource("log4j.properties"));
	     logger.info(message);
	     
	 }
}



