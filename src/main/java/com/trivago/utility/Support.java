package com.trivago.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Support {

	public Support(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private WebDriver driver;

	public String checkin_date(String duration, int count) {

		Date date = new Date();
		// System.out.println(date);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String date1 = sdf.format(date);
		//System.out.println(date1);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (duration.equalsIgnoreCase("days")) {
			c.add(Calendar.DAY_OF_MONTH, count);
		} else if (duration.equalsIgnoreCase("months")) {
			c.add(Calendar.MONTH, count);
		} else if (duration.equalsIgnoreCase("years")) {
			c.add(Calendar.YEAR, count);
		}

		String date2 = sdf.format(c.getTime());
		// System.out.println(date2);
		return date2;
	}
}
