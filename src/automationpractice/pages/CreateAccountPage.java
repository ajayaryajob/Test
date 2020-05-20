package automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	
	WebDriver driver;
	
	By Title= By.cssSelector("#id_gender1");
	By FName= By.cssSelector("#customer_firstname");
	By LName = By.cssSelector("#customer_lastname");
	By Password= By.cssSelector("#passwd");
	By Date= By.cssSelector("#days");
	By Month = By.cssSelector("#months");
	By Year = By.cssSelector("#years");
	By AddressFname= By.xpath("//input[@type='text' and @id='firstname']");
	By AddressLname = By.xpath("//input[@type='text' and @id='lastname']");
	By Company = By.cssSelector("#company");
	By Address= By.xpath("//input[@type='text' and @id='address1']");
	By AddressLine2= By.xpath("//input[@type='text' and @id='address2']");
	By City= By.xpath("//input[@type='text' and @id='city']");
	By State= By.xpath("//select[@id='id_state']");
	By Postcode= By.xpath("//input[@type='text' and @id='postcode']");
	By Country= By.cssSelector("#id_country");
	By AdditionalInfo= By.cssSelector("#other");
	By HomeNumber = By.cssSelector("#phone");
	By MobileNumber= By.cssSelector("#phone_mobile");
	By AddressAlias= By.cssSelector("#alias");
	By RegisterButton= By.cssSelector("#submitAccount");
	
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement TitleSelect() {

		WebElement TitleRadioButtonSelect = driver.findElement(Title);
		return TitleRadioButtonSelect;
	}
	
	public WebElement FnameTextBox() {

		WebElement FirstNameTextBox = driver.findElement(FName);
		return FirstNameTextBox;
	}
	
	public WebElement LnameTextBox() {

		WebElement LastNameTextBox = driver.findElement(LName);
		return LastNameTextBox;
	}
	
	public WebElement PasswordTextBox() {

		WebElement PassTextBox = driver.findElement(Password);
		return PassTextBox;
	}
	
	public WebElement DateSelectDropdown() {

		WebElement DateSelect = driver.findElement(Date);
		return DateSelect;
	}
	
	public WebElement MonthSelectDropdown() {

		WebElement MonthSelect = driver.findElement(Month);
		return MonthSelect;
	}
	
	
	public WebElement AddressFirstNameTextBox() {

		WebElement AddressFirstName = driver.findElement(AddressFname);
		return AddressFirstName;
	}
	public WebElement AddressLastNameTextBox() {

		WebElement AddressLastName = driver.findElement(AddressLname);
		return AddressLastName;
	}
	
	public WebElement CompanyTextBox() {

		WebElement CompanyTextBoxInput = driver.findElement(Company);
		return CompanyTextBoxInput;
	}
	public WebElement AddressTextBox() {

		WebElement AddressInput = driver.findElement(Address);
		return AddressInput;
		
		
	}public WebElement AddressLine2TextBox() {

		WebElement Addressline2Input = driver.findElement(AddressLine2);
		return Addressline2Input;
	}
	public WebElement CitytextBox() {

		WebElement CityInput = driver.findElement(City);
		return CityInput;
	}
	public WebElement StateDropdown() {

		WebElement StateInput = driver.findElement(State);
		return StateInput;
	}
	public WebElement PostCodeTextBox() {

		WebElement PostCodeInput = driver.findElement(Postcode);
		return PostCodeInput;
	}
	
	public WebElement CountryDropdown() {

		WebElement CountrySelect = driver.findElement(Country);
		return CountrySelect;
	}
	
	public WebElement AdditionalInfoTextBox() {

		WebElement AdditionalInfoInput = driver.findElement(AdditionalInfo);
		return AdditionalInfoInput;
	}
	public WebElement HomeNumberTextBox() {

		WebElement HomeNumberInput = driver.findElement(HomeNumber);
		return HomeNumberInput;
	}
	
	
	public WebElement MobileNumberTextBox() {

		WebElement MobileNumberInput = driver.findElement(MobileNumber);
		return MobileNumberInput;
	}
	
	public WebElement AddressAliasTextbox() {

		WebElement AddressAliasinput = driver.findElement(AddressAlias);
		return AddressAliasinput;
	}
	
	public WebElement RegisterButtonClick() {

		WebElement RegisterButtonaction = driver.findElement(RegisterButton);
		return RegisterButtonaction;
	}
}
