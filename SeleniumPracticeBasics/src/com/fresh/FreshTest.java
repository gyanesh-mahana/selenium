package com.fresh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FreshTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreshTest f = new FreshTest();
		WebDriver driver = f.openURL(getProperty("url"));

		driver.quit();
	}

	public WebDriver openURL(String url) {

		WebDriver driver = setBrowser(getProperty("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(getProperty("timeout_page")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout_implicit")), TimeUnit.SECONDS);

		driver.get(url);
		return driver;
	}

	private static WebDriver setBrowser(String browser) {

		WebDriver driver = null;

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/gyanesh/Downloads/JavaLibrary/geckodriver-v0.28.0-linux32/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Browser driver available for: " + browser);
		}

		return driver;
	}

	private static String getProperty(String key) {
		Properties prop = new Properties();
		FileInputStream configStream = null;
		try {
			configStream = new FileInputStream("/home/gyanesh/git/selenium/SeleniumPracticeBasics/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(configStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
