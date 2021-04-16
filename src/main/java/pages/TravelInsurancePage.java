package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class TravelInsurancePage extends TestBase {

	public TravelInsurancePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	By student = By.xpath("//*[@id=\"topForm\"]/section/div[2]/article/ul/li[3]/a");
	By destination = By.id("destination-autocomplete");
	By studage1 = By.name("memage1");
	By studage2 = By.name("memage2");
	By startDate = By.name("startdate");
	By endDate = By.name("enddate");
	By prefix = By.id("travelgender");
	By travelName = By.id("travelname");
	By travelCountry = By.id("travelCountry");
	By travelMobile = By.id("travelmobile");
	By travelEmail = By.id("travelemail");

	/*
	 * Clicking student tab
	 */
	public boolean clickStudent() {
		driver.findElement(student).click();
		return true;
	}

	/*
	 * Entering student details in form
	 */
	public void fillDetails() {
		
   driver.findElement(destination).sendKeys(Keys.RETURN);
		driver.findElement(studage1).sendKeys("22");
		driver.findElement(studage2).sendKeys("21");
		driver.findElement(startDate).click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath("//*[@id=\"startdate\"]"));
		executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
		driver.findElement(By.id("startdate")).sendKeys("05-05-2021");
		driver.findElement(endDate).click();
		element = driver.findElement(By.className("date_to"));
		executor.executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
		driver.findElement(By.className("date_to")).sendKeys("12-05-2021");
		element = driver.findElement(By.xpath("/html/body/div[9]/div[4]/button"));
		executor.executeScript("arguments[0].click()", element);
		element = driver.findElement(By.xpath("//*[@id=\"proceedStepOne\"]"));
		executor.executeScript("arguments[0].click()", element);
	}

	/*
	 * Click get free quotes button
	 */
	public void getFreeQuotes() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,2000);
		
		// Wait till the element is not visible.
		WebElement element=wait. until(ExpectedConditions. visibilityOfElementLocated(By. xpath("//*[@id=\"travelname\"]")));
		Select select = new Select(driver.findElement(prefix));
		select.selectByVisibleText("Mr.");
		driver.findElement(travelName).clear();
		driver.findElement(travelName).sendKeys("susheel");
		Select selectCountry = new Select(driver.findElement(travelCountry));
		selectCountry.selectByVisibleText("INDIA (+91)");
		driver.findElement(travelMobile).sendKeys("9876543210");
		driver.findElement(travelEmail).clear();
		driver.findElement(travelEmail).sendKeys("susheelsharma@gmail.com");
		element = driver.findElement(By.xpath("//*[@id=\"topForm\"]/section/div[2]/div[2]/div[1]/div[2]/div/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
}
