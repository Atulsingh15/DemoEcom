package testCases;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class windowhandle {
    
    WebDriver driver;

    @Test
    public void handle() {
        driver = new ChromeDriver();
        driver.get("https://edunexttechnologies.com");
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);
        System.out.println("Main Window Title: " + driver.getTitle());  // Get main window title
    }

    @Test
    public void handles() {
        driver = new ChromeDriver();
        driver.get("https://edunexttechnologies.com"); // Open main website

        // Open a new tab with JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://google.com');"); // Opening Google in new tab
        js.executeScript("window.open('https://yahoo.com');");  // Opening Yahoo in another tab

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Total Windows Opened: " + windowHandles.size());

        // Iterate through each window handle and print titles
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            System.out.println("Switched to Window: " + driver.getTitle());
        }
    }

    @AfterMethod
    public void down() {
        if (driver != null) {
            driver.quit();  // Close all browser windows
        }
    }
}
