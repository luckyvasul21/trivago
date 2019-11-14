package com.trivago.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageFactory {

	public void date_picker(WebDriver driver, String checkbox, String datetoselect) {
		try {
			Thread.sleep(1000);
			//support.clickonEmelent("cssSelector", "#horus-querytext");
			driver.findElement(By.cssSelector("#horus-querytext")).click();
			Thread.sleep(500);
			//support.clickonEmelent("cssSelector", ".horus__row.horus__row--detail div button[class*='" + checkbox + "']");
			driver.findElement(By.cssSelector(".horus__row.horus__row--detail div button[class*='" + checkbox + "']")).click();
			
			Thread.sleep(500);

			if (checkbox.contains("checkin")) {
				for (int j2 = 0; j2 <= 90 / 31; j2++) {
					Thread.sleep(1000);
					//support.clickonEmelent("cssSelector", "button.cal-btn-next");
					driver.findElement(By.cssSelector("button.cal-btn-next")).click();
				}
			}

			List<WebElement> date_picker = driver.findElements(By.cssSelector(".cal-day.cal-is-selectable"));

			for (int j = 0; j < date_picker.size(); j++) {

				if (date_picker.get(j).getAttribute("datetime").toString().equalsIgnoreCase(datetoselect)) {
					date_picker.get(j).click();
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void room_select(WebDriver driver, String roomtype) {
		try {
			Thread.sleep(500);
			//support.clickonEmelent("cssSelector", "#horus-querytext");
			driver.findElement(By.cssSelector("#horus-querytext")).click();
			Thread.sleep(500);
			//support.clickonEmelent("cssSelector", ".horus__row.horus__row--detail div button[class*='roomtype']");
			driver.findElement(By.cssSelector(".horus__row.horus__row--detail div button[class*='roomtype']")).click();
			Thread.sleep(1000);
			
			List<WebElement> roomtype_list = driver.findElements(By.cssSelector("button[class*='roomtype'] span.df_dropdown_option"));
			
			//System.out.println(roomtype_list.size());
			for (int i = 0; i < roomtype_list.size(); i++) {
				//System.out.println(roomtype_list.get(i).getText());
				if (roomtype_list.get(i).getText().equalsIgnoreCase(roomtype)) {
					roomtype_list.get(i).click();
					break;
				}
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}