package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	By Signin = By.cssSelector(".login");

	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void HomepageSigninClick() {

		driver.findElement(Signin).click();

	}

	
}
