package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

		// HtmlUnitDriver not supported in v3.x
		// so need to download the jar as external library
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.get("https://www.polygon.com/");

		System.out.println(driver.getTitle());

		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}

		System.out.println(list.size());
		driver.quit();

	}

}
