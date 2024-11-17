package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import elements.LoginPage;

public class TestCases {
	public WebDriver driver;
	LoginPage config = new LoginPage();
	LoginPage login;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void registerUser() throws InterruptedException, IOException {

		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\selenium\\DemoEcom\\src\\test\\resources\\resources.properties");
		prop.load(fis);
		String name = prop.getProperty("name");
		String mail = prop.getProperty("mail");
		driver.get(config.baseUrl);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//	3. Verify that home page is visible successfully
		WebElement element = driver.findElement(config.pageverify);
		String actualText = element.getText();
		// The expected text
		String expectedText = "Home";
		// Verify that the text matches
		Assert.assertEquals(actualText, expectedText, "The text on the page does not match the expected value.");
		//4. Click on 'Signup / Login' button
		driver.findElement(config.signup).click();
		//5. Verify 'New User Signup!' is visible
		WebElement signup =driver.findElement(config.signuppage);
		String actual =signup.getText();
		String expected ="Login to your account";
		Assert.assertEquals(actual, expected, "The text on the page does not match the expected value.");

		//6. Enter name and email address
		driver.findElement(config.signname).sendKeys(name);
		driver.findElement(config.signamail).sendKeys(mail);
		Thread.sleep(5000);	
		//7. Click 'Signup' button
		driver.findElement(config.signbutton).click();
		//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		


	}

	@AfterTest
	public void down() {
		driver.close();
		driver.quit();
	}


}