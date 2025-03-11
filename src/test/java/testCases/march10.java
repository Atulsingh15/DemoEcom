package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class march10 {
	public WebDriver driver;
	
@Test
	public void parallel1 () {
	driver =  new ChromeDriver();
	driver.get("https://edunexttechnologies.com/school-erp.php");
    
	}
@Test
public void parallel2 () {
	driver =  new FirefoxDriver();
	driver.get("https://edunexttechnologies.com/school-erp.php");
    
	}

@AfterMethod

public void closed() {
    if (driver != null) {
        driver.quit();
    }
}



}
