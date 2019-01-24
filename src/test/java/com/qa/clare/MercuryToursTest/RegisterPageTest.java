package com.qa.clare.MercuryToursTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class RegisterPageTest {

	WebDriver driver;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@BeforeClass
	public static void startUpReports() {
		report = new ExtentReports(Constant.reportLocation , false);
	}
	
	
	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", Constant.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testToRegister() {
		driver.get(Constant.URL);
		RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
		page.registerPerson();
		
		SuccessRegisterPage page2 = PageFactory.initElements(driver, SuccessRegisterPage.class);
		page2.signInClick();
		
		LoginPage page3 = PageFactory.initElements(driver, LoginPage.class);
		page3.completeLogin();
		
		FlightFinderPage page4 = PageFactory.initElements(driver, FlightFinderPage.class);
		
		
		assertEquals("Test failed as unable to register","Flight Details", page4.flightPageConfirmation());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownReports() {
		report.endTest(test);
		report.flush();
		
	}
	
}
