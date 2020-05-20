package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {

	WebDriver driver;

	By ProceedtoCheckout = By.xpath("//a[contains(@class,'standard-checkout')]");

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement SummaryPageDetails() {

		WebElement ProceedtoCheckoutbutton = driver.findElement(ProceedtoCheckout);
		return ProceedtoCheckoutbutton;

	}

}
