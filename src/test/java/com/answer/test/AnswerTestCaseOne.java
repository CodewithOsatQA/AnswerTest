package com.answer.test;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AnswerTestCaseOne {
	
	private WebDriver driver;
	String usernameWrong = "helloWorld";
	String passwordWrong = "Worldhello";
	String usernameCorrect = "tomsmith";
	String passwordCorrect = "SuperSecretPassword!";
	
	@Before
	
	public void setupTestCaseOne() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 driver = (WebDriver) new ChromeDriver();
		 driver.manage().window().setSize(new Dimension(1366, 768));
		
		driver.get("http://the-internet.herokuapp.com/");
		try {
			Thread.sleep(5000);
			WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a"));
			targetElement.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

    @Test
    public void testCaseOneScenarioOne(){
    	
    	//Correct Username and Wrong Password
        
        try {
            Thread.sleep(2000);
           
            WebElement userNameElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input"));
            WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));
            WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i"));
            userNameElement.sendKeys(usernameCorrect);
            passwordElement.sendKeys(passwordWrong);
            Thread.sleep(1000);
           
   
            
            buttonElement.submit();
            Thread.sleep(3000);
            
            WebElement alert = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
            String[] test = alert.getText().split("!");
           

            assertEquals("Your password is invalid",test[0]);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    
    @Test
    
    public void testCaseOneScenarioTwo() {
    	//Incorrect Username and Correct Passowrd
    	
    	 try {
             Thread.sleep(2000);
            
             WebElement userNameElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input"));
             WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));
             WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i"));
             userNameElement.sendKeys(usernameWrong);
             passwordElement.sendKeys(passwordCorrect);
             Thread.sleep(1000);
            
    
             
             buttonElement.submit();
             Thread.sleep(3000);
             
             WebElement alert = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
             String[] test = alert.getText().split("!");
            

             assertEquals("Your username is invalid",test[0]);

         } catch (InterruptedException e) {
             e.printStackTrace();
         }
    	
    }
    
    @Test
    
    public void testCaseScenarioThree() {
		// Correct Username and Correct Password
    	
    	try {
            Thread.sleep(2000);
           
            WebElement userNameElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input"));
            WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));
            WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i"));
            userNameElement.sendKeys(usernameCorrect);
            passwordElement.sendKeys(passwordCorrect);
            Thread.sleep(1000);
           
   
            
            buttonElement.submit();
            Thread.sleep(3000);
            
            WebElement alert = driver.findElement(By.xpath("/html/body/div[1]/div/div"));
            String[] test = alert.getText().split("!");
           

            assertEquals("You logged into a secure area",test[0]);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
}
