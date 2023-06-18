package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

public class FacebookDemo {
	WebDriver driver; 
	
	@BeforeSuite
	public void beforeSuite() {
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com");
		
	}

	@Test
	public void pageTitleValidation() {
		String expectedResult = "Facebook – log in or sign up";
		String actualResult = driver.getTitle();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title, ");
	}
	
	
	@Test
	public void loginTest() {
		driver.findElement(By.id("email")).sendKeys("dan@gmail.com");
	}
	
	

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
