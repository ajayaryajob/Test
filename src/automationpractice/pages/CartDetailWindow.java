package automationpractice.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartDetailWindow {

	WebDriver driver;

	By Checkout = By.xpath("//a[@title='Proceed to checkout']");

	public CartDetailWindow(WebDriver driver) {
		this.driver = driver;
	}

	public void CartDetails() {

		String ParentWindow = driver.getWindowHandle();

		System.out.println(ParentWindow);
		Set<String> ChildWindow = driver.getWindowHandles();

		for (String Handle : ChildWindow) {
			if (!ParentWindow.equals(ChildWindow)) {
				driver.switchTo().window(Handle);
				System.out.println(Handle);
			}
		}

	}

	public void CheckoutButtonClick() {

		driver.findElement(Checkout).click();

	}

}
