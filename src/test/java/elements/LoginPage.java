package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public String baseUrl="https://automationexercise.com/";
	public	By pageverify =By.linkText("Home");
    public By signup =By.xpath("//a[@href='/login']");
    
     
    public By signuppage =By.xpath("//h2[text()='Login to your account']");
    public By signname= By.xpath("//input[@data-qa='signup-name']");
    public By signamail=By.xpath("//input[@data-qa='signup-email']");
    
    public By signbutton=By.xpath("//button[@data-qa='signup-button']");
    
//    public void EnterName(String name) {
//		driver.findElement(signname);
//		
//	}
    
    

}
