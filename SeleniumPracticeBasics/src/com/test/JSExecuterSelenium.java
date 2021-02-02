package com.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSExecuterSelenium {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");

		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.get("https://www.flipkart.com");

		// close the login pop-up screen
		WebElement crossBtn = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(crossBtn));
		crossBtn.click();

		// Java Script Executor interface initialization
		JavascriptExecutor js = (JavascriptExecutor) (driver);


		WebElement searchEle = driver.findElement(By.name("q"));
//		searchEle.sendKeys("MacBook Pro");
		
		// sendKeys() alternative 1
		js.executeScript("arguments[0].value='MacBook Pro';", searchEle);
		
		// sendKeys() alternative 2
//		js.executeScript("var search = document.getElementsByName('q');" + "search[0].value='MacBook Pro';");
//		OR
//		js.executeScript("document.getElementsByName('q')[0].value='MacBook Pro';");
		
		Thread.sleep(2000);

		// scroll using Java Script execution
//		JavascriptExecutor js = (JavascriptExecutor)(driver);
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(2000);
		driver.quit();

	}

}
