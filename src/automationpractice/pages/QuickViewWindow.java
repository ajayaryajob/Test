package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewWindow {

	WebDriver driver;

	By AddToCart = By.xpath("//button[@name='Submit']");
	By AddQty = By.xpath("//i[@class='icon-plus']");

	public QuickViewWindow(WebDriver driver) {
		this.driver = driver;
	}

	public void QuickViewWindowDetails() {

		driver.switchTo().frame(0);

		driver.findElement(AddQty).click();
		driver.findElement(AddToCart).click();
	}
}
