package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class PaymentPage {

	WebDriver driver;

	By BankPaymentLink = By.cssSelector(".bankwire");
	By OrderConfirm = By.cssSelector("button[class*='button-medium']");

	By UserNamelink = By.cssSelector("a[title='View my customer account']");

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void PaymentDetailsPage() {

		driver.findElement(BankPaymentLink).click();
		driver.findElement(OrderConfirm).click();
		driver.findElement(UserNamelink).click();

	}

}
