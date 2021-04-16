
package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import base.TestBase;
import pages.HomePage;
import pages.InsurancePlanPage;
import pages.TravelInsurancePage;
import util.TravelInsuranceExcel;

public class TravelInsuranceDetailsTest extends TestBase {

	HomePage homePage;
	TravelInsurancePage travelInsurance = new TravelInsurancePage();
	InsurancePlanPage insurancePlan = new InsurancePlanPage();
	By destination = By.id("destination-autocomplete");

	public TravelInsuranceDetailsTest() throws Exception {
		super();
	}

	@BeforeSuite(groups= {"Default","Regression"})
	public void setup() throws Exception {
		initialization();
		
		homePage = new HomePage();
	}

	@DataProvider
	public Object[] dp() throws IOException {

		Object[] obj;

		obj = TravelInsuranceExcel
				.readData(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testdata\\PolicybazzarData.xlsx");
		return obj;
	}

	@Test(priority = 1,groups= {"Default","Smoke","Regression"})
	public void homePageTitle() throws Exception
	{
		String title = homePage.clickTravelInsurance();
		Assert.assertEquals(title, "Travel Insurance: Compare & Buy Travel Insurance Online");
	}

	@Test(dataProvider = "dp", priority = 2,groups= {"Default","Regression"})
	public void checkExcelData(String country) throws Exception {
		clickStudent();
		fillDetail(country);
		getFreeQuotes();
		sortPrice();
		getinsuranceProviderName();
		driver.navigate().to("https://www.policybazaar.com/travel-insurance/");
	}
		public void clickStudent() throws Exception {
		travelInsurance.clickStudent();
		logger = report.createTest("Travel Insurance Test");
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking student tab");
	}
	
	public void fillDetail(String country) throws InterruptedException {
		driver.findElement(destination).sendKeys(country);
		System.out.println(country);
		travelInsurance.fillDetails();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Filling Details");
	}
	
	public void getFreeQuotes() throws InterruptedException
	{
		travelInsurance.getFreeQuotes();
		logger.log(Status.PASS, "TestCase passed");
	}
	
	public void sortPrice(){
		insurancePlan.sortPrice();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking on sort price dropdown");
	}
	
	public void getinsuranceProviderName(){
		insurancePlan.insuranceDetails();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking on sort price dropdown");
	}

}
