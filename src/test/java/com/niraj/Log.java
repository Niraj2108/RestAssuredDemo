package com.niraj;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger logger = Logger.getLogger(Log.class.getName());

	
	public static  void info(String s) {
		logger.info(s);
	}
	
	public static  void debug(String s) {
		logger.debug(s);
	}
}
