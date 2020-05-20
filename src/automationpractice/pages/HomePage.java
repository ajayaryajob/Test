package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	WebDriver driver;
	
	By WomenTab = By.cssSelector("a[title='Women']");
	By Tshirtlink=By.xpath("//div[@id='block_top_menu']/ul/li/ul/li/ul/li/a[contains(text(),'T-shirts')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void WomenTab() {
		
		
		WebElement Women=driver.findElement(WomenTab);
		WebElement Tshirt= driver.findElement(Tshirtlink);
		
		Actions a= new Actions(driver);
		a.moveToElement(Women).moveToElement(Tshirt).click().build().perform();
	}

}
