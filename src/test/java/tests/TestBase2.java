package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperities;

import java.util.Properties;


import utilities.Helper;

public class TestBase2 {

	// Sauce Labs Configuration
	public static final String USERNAME = LoadProperities.sauceLabsData.getProperty("username");
	public static final String ACCESS_KEY = LoadProperities.sauceLabsData.getProperty("accesskey");
	public static final String sauceURL = "http://" + USERNAME + ":" + ACCESS_KEY + LoadProperities.sauceLabsData.getProperty("accesskey");

	
	
	public static String baseURL = "http://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> driver = null;


	@BeforeClass
	@Parameters(value = { "browser" })
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException  {
		driver = new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps = new DesiredCapabilities();
//		String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", chromePath);
		caps.setCapability("browserName", browser);
		
		
		// Selenium Grid Local
		//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		// Run on saucelabs on cloud
		driver.set(new RemoteWebDriver(new URL(sauceURL), caps));
		
		getDriver().navigate().to(baseURL);
		getDriver().manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterClass
	public void stopDriver()
	{
		getDriver().quit();
		driver.remove();
	}
	
	// Take screenshot when test case fail and add it in the Screenshots folder
		@AfterMethod
		public void screenShotOnFailure(ITestResult result)
		{
			if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("Failed!");
				System.out.println("Taking screenshot...");
				Helper.captureScreenshot(getDriver(), result.getName());
			}
		}
}
