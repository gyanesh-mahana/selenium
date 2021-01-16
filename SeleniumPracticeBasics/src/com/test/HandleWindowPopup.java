package com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		WebElement twitter = driver.findElement(By.xpath("//div[@class='panel-body']//a[contains(text(), 'Follow On Twitter')]"));
		WebElement facebook = driver.findElement(By.xpath("//div[@class='panel-body']//a[contains(text(), 'Like us On Facebook')]"));
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(twitter));
		
		twitter.click();
		
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(facebook));
		
		facebook.click();
		
		Set<String> handles = driver.getWindowHandles();
////		Using Loop
//		for(String handle:handles) {
//			System.out.println("Window handle: "+handle);
//			
//			driver.switchTo().window(handle);
//			System.out.println(driver.getTitle());
//		}

//		Using Iterator
		Iterator<String> iter = handles.iterator();

		String parentHandle = iter.next();

		while (iter.hasNext()) {
			String childHandle = iter.next();
			driver.switchTo().window(childHandle);
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Selenium Easy"));
			
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		driver.switchTo().window(parentHandle);
		System.out.println(driver.getTitle());
		driver.close();

		driver.quit();
	}

}
