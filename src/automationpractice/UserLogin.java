package automationpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import automationpractice.pages.AuthenticationPage;
import automationpractice.pages.LandingPage;
import utility.Baseclass;

public class UserLogin extends Baseclass {

	WebDriver driver;

	@Test
	public void LogintoApplication() throws IOException, InterruptedException {

		File src = new File(
				"C:\\Users\\Ajay Arya\\Documents\\JavaClass\\AutomationPracticeProject\\src\\automationpractice\\DataSheet.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet UserDetails = wb.getSheetAt(0);
		String RegisteredEmailValue = UserDetails.getRow(4).getCell(1).getStringCellValue();
		String RegisteredPassValue = UserDetails.getRow(4).getCell(2).getStringCellValue();

		driver = Intitializebrowser();

		LandingPage hp = new LandingPage(driver);

		hp.HomepageSigninClick();

		AuthenticationPage ap = new AuthenticationPage(driver);

		ap.RegisteredEmailAddress().sendKeys(RegisteredEmailValue);
		ap.Password().sendKeys(RegisteredPassValue);

		ap.SigninButtonElement().click();

	}

	@AfterTest

	public void CloseBrowser() {

		driver.close();
	}

}
