package com.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.JavaGenerics;
import utilities.WebDriverGenerics;

public class OHRM_LoginPage extends WebDriverGenerics {
	
//	WebDriver driver;
	
	public void login() throws Exception {
		WebElement text_Header = driver.findElement(By.tagName("h5"));
		WebElement textBox_UserName = driver.findElement(By.name("username"));
		WebElement textBox_Password = driver.findElement(By.name("password"));
		WebElement button_Login = driver.findElement(By.xpath("//button[@type='submit']"));

		JavaGenerics js = new JavaGenerics();
		js.takeScreenshots();

		JavaGenerics jg = new JavaGenerics();
		textBox_UserName.sendKeys(jg.readAProperty("username"));
		textBox_Password.sendKeys(jg.readAProperty("password"));
		js.takeScreenshots();
		button_Login.click();


		WebElement button_Upgrade = driver.findElement(By.xpath("//button[text() = ' Upgrade']"));
		waitForElementToBeVisible(button_Upgrade, 5);
		js.takeScreenshots();
	}

	public void goToOrangeHRMSocialMedia(String mediaName) {

		List<WebElement> socialMedia = driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']//a"));
//		System.out.println(socialMedia.size());
		
		for (WebElement oneMedia : socialMedia) {
//			System.out.println(oneMedia.getText());
			if (oneMedia.getAttribute("href").contains(mediaName.toLowerCase())) {
//				System.out.println("Hello");
				oneMedia.click();
				break;
			}
		}
	}


}
