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

public class AnswerTestCaseThree {
	private WebDriver driver;
	private WebElement alert;
	
	@Before
	public void setupTestCaseThree() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 driver = (WebDriver) new ChromeDriver();
		 driver.manage().window().setSize(new Dimension(1366, 768));
		
		driver.get("http://the-internet.herokuapp.com/");
		try {
			Thread.sleep(5000);
			WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[31]/a"));
			targetElement.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCaseThreeUp() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.UP);
		alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]"));
		assertEquals("You entered: UP",alert.getText());
	}
	@Test
	public void testCaseThreeDown() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
		alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]"));
		assertEquals("You entered: DOWN",alert.getText());

	}
	@Test
	public void testCaseThreeLeft() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.LEFT);
		alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]"));
		assertEquals("You entered: LEFT",alert.getText());

	}
//	
	@Test
	public void testCaseThreeRight() {
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.RIGHT);
		alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]"));
		assertEquals("You entered: RIGHT",alert.getText());
	}
	
	
	
	
	
	
}
