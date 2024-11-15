package testCases;

import java.time.Duration;

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

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void registerUser() throws InterruptedException {


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
		Thread.sleep(5000);
		//4. Click on 'Signup / Login' button
		driver.findElement(config.signup).click();
		//5. Verify 'New User Signup!' is visible

	}

	@AfterTest
	public void down() {
		driver.close();
		driver.quit();
	}


}