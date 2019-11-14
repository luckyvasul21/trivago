package com.trivago.utility;

import java.io.IOException;

public class Properties {

	public static java.util.Properties readPropFile() {
		
		
		java.util.Properties config = new java.util.Properties();
		
		try {
			config.load(Support.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return config;
	}
}
