package automationpractice.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {

	WebDriver driver;

	By CreateAccEmailAddress = By.xpath(".//input[@id='email_create']");

	By CreateAccountButton = By.xpath("//button[@id=\"SubmitCreate\"]/span");
	
	By RegEmailAdress = By.xpath("//input[@id='email']");

	By Password = By.cssSelector("#passwd");
	
	By Signin = By.cssSelector("#SubmitLogin");

	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement EmailAddress() {
		WebElement Email = driver.findElement(CreateAccEmailAddress);
		return Email;

	}

	public WebElement CreateAccountButtonclick() {

		WebElement CreateButton = driver.findElement(CreateAccountButton);
		return CreateButton;
	}
	public WebElement RegisteredEmailAddress() {

		WebElement RegEmailAddress = driver.findElement(RegEmailAdress);
		return RegEmailAddress;
	}

	public WebElement Password() {

		WebElement Pass = driver.findElement(Password);
		return Pass;

	}
	
	public WebElement SigninButtonElement() {

		WebElement SigninButton = driver.findElement(Signin);
		return SigninButton;

	}
}
