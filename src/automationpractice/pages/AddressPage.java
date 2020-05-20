package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {

	
	WebDriver driver;
	
	By Proceed= By.xpath("//button[@name='processAddress']");
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void AddressPageDetails() {
		
		driver.findElement(Proceed).click();
		
	}
	
}
