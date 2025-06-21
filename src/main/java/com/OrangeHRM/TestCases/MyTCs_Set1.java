package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.Pages.OHRM_CommonPage;
import com.OrangeHRM.Pages.OHRM_LoginPage;

import utilities.WebDriverGenerics;

public class MyTCs_Set1 {
	
	@Test
	public void TC01() throws Exception {
		WebDriverGenerics wdg = new WebDriverGenerics();
		wdg.openBrowser();
		
		OHRM_LoginPage loginPage = new OHRM_LoginPage();
		loginPage.goToOrangeHRMSocialMedia("Facebook");
		
		wdg.quitBrowser();
	}

	@Test
	public void TC02() throws Exception {
		
		WebDriverGenerics wdg = new WebDriverGenerics();
		wdg.openBrowser();
		
		OHRM_LoginPage loginPage = new OHRM_LoginPage();
		loginPage.login();
		
		OHRM_CommonPage commonPage = new OHRM_CommonPage();
		commonPage.goToAPage("PIM");
		
		wdg.quitBrowser();
	}




}
