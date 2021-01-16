/*
 * Locators
 */

package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsTest {

	public static void main(String[] str) {

		WebDriverBasics wbd = new WebDriverBasics("chrome");
		WebDriver driver = wbd.openURL("https://www.ebay.com/");
		List<WebElement> eleList = driver.findElements(By.tagName("input"));

		System.out.println("1.TagName()-------------------------------");
		for (WebElement ele : eleList) {
			System.out.println("ID:" + ele.getAttribute("id") + ",TYPE:" + ele.getAttribute("type"));
		}

		System.out.println("2.id()--------------------------------");
		WebElement ele = driver.findElement(By.id("gh-logo"));
		System.out.println(ele.getTagName());

		System.out.println("3.cssSelector()--------------------------------");
		ele = driver.findElement(By.cssSelector("select#gh-cat.gh-sb "));
		System.out.println(ele.getText());
		eleList = driver
				.findElements(By.xpath("//ul[@class='hl-cat-nav__container']//li[@class='hl-cat-nav__js-tab']/a"));

		System.out.println("4.xpath()--------------------------------");
		for (WebElement ele1 : eleList) {
			System.out.println("Text:" + ele1.getText());
		}

		System.out.println("5.linkText()--------------------------------");
		ele = driver.findElement(By.linkText("Cookies"));
		System.out.println(ele.getAttribute("href"));

		System.out.println("6.partialLinkText()--------------------------------");
		ele = driver.findElement(By.partialLinkText("Help"));
		System.out.println(ele.getAttribute("href"));

		System.out.println("7.className()--------------------------------");
		eleList = driver.findElements(By.className("gh-p"));
		for (WebElement ele2 : eleList) {
			System.out.println("Text:" + ele2.getText());
		}

		System.out.println("8.name()--------------------------------");
		ele = driver.findElement(By.name("_sacat"));
		System.out.println(ele.getTagName());

		wbd.quitDriver();

	}
}
