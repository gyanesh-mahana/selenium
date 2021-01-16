/*
 * Basics
 */
package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	private WebDriver driver;
	private String browser;

	public WebDriverBasics(String browser) {
		// constructor
		this.browser = browser;
		this.driver = getDriver();
	}

	private WebDriver getDriver() {
		/*
		 * Set Property for the driver executable file provided by the browser vendor
		 * and initialize new driver
		 */
		if (this.browser == "chrome") {
			System.setProperty("webdriver.chrome.driver",
					"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");
			this.driver = new ChromeDriver();
		} else if (this.browser == "firefox") {

			System.setProperty("webdriver.gecko.driver",
					"/home/gyanesh/Downloads/JavaLibrary/geckodriver-v0.28.0-linux32/geckodriver");
			this.driver = new FirefoxDriver();
		} else {
			System.out.println("No driver for browser: " + browser);
		}

		return this.driver;
	}

	public WebDriver openURL(String url) {
		this.driver.get(url);
		return this.driver;
	}

	public void quitDriver() {
		this.driver.quit();
	}

//	public static void main(String[] args) {
//
//		WebDriverBasics wbd = new WebDriverBasics("chrome");
//
//		/*
//		 * Open URL
//		 */
//		WebDriver driver = wbd.openURL("https://www.selenium.dev/");
//
//		String pageTitle = driver.getTitle();
//
//		System.out.println(pageTitle);
//
//		wbd.quitDriver();
//
//	}

}
