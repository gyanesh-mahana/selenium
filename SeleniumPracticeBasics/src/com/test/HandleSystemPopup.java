package com.test;
/*
 * AutoIT can be used to deal with Windows system pop-ups and non HTML pop-ups
 * 				similarly
 * Sikuli can be used to deal with Linux system pop-ups and non HTML pop-ups
 */

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Screen;

//import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class HandleSystemPopup {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.get("https://www.online-image-editor.com/");

		try {
			driver.findElement(By.cssSelector("label.upload.right.btn_upload")).click();

//			Screen uploadScreen = new Screen();

		} catch (NoSuchElementException e) {
			System.out.println("No element found!!!");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
