package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public static void startDriver(@Optional("chrome") String browwserName) {

		if (browwserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			//ChromeOptions options = new ChromeOptions();
			//options.setBinary("/drivers/chromedriver.exe");
			//	 driver = new ChromeDriver(options);
		}
		else if(browwserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}

		else if(browwserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IDDriverServer.exe");
			driver= new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//driver.get("https://discover.trivago.co.uk/");
		
	}
	public WebDriver getDriver() {
		return driver;
	}
	@AfterSuite
	public void afterSuite() {
		if(null != driver) {
			driver.close();
			driver.quit();
		}
	}

	
	//take screenshot when test case fail and add it to screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("taking screensot");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}