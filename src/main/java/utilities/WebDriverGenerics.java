package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverGenerics {
	
	public static WebDriver driver = null;

	public void openBrowser() throws Exception {

		JavaGenerics jg = new JavaGenerics();
		switch (jg.readAProperty("browser")) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}

		maximizeTheWindow();
		launchAWebApplication();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(jg.readAProperty("implicitWait"))));

	}
	
	public void maximizeTheWindow() {
		driver.manage().window().maximize();
	}

	public void launchAWebApplication() throws Exception {
		JavaGenerics jg = new JavaGenerics();
		driver.get(jg.readAProperty("url"));
	}
	
	public void waitForElementToBeVisible(WebElement ele, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void quitBrowser() {
		driver.quit();
	}

}
