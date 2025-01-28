package elements;

import org.openqa.selenium.By;

public class Scenerio2to5 {


		public String baseUrl="https://automationexercise.com/";
		public By indexverify=By.linkText("Home");
		public By loginpage =By.xpath("//a[@href='/login']");
		public By loginver =By.xpath("//h2[text()='Login to your account']");
		public By email =By.xpath("//input[@name='email']");
		public By password =By.xpath("//input[@name='password']");
		public By submit =By.xpath("//button[@type='submit']");
		public By delete=By.xpath("//a[text()=' Delete Account']");
		public By userverify=By.xpath("//*[text()=' Logged in as ']");

	

}
