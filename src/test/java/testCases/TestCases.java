package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void registerUser() {
		driver.get(config.baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		

	}
	
@AfterTest
public void down() {
	driver.close();
	driver.quit();
}


}