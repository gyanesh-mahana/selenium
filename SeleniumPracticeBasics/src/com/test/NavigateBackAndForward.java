package com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBackAndForward {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.navigate().to("https://maps.google.com/");
		driver.navigate().to("https://drive.google.com/");
		driver.navigate().to("https://translate.google.com/");
		driver.navigate().to("https://news.google.com/");
//		driver.get("https://maps.google.com/");
//		driver.get("https://drive.google.com/");
//		driver.get("https://translate.google.com/");
//		driver.get("https://news.google.com/");

//		driver.findElement(By.xpath("//a[@aria-label='India']")).click();
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//a[@aria-label='World']")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//a[@aria-label='Health']")).click();
//		Thread.sleep(2000);
//		
		driver.navigate().back();
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

		driver.navigate().refresh();
		Thread.sleep(2000);

		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
	}

}
