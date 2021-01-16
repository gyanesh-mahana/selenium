package com.test;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class HandleAlertWindowsFrames {

	private static void handleWebPopup() throws InterruptedException {

		WebDriverBasics wbd = new WebDriverBasics("firefox");
		WebDriver driver = wbd.openURL("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.manage().window().fullscreen();
//		driver.manage().deleteAllCookies();
//		driver.findElement(By.cssSelector("input.signinbtn")).click();

		driver.findElement(By.name("proceed")).click();

		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);// MILLISECONDS
		if (alert.getText().equals("Please enter a valid user name")) {
			System.out.println(String.format("PASSED:: Expected:%s, Actual:%s", "Please enter a valid user name",
					alert.getText()));
		} else {
			System.out.println(String.format("FAILURE:: Expected:%s, Actual:%s", "Please enter a valid user name",
					alert.getText()));
		}
		alert.accept();

		Thread.sleep(2000);// MILLISECONDS
		driver.findElement(By.name("login")).sendKeys("gyanesh.mahana");

		driver.findElement(By.name("proceed")).click();

		System.out.println(alert.getText());

		if (alert.getText().equals("Please enter your password")) {
			System.out.println(String.format("PASSED:: Expected:%s, Actual:%s", "Please enter a valid user name",
					alert.getText()));
		} else {
			System.out.println(
					String.format("FAILURE:: Expected:%s, Actual:%s", "Please enter your password", alert.getText()));
		}
		alert.accept();

		driver.findElement(By.id("password")).sendKeys("@Red7862#*G");
		driver.findElement(By.name("proceed")).click();

//		alert.dismiss();
		driver.quit();

	}

	private static void handleFilePopup() throws InterruptedException {
		WebDriverBasics wbd = new WebDriverBasics("firefox");
		WebDriver driver = wbd.openURL("https://demoqa.com/automation-practice-form");
//		driver.manage().window().fullscreen();
//		driver.manage().deleteAllCookies();

		driver.findElement(By.id("uploadPicture")).sendKeys("/home/gyanesh/Pictures/bdd.png");

		Thread.sleep(2000);
		driver.quit();

	}

	private static void handleBrowserWindows() throws InterruptedException {
		WebDriverBasics wbd = new WebDriverBasics("firefox");
		WebDriver driver = wbd.openURL("https://demoqa.com/browser-windows");

		/*
		 * handle new tab
		 */
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
//		for(String handle:windowHandles) {
		driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
//		driver.switchTo().window((String) windowHandles.toArray()[0]);
//		}

		System.out.println(driver.getPageSource());

		driver.switchTo().window((String) windowHandles.toArray()[0]);
		/*
		 * New window
		 */
		driver.findElement(By.id("windowButton")).click();
//		Thread.sleep(2000);
		windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
//		for(String handle:windowHandles) {
		driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
//		driver.switchTo().window((String) windowHandles.toArray()[0]);
//		}
//		driver.manage().window().maximize();
		Dimension d = driver.manage().window().getSize();
		Dimension dd = new Dimension(2 * d.height, 2 * d.width);
		driver.manage().window().setSize(dd);

		System.out.println(driver.getPageSource());

		driver.close();
//		Thread.sleep(2000);
		driver.switchTo().window((String) windowHandles.toArray()[0]);

//		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.quit();
//		driver.close();
	}

	private static void handleFrames() {
		WebDriverBasics wbd = new WebDriverBasics("chrome");
		WebDriver driver = wbd.openURL("https://demoqa.com/frames");
		/*
		 * frames
		 */
//		List<WebElement> listFrame = driver.findElements(By.tagName("iframe"));
//		for(WebElement frame:listFrame) {
//			System.out.println(frame.getAttribute("id"));
////			driver.switchTo().frame(frame);
////			driver.findElement(By.id("sampleHeading"));
//		}

		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		System.out.println(driver.getPageSource());

		driver.switchTo().parentFrame();
		System.out.println(driver.getPageSource());

		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		System.out.println(driver.getPageSource());

		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		handleWebPopup();

		handleFilePopup();

		handleBrowserWindows();

		handleFrames();
	}

}
