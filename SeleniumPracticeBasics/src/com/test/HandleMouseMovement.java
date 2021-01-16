package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleMouseMovement {

	WebDriver driver;

	public HandleMouseMovement(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/gyanesh/Downloads/JavaLibrary/chromedriver_linux64/chromedriver");

			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/gyanesh/Downloads/JavaLibrary/geckodriver-v0.28.0-linux32/geckodriver");

			driver = new FirefoxDriver();
		}
	}

	public void doMouseHover(WebDriver driver) throws InterruptedException {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.goindigo.in/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Book"))).build().perform();
		Thread.sleep(2000);
		List<WebElement> listEle = driver
				.findElements(By.xpath("//div[@class='nav-inner-items']//div[@class='col-md-4']/a"));
//		driver.findElement(By.xpath("//div[@class='nav-inner-items']//a/h6[text()='Book a flight']")).click();
		for (WebElement ele : listEle) {
			if (ele.getText().equals("Book a flight")) {
				ele.click();
				break;
			}
//			System.out.println(ele.getText());
//			System.out.println(ele.isEnabled());
		}
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.linkText("Manage"))).build().perform();

		Thread.sleep(2000);
		driver.quit();
	}

	private void doDragAndDrop(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop");

		driver.findElement(By.id("Photo Manager")).click();
		System.out.println(driver.findElement(By.id("Photo Manager")).getAttribute("class"));
//		driver.findElement(By.id("Accepted Elements")).click();
//		System.out.println(driver.findElement(By.id("Photo Manager")).getAttribute("class"));
//		System.out.println(driver.findElement(By.id("Accepted Elements")).getAttribute("class"));
//		driver.findElement(By.id("Propagation")).click();

		Thread.sleep(2000);
		List<WebElement> listFrame = driver.findElements(By.cssSelector("iframe.demo-frame.lazyloaded"));
		for (WebElement frame : listFrame) {
			if (frame.isDisplayed() && frame.isEnabled()) {
				System.out.println("Found frame" + frame.isDisplayed() + frame.isEnabled() + frame.isSelected());
				/*
				 * After swithTo() the frame changes and hence the frame reference is not
				 * present inside/attached to the current frame throws StaleElementReference
				 * Exception
				 */
				driver.switchTo().frame(frame);

				// element in frame
				By imgOut = By.xpath("//ul[@id='gallery']/li");
				By imgTrash = By.xpath("//ul[@class='gallery ui-helper-reset']/li");

				int totalCount = driver.findElements(imgOut).size();
				List<WebElement> imgList = driver.findElements(By.tagName("img"));
				Actions a = new Actions(driver);
				WebElement target = driver.findElement(By.id("trash"));
				for (WebElement img : imgList) {

//					a.clickAndHold(img).build().perform();
//					a.moveToElement(target).build().perform();
//					a.release().build().perform();
					a.dragAndDrop(img, target).build().perform();
				}

				Thread.sleep(3000);
				int newCount = driver.findElements(imgOut).size() + driver.findElements(imgTrash).size();
				if (totalCount == newCount) {
					System.out.println(String.format("<PASS>: oldCount=%d, newCount=%d", totalCount, newCount));
				} else {
					System.out.println(String.format("<FAIL>: oldCount=%d, newCount=%d", totalCount, newCount));
				}
			}
			driver.switchTo().parentFrame();
		}
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		HandleMouseMovement m = new HandleMouseMovement("chrome");

		WebDriver driver = m.driver;
		// mouse hover
		// mouse click

//		m.doMouseHover(driver);

		// drag and drop

		m.doDragAndDrop(driver);

	}

}
