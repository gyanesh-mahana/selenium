package com.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenhot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		driver.get("https://en.wikipedia.org/");

		driver.findElement(By.xpath("//a[text()='Current events']")).click();

		/*
		 * Screenshot
		 */
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("/home/gyanesh/eclipse-workspace_testing/SeleniumTest/Screenshots/wiki_event.png"));

		driver.findElement(By.xpath("//a[text()='Download as PDF']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.quit();

	}

}
