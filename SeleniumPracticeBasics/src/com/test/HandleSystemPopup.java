package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSystemPopup {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://pixlr.com/x/");

		driver.findElement(By.id("welcome-open-image")).click();
		System.load("/home/gyanesh/Pictures/bdd.png");
		

//		driver.quit();
	}

}
