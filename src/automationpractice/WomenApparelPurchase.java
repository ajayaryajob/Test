package automationpractice;

import java.io.File;

import org.junit.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationpractice.pages.AddressPage;
import automationpractice.pages.AuthenticationPage;
import automationpractice.pages.CartDetailWindow;

import automationpractice.pages.HomePage;
import automationpractice.pages.LandingPage;
import automationpractice.pages.MyAccountPage;
import automationpractice.pages.PaymentPage;
import automationpractice.pages.QuickViewWindow;
import automationpractice.pages.ShippingPage;
import automationpractice.pages.SummaryPage;
import automationpractice.pages.TshirtPage;

import utility.Baseclass;

public class WomenApparelPurchase extends Baseclass {

	WebDriver driver;

	@Test
	public void Women_Tshirt_Purchase() throws IOException, InterruptedException {

		File src = new File(
				"C:\\Users\\Ajay Arya\\Documents\\JavaClass\\AutomationPracticeProject\\src\\automationpractice\\DataSheet.xlsx");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet UserDetails = wb.getSheetAt(0);
		String RegisteredEmailValue = UserDetails.getRow(4).getCell(1).getStringCellValue();
		String RegisteredPassValue = UserDetails.getRow(4).getCell(2).getStringCellValue();

		driver = Intitializebrowser();

		LandingPage lp = new LandingPage(driver);
		lp.HomepageSigninClick();

		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.RegisteredEmailAddress().sendKeys(RegisteredEmailValue);
		ap.Password().sendKeys(RegisteredPassValue);
		ap.SigninButtonElement().click();

		HomePage hp = new HomePage(driver);
		hp.WomenTab();

		TshirtPage tp = new TshirtPage(driver);
		tp.QuickviewImg();

		QuickViewWindow qw = new QuickViewWindow(driver);
		qw.QuickViewWindowDetails();

		CartDetailWindow cd = new CartDetailWindow(driver);
		cd.CartDetails();
		cd.CheckoutButtonClick();

		SummaryPage sp = new SummaryPage(driver);

		WebElement SummaryTotal = driver
				.findElement(By.xpath("(//table[@id='cart_summary']/tfoot/tr)[last()]/td[last()]"));
		String SummaryTotalValue = SummaryTotal.getText();
		System.out.println("summary amount  total" + SummaryTotal.getText());
		sp.SummaryPageDetails().click();

		AddressPage ad = new AddressPage(driver);
		ad.AddressPageDetails();

		ShippingPage sh = new ShippingPage(driver);
		sh.ShippingDetails();

		PaymentPage pg = new PaymentPage(driver);
		WebElement PaymentTotal = driver
				.findElement(By.xpath("(//table[@id='cart_summary']/tfoot/tr)[last()]/td[last()]"));
		String PaymentTotalValue = PaymentTotal.getText();
		System.out.println("Payment Page total amount" + PaymentTotalValue);

		// Verify Total Price Amount in Payment Page

		SoftAssert s = new SoftAssert();

		s.assertTrue(PaymentTotalValue.equals(SummaryTotalValue));
		System.out.println();
		pg.PaymentDetailsPage();

		MyAccountPage ac = new MyAccountPage(driver);
		ac.OrderHistory().click();

		// Verify Total Price Amount in Profile Page

		WebElement tableFirstrow = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[1]"));

		List<WebElement> Table_column = tableFirstrow.findElements(By.tagName("td"));
		int Column_count = Table_column.size();

		for (int column = 0; column < Column_count; column++) {
			String ProfilePageAmount = Table_column.get(column).getText();
			if (ProfilePageAmount.equals(SummaryTotalValue)) {
				System.out.println("Amount in order history page is correct" + ProfilePageAmount);
				break;
			}
		}

		s.assertAll();

	}

	@AfterTest

	public void CloseBrowser() {

		driver.close();
	}

}
