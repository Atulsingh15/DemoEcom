package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import elements.LoginPage;
import elements.Scenerio2to5;

public class TestCases {
	public WebDriver driver;
	LoginPage config = new LoginPage();
	excel config4 = new excel();
	//LoginPage login;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(enabled = false)
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
		WebElement veraccount =driver.findElement(config.veraccounts);
		String actualver=veraccount.getText();
		String expectedver = "ADDRESS INFORMATION";
		Assert.assertEquals(actualver, expectedver, "The text on the page does not match the expected value.");

		//9. Fill details: Title, Name, Email, Password, Date of birth

		driver.findElement(config.radiobutton).click();
		driver.findElement(config.password).sendKeys("arjun");
		Thread.sleep(5000);
		WebElement days =driver.findElement(config.days);
		Select day1=new Select(days);
		day1.selectByValue("1");
		WebElement month =driver.findElement(config.month);
		Select month1=new Select(month);
		month1.selectByValue("1");
		WebElement year =driver.findElement(config.year);
		Select year1=new Select(year);
		year1.selectByValue("2021");
		Actions actions = new Actions(driver);
		driver.findElement(config.newsletter).click();
		driver.findElement(config.optin).click();

		actions.sendKeys(Keys.PAGE_DOWN).perform();
		driver.findElement(config.firstname).sendKeys("arjun");;
		driver.findElement(config.lastname).sendKeys("singh");
		driver.findElement(config.company).sendKeys("edunext");
		driver.findElement(config.address).sendKeys("noida");
		WebElement country =driver.findElement(config.country);
		Select country1=new Select(country);
		country1.selectByValue("India");
		driver.findElement(config.state).sendKeys("Up");
		driver.findElement(config.city).sendKeys("GBN");
		driver.findElement(config.zipcode).sendKeys("898989");
		driver.findElement(config.mobilenumber).sendKeys("1111111111");
		driver.findElement(config.createaccount).click();
		//14. Verify that 'ACCOUNT CREATED!' is visible;
		//WebElement verifyaccounts = driver.findElement(config.verifyaccount);

		//String expect="Account Created!";
		//String actu= verifyaccounts.getText();

		//Assert.assertEquals(actu, expect, "The text on the page does not match the expected value.");

		//15. Click 'Continue' button
		driver.findElement(config.continu).click();

		//16. Verify that 'Logged in as username' is visible

		//17. Click 'Delete Account' button
		driver.findElement(config.delete).click();
		//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

	}

	@AfterClass
	public void down() {
		driver.close();
		driver.quit();
	}


}

class scenerio2to5 {
	Scenerio2to5 config1 = new Scenerio2to5();
	public WebDriver driver;


	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(enabled = false)
	public void testscenerio2() throws InterruptedException, IOException {
		Properties prop =new Properties();
		FileInputStream fiss = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/resources.properties");

		//FileInputStream fiss = new FileInputStream("C:\\Users\\dell\\Desktop\\selenium\\DemoEcom\\src\\test\\resources\\resources.properties");
		prop.load(fiss);
		String password = prop.getProperty("password");
		String lmail = prop.getProperty("lmail");
		String username =prop.getProperty("username");

		driver.get(config1.baseUrl);
		Thread.sleep(5000);
		WebElement verify1=	driver.findElement(config1.indexverify);
		String actual ="Home";
		String expected =verify1.getText();
		Assert.assertEquals(actual, expected, "The text on the page does not match the expected value.");
		driver.findElement(config1.loginpage).click();
		WebElement verify2 =driver.findElement(config1.loginver);
		String act="Login to your account";
		String expe =verify2.getText();
		Assert.assertEquals(act, expe,"The text on the page does not match the expected value.");
		// Enter correct email address and password
		driver.findElement(config1.email).sendKeys(lmail);
		driver.findElement(config1.password).sendKeys(password);
		driver.findElement(config1.submit).click();
		WebElement verify3 =driver.findElement(config1.userverify);
		String act1 =verify3.getText();
		String exp1 = "Logged in as " + username;
		Assert.assertEquals(act1, exp1,"The text on the page does not match the expected value.");
		//we can not delete currently




	}
	@Test(enabled=false)
	public void scenerio3() throws FileNotFoundException, IOException, InterruptedException {
		driver.get(config1.baseUrl);
		Thread.sleep(5000);
		WebElement verify1=	driver.findElement(config1.indexverify);
		String actual ="Home";
		String expected =verify1.getText();
		Assert.assertEquals(actual, expected, "The text on the page does not match the expected value.");
		driver.findElement(config1.loginpage).click();
		WebElement verify2 =driver.findElement(config1.loginver);
		String act="Login to your account";
		String expe =verify2.getText();
		Assert.assertEquals(act, expe,"The text on the page does not match the expected value.");
		// Enter correct email address and password
		driver.findElement(config1.email).sendKeys("arjun@g.com");
		driver.findElement(config1.password).sendKeys("pass");
		driver.findElement(config1.submit).click();
		 
	}



	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}