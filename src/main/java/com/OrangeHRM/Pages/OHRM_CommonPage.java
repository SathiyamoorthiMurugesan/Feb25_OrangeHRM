package com.OrangeHRM.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.JavaGenerics;
import utilities.WebDriverGenerics;

public class OHRM_CommonPage extends WebDriverGenerics {
	public void goToAPage(String pageName) throws IOException {

		List<WebElement> allPages = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']//span"));

		for (WebElement eachPage : allPages) {
			if (eachPage.getText().equalsIgnoreCase(pageName)) {
				eachPage.click();
				break;
			}
		}
		
		WebElement text_Header = driver.findElement(By.tagName("h6"));
		waitForElementToBeVisible(text_Header, 5);
		
		waitForElementToBeVisible(driver.findElement(By.xpath("//label[text() = 'Employee Name']")), 5);
		JavaGenerics js = new JavaGenerics();
		js.takeScreenshots();
	}
}
