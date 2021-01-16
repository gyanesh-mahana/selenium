package com.test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import java.lang.Exception;
import org.openqa.selenium.WebElement;

public class ImdbRegistration {
	public static void main(String[] str) {

		WebDriverBasics wbd = new WebDriverBasics("firefox");
		WebDriver driver = wbd.openURL("https://www.imdb.com/");

		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		try {
			// click on Register Link
			// register
			/**
			 * Using cssSelector
			 */
			List<WebElement> listEle = driver.findElements(By.cssSelector("div.ipc-button__text"));
			for (WebElement e : listEle) {
				if (e.getText().equals("Sign In")) {
					e.click();
					break;
				}
			}

			Assert.assertEquals("Sign in with IMDb - IMDb", driver.getTitle());

			driver.findElement(By.xpath("//div[@id='signin-options']//a[@class='list-group-item create-account ']"))
					.click();

			Assert.assertEquals("IMDb Registration", driver.getTitle());

			// *[@id="signin-options"]/div/div[2]/a
			// Fill the details
			// First Name
			// Last Name
			// Email
			// password
			// Click on create account
//
			driver.findElement(By.id("ap_customer_name")).sendKeys("Tom Jack");
//			driver.findElement(By.cssSelector("input#lastname")).sendKeys("Paul");
			driver.findElement(By.id("ap_email")).sendKeys("demo_automation@gmail.com");
//			driver.findElement(By.xpath("//input[@id='password']")).click();
			driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("12334Aabc");

			driver.findElement(By.cssSelector("input#ap_password_check")).sendKeys("12334Aabc");

			driver.findElement(By.xpath("//input[@id='continue']")).click();

			Assert.assertEquals("Authentication required", driver.getTitle());

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} finally {
			wbd.quitDriver();
		}
	}
}
