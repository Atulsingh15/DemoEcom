package testCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class question2 {

    public WebDriver driver;
@Test(enabled=false)
    public void tab() {
        // Test Case 1: Launch Chrome browser
        driver = new ChromeDriver();
        
        // Test Case 2: Go to test URL
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        
        // Test Case 3: Maximize browser window
        driver.manage().window().maximize();
        
        // Test Case 4: Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Test Case 5: Get the title of the page
        String exactTitle = driver.getTitle();
        System.out.println("Main Page Title: " + exactTitle);
        
        // Test Case 6: Click on "Know More" link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement readmore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(normalize-space(), 'Know More')]")));
    	//readmore.click();
        WebElement continueButton = driver.findElement(By.xpath("//a[contains(text(), 'CONTINUE')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

    	
      
        // Test Case 10: Close all browser windows
        driver.quit();
    }

   
}
