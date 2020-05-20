package automationpractice.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TshirtPage {

	WebDriver driver;

	By Quickview = By.xpath(".//*[@class='quick-view']");

	By Image = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");

	public TshirtPage(WebDriver driver) {
		this.driver = driver;
	}

	public void QuickviewImg() throws InterruptedException {

		String Parentwindow = driver.getWindowHandle();

		WebElement Quickviewlink = driver.findElement(Quickview);
		WebElement Imagelink = driver.findElement(Image);

		Actions a = new Actions(driver);
		a.moveToElement(Imagelink).build().perform();

		Thread.sleep(2000);

		Quickviewlink.click();

		Set<String> ChildWindow = driver.getWindowHandles();

		for (String Handle : ChildWindow) {
			if (!Parentwindow.equals(ChildWindow)) {
				driver.switchTo().window(Handle);
			}
		}

	}

}
