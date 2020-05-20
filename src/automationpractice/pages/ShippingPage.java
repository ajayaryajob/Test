package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

	WebDriver driver;

	By TermsandCondition = By.xpath("//input[@type='checkbox']");

	By ProceedToCheckout = By.xpath("//button[@name='processCarrier']");

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ShippingDetails() {

		driver.findElement(TermsandCondition).click();
		driver.findElement(ProceedToCheckout).click();
	}
}
