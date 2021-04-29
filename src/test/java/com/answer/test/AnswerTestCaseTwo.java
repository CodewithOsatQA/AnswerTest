package com.answer.test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnswerTestCaseTwo {
	private WebDriver driver;
	

	
	
	
	
	
	@Before
	public void setupTestCaseTwo() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 driver = (WebDriver) new ChromeDriver();
		 driver.manage().window().setSize(new Dimension(1366, 768));
		
		driver.get("http://the-internet.herokuapp.com/");
		try {
			Thread.sleep(5000);
			WebElement targetElement = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[26]/a"));
			targetElement.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCaseTwo() {
		
		try {
			Thread.sleep(5000);
			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			
			//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
			
			WebElement alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
			
			
			 assertEquals("Infinite Scroll",alert.getText());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
