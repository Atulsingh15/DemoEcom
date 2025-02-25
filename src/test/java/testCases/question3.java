package testCases;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class question3 {

    public WebDriver driver;
    public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Test
    public void testcase() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Navigate to Time -> Attendance -> Employee Records
        driver.findElement(By.xpath("//a[span[contains(normalize-space(), 'Time')]]")).click();
        driver.findElement(By.xpath("//li[span[contains(normalize-space(), 'Attendance')]]")).click();
        driver.findElement(By.xpath("//a[contains(normalize-space(), 'Employee Records')]")).click();

        // Select Date
        WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']"));
        dateInput.clear();
        dateInput.sendKeys("2023-07-04"); // Corrected date format

        // Click on View Button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();

        // Wait for the Employee List to Load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> employeeList = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"))
        );

        // Scroll to Employee Table
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement employeeTable = driver.findElement(By.xpath("//div[contains(@class, 'oxd-table')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", employeeTable);
        Thread.sleep(500);

        // Print Employee Records
        if (employeeList.isEmpty()) {
            System.out.println("No employee found.");
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(employeeList.get(i).getText());
            }
        }

        // Close the browser
        driver.quit();
    }
}
