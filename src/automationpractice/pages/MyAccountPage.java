package automationpractice.pages;

import org.openqa.selenium.By;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;

	By OrderHistory = By.cssSelector("a[title='Orders']");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement OrderHistory() {

		WebElement OrderHistoryButton = driver.findElement(OrderHistory);
		return OrderHistoryButton;

	}

}
