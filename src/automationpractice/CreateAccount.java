package automationpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationpractice.pages.AuthenticationPage;
import automationpractice.pages.CreateAccountPage;

import automationpractice.pages.LandingPage;

import utility.Baseclass;

public class CreateAccount extends Baseclass {
	public WebDriver driver;
	public WebDriverWait wait;
	
	

	@Test
	public void CreateNewAccount() throws IOException, InterruptedException {

		File src = new File(
				"C:\\Users\\Ajay Arya\\Documents\\JavaClass\\AutomationPracticeProject\\src\\automationpractice\\DataSheet.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet UserDetails = wb.getSheetAt(0);
		String EmailAdrress_Create = UserDetails.getRow(1).getCell(1).getStringCellValue();
		String FirstNameValue = UserDetails.getRow(1).getCell(2).getStringCellValue();
		String LastNameValue = UserDetails.getRow(1).getCell(3).getStringCellValue();

		DataFormatter formatter = new DataFormatter();
		XSSFCell Password = UserDetails.getRow(1).getCell(4);
		String PasswordValue = formatter.formatCellValue(Password);

		XSSFCell Date = UserDetails.getRow(1).getCell(5);
		String DateValue = formatter.formatCellValue(Date);

		String MonthValue = UserDetails.getRow(1).getCell(6).getStringCellValue();

		XSSFCell Year = UserDetails.getRow(1).getCell(7);
		String YearValue = formatter.formatCellValue(Date);

		String AddressFNameValue = UserDetails.getRow(1).getCell(8).getStringCellValue();
		String AddressLNameValue = UserDetails.getRow(1).getCell(9).getStringCellValue();
		String CompanyValue = UserDetails.getRow(1).getCell(10).getStringCellValue();

		String AddressValue = UserDetails.getRow(1).getCell(11).getStringCellValue();
		String AddressLine2Value = UserDetails.getRow(1).getCell(12).getStringCellValue();
		String CityValue = UserDetails.getRow(1).getCell(13).getStringCellValue();
		String StateValue = UserDetails.getRow(1).getCell(14).getStringCellValue();

		XSSFCell Postcode = UserDetails.getRow(1).getCell(15);
		String PostCodeValue = formatter.formatCellValue(Postcode);

		String AdditionalInfoValue = UserDetails.getRow(1).getCell(17).getStringCellValue();

		XSSFCell HomeNumber = UserDetails.getRow(1).getCell(18);
		String HomeNumberValue = formatter.formatCellValue(HomeNumber);

		XSSFCell mobNumber = UserDetails.getRow(1).getCell(19);
		String MobileNumber = formatter.formatCellValue(mobNumber);

		String AddressAlaisValue = UserDetails.getRow(1).getCell(20).getStringCellValue();
		
		//Browser Initialization...

		driver = Intitializebrowser();

		LandingPage hp = new LandingPage(driver);

		hp.HomepageSigninClick();

		AuthenticationPage lp = new AuthenticationPage(driver);

		lp.EmailAddress().sendKeys(EmailAdrress_Create);
		lp.CreateAccountButtonclick().click();

		CreateAccountPage cp = new CreateAccountPage(driver);
		cp.TitleSelect().click();

		cp.FnameTextBox().click();
		cp.FnameTextBox().sendKeys(FirstNameValue);

		cp.LnameTextBox().click();
		cp.LnameTextBox().sendKeys(LastNameValue);
		cp.PasswordTextBox().sendKeys(PasswordValue);

		cp.DateSelectDropdown().click();
		cp.DateSelectDropdown().sendKeys(DateValue);

		cp.MonthSelectDropdown().click();
		cp.MonthSelectDropdown().sendKeys(MonthValue);

		Thread.sleep(3000);
		WebElement YearSelect = driver.findElement(By.cssSelector("#years"));

		List<WebElement> Years = YearSelect.findElements(By.tagName("option"));

		for (WebElement SelectedYear : Years) {

			if (SelectedYear.getText().contains(YearValue)) {

				SelectedYear.click();
				break;
			}
		}

		// cp.YearSelectDropdown().sendKeys(Keys.DOWN);

		// cp.AddressFirstNameTextBox().sendKeys(AddressFNameValue);

		// cp.AddressLastNameTextBox().sendKeys(AddressLNameValue);

		cp.CompanyTextBox().click();
		cp.CompanyTextBox().sendKeys(CompanyValue);

		cp.AddressTextBox().click();
		cp.AddressTextBox().sendKeys(AddressValue);

		cp.AddressLine2TextBox().click();
		cp.AddressLine2TextBox().sendKeys(AddressLine2Value);

		cp.CitytextBox().click();
		cp.CitytextBox().sendKeys(CityValue);

		Select StateVal = new Select(cp.StateDropdown());
		StateVal.selectByVisibleText(StateValue);
		
		cp.PostCodeTextBox().click();
		cp.PostCodeTextBox().sendKeys(PostCodeValue);

		cp.AdditionalInfoTextBox().click();
		cp.AdditionalInfoTextBox().sendKeys(AdditionalInfoValue);

		cp.HomeNumberTextBox().click();
		cp.HomeNumberTextBox().sendKeys(HomeNumberValue);

		cp.MobileNumberTextBox().click();
		cp.MobileNumberTextBox().sendKeys(MobileNumber);

		cp.AddressAliasTextbox().clear();

		cp.AddressAliasTextbox().sendKeys(AddressAlaisValue);

		cp.RegisterButtonClick().click();

	}

	@AfterTest

	public void CloseBrowser() {

		driver.close();
	}

}
