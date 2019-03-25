package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";
	

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) throws InterruptedException
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(chromeOption());
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			String fireFoxPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver(firefoxOption());
		}
		
		//headless browser test
		else if (browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir") + "/Drivers/phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			String internetExplorerPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", internetExplorerPath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);		
		driver.navigate().to("http://demo.nopcommerce.com/");
		
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	// Take screenshot when test case fail and add it in the Screenshots folder
	@AfterMethod
	public void screenShotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking screenshot...");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
