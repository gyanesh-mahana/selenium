package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.get("https://www.polygon.com/");

		WebElement ele = driver.findElement(By.xpath("//li[@data-nav-item-id='features']/a"));
		WebDriverWait featureWait = new WebDriverWait(driver, 10);
//		featureWait.until(ExpectedConditions.elementToBeClickable(ele));
		featureWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-nav-item-id='features']/a")));
//		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(ele));
		
		ele.click();
		
		driver.quit();
	}

}
