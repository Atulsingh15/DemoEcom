package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class question1 {
	
	public WebDriver driver;
//	
//	1) Perform the following test cases.
//	TestCase 1- Open Chrome browser and go to https://www.ebay.com/
//	TestCase 2- Hover your mouse to the “Electronics” element from the nav bar
//	TestCase 3- Click on “Apple” under Electronics Element
//	TestCase 4- scroll down the page until you see All listings
//	TestCase4- Fetch all the mobile phones listed in the product listing page(All Listings) along with their prices and Print them on the console screen
//done
	@Test(enabled=false)
	public void question1() throws InterruptedException {
        driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.xpath("//a[text()='Electronics']"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		

	WebElement electronics = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Electronics']")));
	electronics.click();
	
	driver.findElement(By.xpath("//a[text()='Apple']")).click();
	
   
    List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//H3[@class='textual-display bsig__title__text']")));
    List<WebElement> prices = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='textual-display bsig__price bsig__price--displayprice']")));

	JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement allListings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //a[contains(text(),'Site Map')]")));
    js.executeScript("arguments[0].scrollIntoView(true);", allListings);
    Thread.sleep(500); // Allow content to load

	
	

    System.out.println("Number of products found: " + products.size());
    System.out.println("Number of prices found: " + prices.size());
    if (products.isEmpty() || prices.isEmpty()) {
        System.out.println("No products or prices found. Check XPath or page load issues.");
    } else {
        for (int i = 0; i < Math.min(products.size(), prices.size()); i++) {
            System.out.println(products.get(i).getText() + " - " + prices.get(i).getText());
        }
    }

      
      
	  
		
		
		driver.close();
		
	}

}
