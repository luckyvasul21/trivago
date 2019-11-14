package com.trivago.SuiteTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.trivago.utility.PageFactory;
import com.trivago.utility.Properties;
import com.trivago.utility.Support;

public class Practice {
	
	WebDriver driver;
	
	static java.util.Properties config = Properties.readPropFile();
	PageFactory pf = new PageFactory();
	Support support = new Support(driver);
	
	public String search_city = config.getProperty("city");
	public String duration = config.getProperty("duration");
	public int duration_count = Integer.parseInt(config.getProperty("duration_count"));
	public String search_filter1 = config.getProperty("filter_spa");
	public String search_filter2 = config.getProperty("filter_wifi");
	public String roomtype = config.getProperty("roomtype");
	
	
	
	@BeforeClass
	public static void setUp() {

		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "killdriver.bat");
			System.out.println(System.getProperty("user.dir"));
			File dir = new File(System.getProperty("user.dir") + "\\external_resources");
			pb.directory(dir);
			pb.start();
			Thread.sleep(500);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Before
	public void enter_site() throws InterruptedException {
		try {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\external_resources\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			Thread.sleep(250);
			//driver.manage().window().maximize();

			//driver.get("https://trivago.com/");
			driver.get(config.getProperty("url"));
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void close_window() {
		driver.close();
	}
	

	@Test
	public void TestCase1_test() {

		try {

			//List<WebElement> hotel_list = get_hotel_list(config.getProperty("city"), config.getProperty("filter_wifi"));
			List<WebElement> hotel_list = get_hotel_list(search_city, search_filter2, support.checkin_date(duration, duration_count), support.checkin_date("days", 1), roomtype);

			// System.out.println(hotel_list.size());

			for (int i = 0; i < hotel_list.size(); i++) {
				// System.out.println(hotel_list.get(i).getText());
				if (hotel_list.get(i).getText().equalsIgnoreCase("Cork International Hotel")) {
					System.out.println(hotel_list.get(i).getText() + " is listed");
					break;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void TestCase2_test() {

		try {

			//List<WebElement> hotel_list = get_hotel_list(config.getProperty("city"), config.getProperty("filter_wifi"));
			//List<WebElement> hotel_list = get_hotel_list("Cork", "Free WiFi", support.checkin_date("days", 90), support.checkin_date("days", 91), "Double Room");
			List<WebElement> hotel_list = get_hotel_list(search_city, search_filter2, support.checkin_date(duration, duration_count), support.checkin_date("days", 1), roomtype);

			// System.out.println(hotel_list.size());

			for (int i = 0; i < hotel_list.size(); i++) {
				// System.out.println(hotel_list.get(i).getText());
				if (hotel_list.get(i).getText().equalsIgnoreCase("Jurys Inn Cork")) {
					Assert.fail("Jurys Inn Cork hotel is listed");
					break;
				} 
			} System.out.println("Jurys Inn Cork is not listed");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void TestCase3_test() {

		try {

			//List<WebElement> hotel_list = get_hotel_list(config.getProperty("city"), config.getProperty("filter_spa"));
			//System.out.println(hotel_list.size());
			//List<WebElement> hotel_list = get_hotel_list("Cork", "Spa", support.checkin_date("days", 90), support.checkin_date("days", 91), "Double Room");
			List<WebElement> hotel_list = get_hotel_list(search_city, search_filter1, support.checkin_date(duration, duration_count), support.checkin_date("days", 1), roomtype);


			for (int i = 0; i < hotel_list.size(); i++) {
				if (hotel_list.get(i).getText().equalsIgnoreCase("The River Lee")) {
					System.out.println(hotel_list.get(i).getText() + " is listed");
					break;
				}
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TestCase4_test() {

		try {

			//List<WebElement> hotel_list = get_hotel_list(config.getProperty("city"), config.getProperty("filter_spa"));
			// System.out.println(hotel_list.size());
			//List<WebElement> hotel_list = get_hotel_list("Cork", "Spa", support.checkin_date("days", 90), support.checkin_date("days", 91), "Double Room");
			List<WebElement> hotel_list = get_hotel_list(search_city, search_filter1, support.checkin_date(duration, duration_count), support.checkin_date("days", 1), roomtype);

			for (int i = 0; i < hotel_list.size(); i++) {
				// System.out.println(hotel_list.get(i).getText());
				if (hotel_list.get(i).getText().equalsIgnoreCase("Jurys Inn Cork")) {
					Assert.fail("Jurys Inn Cork hotel is listed");
					break;
				}
			} System.out.println("Jurys Inn Cork is not listed");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public List<WebElement> get_hotel_list(String city, String filter,String checkin_date, String checkout_date, String roomtype) throws ElementNotInteractableException {
		
		List<WebElement> hotel_list = null;

		try {

			WebElement test_data_1_input = driver.findElement(By.id("horus-querytext"));
			test_data_1_input.sendKeys(city);

			Thread.sleep(2000);
			
			List<WebElement> search_list = driver.findElements(By.cssSelector(".ssg-title"));
			
			for (int i = 0; i < search_list.size(); i++) {
				if(search_list.get(i).getText().trim().equalsIgnoreCase(city)) {
					search_list.get(i).click();
					break;
				}
			}

// to do wait until instead of sleep
			Thread.sleep(1000);
			
			pf.date_picker(driver, "checkin", checkin_date);
			pf.date_picker(driver, "checkout", checkout_date);
			pf.room_select(driver, roomtype);
			
			List<WebElement> filter_list = driver.findElements(By.cssSelector(".fl-group.clearfix h4+ul li button"));
			
			for (int i = 0; i <filter_list.size(); i++) {
				//System.out.println(filter_list.get(i).getAttribute("title"));
				//System.out.println(filter);
				
				if (filter_list.get(i).getAttribute("title").equalsIgnoreCase(filter)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", filter_list.get(i));
					Thread.sleep(250);
					
				filter_list.get(i).click();
				Thread.sleep(250);
				break;
			}
			}

			hotel_list = driver.findElements(By.cssSelector(".item__details h3"));

			// System.out.println(hotel_list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hotel_list;
	}

}