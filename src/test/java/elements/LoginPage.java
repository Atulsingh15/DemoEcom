package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;
	public String baseUrl="https://automationexercise.com/";
	public	By pageverify =By.linkText("Home");
	public By signup =By.xpath("//a[@href='/login']");
	public By veraccounts =By.xpath("//b[text()='Address Information']");
	public By signuppage =By.xpath("//h2[text()='Login to your account']");
	public By signname= By.xpath("//input[@data-qa='signup-name']");
	public By signamail=By.xpath("//input[@data-qa='signup-email']");
	public By signbutton=By.xpath("//button[@data-qa='signup-button']");
	public By radiobutton=By.id("id_gender1");
	public By password=By.xpath("//input[@id='password']");
	public By days =By.id("days");
	public By month =By.id("months");
	public By year =By.id("years");
	public By firstname =By.id("first_name");
	public By lastname =By.id("last_name");
	public By company =By.id("company");
	public By address = By.id("address1");
	public By country =By.id("country");
	public By state =By.id("state");
	public By city =By.id("city");
	public By zipcode=By.id("zipcode");
	public By mobilenumber=By.id("mobile_number");
	public By newsletter=By.id("newsletter");
	public By optin =By.id("optin");
	public By createaccount=By.xpath("//button[normalize-space()='Create Account']");
	public By verifyaccount=By.linkText("//b[text()='Account Created!']");
	public By continu=By.xpath("//a[normalize-space()='Continue']");
	public By delete=By.xpath("//a[text()=' Delete Account']");
	

	//    public void EnterName(String name) {
	//		driver.findElement(signname);
	//		
	//	}



}
