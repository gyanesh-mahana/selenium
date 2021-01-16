package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		driver.get("https://www.snapdeal.com/");

		List<WebElement> list = driver.findElements(By.xpath("//span[@class='catText']"));
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(), 'Computers & Gaming')]"))).build()
				.perform();

		driver.findElement(By.xpath("//li[@class='navlink hoverIn']//span[text()='View All']")).click();

		driver.navigate().back();
		List<WebElement> listEle = driver.findElements(By.xpath("//li/a[starts-with(@class, 'underLine')]"));
//		List<WebElement> listEle = driver.findElements(By.xpath("//li/a[contains(@class, 'OnHover')]"));
		for (WebElement ele : listEle) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}

}
