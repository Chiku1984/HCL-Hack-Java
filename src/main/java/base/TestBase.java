package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import util.ExtentReportManager;



public class TestBase {
	static Properties prop;
	public static WebDriver driver;
	public static WebElement element;
	private static final Logger logBase = LogManager
			.getLogger(base.TestBase.class);


     public ExtentReports report= ExtentReportManager.getReportInstance();
   public ExtentTest logger;

   //constructor
	public TestBase()throws Exception {
		try {
			String userDir=System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					userDir + "\\src\\main\\java\\config\\config.properties");
			
			//loading properties file
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	/*
	 * To Invoke Browser
	 */
	public static void initialization()throws Exception
	{
		try{String userDir=System.getProperty("user.dir");
		String browserName = prop.getProperty("browser");
		//opening browser
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir + "\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
			else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", userDir + "\\Drivers\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(new FirefoxProfile());
				options.addPreference("dom.webnotifications.enabled",false);
				driver=new FirefoxDriver(options);
			}
			else if(browserName.equals("internet explorer")) {
				System.setProperty("webdriver.ie.driver", userDir + "\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * to erase any previous data on the report and create a new report.
	 */
	@AfterMethod(groups= {"Regression","Default"})
	public void flushReports()throws Exception {
	report.flush();
	}
}
