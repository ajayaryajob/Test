package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {

WebDriver driver;
	
	
	public WebDriver Intitializebrowser() throws IOException {
		
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Ajay Arya\\Documents\\JavaClass\\AutomationPracticeProject\\src\\utility\\Object.Properties");
		
		prop.load(fis);
		
		String Browsername=prop.getProperty("Browser");
		String URL=prop.getProperty("siteURL");
		if(Browsername.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajay Arya\\Documents\\JavaClass\\SeleniumTestProject\\drivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
		}
			
			else if(Browsername.equals("Firefox"))	{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ajay Arya\\Documents\\JavaClass\\SeleniumTestProject\\drivers\\geckodriver.exe");
				
				driver= new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(URL);
			
			return driver;
		}
	
}
