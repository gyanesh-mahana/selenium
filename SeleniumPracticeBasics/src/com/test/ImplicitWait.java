package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;

public class ImplicitWait {

	public static void main(String[] args) throws TimeoutException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

			driver.get("https://www.polygon.com/");
		} finally {
			driver.quit();
		}

	}

}
