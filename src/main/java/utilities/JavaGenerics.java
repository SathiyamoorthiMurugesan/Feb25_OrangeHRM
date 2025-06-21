package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class JavaGenerics extends WebDriverGenerics {

	public static String propertyFilePath = ".\\MyProject.properties";
	Properties prop = new Properties();

	public String readAProperty(String propName) throws Exception {

		FileReader reader = new FileReader(propertyFilePath);
		prop.load(reader);

		String prop_value = prop.getProperty(propName);
		return prop_value;
	}
	
	public void takeScreenshots() throws IOException {
		TakesScreenshot screenShot = ((TakesScreenshot) driver);
		File screenshotImage = screenShot.getScreenshotAs(OutputType.FILE);

		LocalDateTime localDateAndTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String dateTime = formatter.format(localDateAndTime);

//		File file = new File(".\\src\\test\\resources\\screenshots\\123.jpeg");
		File file = new File(".\\screenshots\\" + dateTime + ".jpeg");
		FileHandler.copy(screenshotImage, file);
	}
	
//	public static void main(String[] args) throws Exception {
//		JavaGenerics obj = new JavaGenerics();
//		System.out.println(obj.readAProperty("browser"));
//	}

}
