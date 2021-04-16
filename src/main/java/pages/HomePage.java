package pages;

import org.openqa.selenium.By;

import base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	By insuranceProd = By.xpath("//a[text()=\"Insurance Products \"]");
	By travelInsurance = By.xpath("/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[4]/ul/li[1]/a/span");
	By carIcon = By.xpath("/html/body/cclink/main/div[2]/section/div[4]/a/div[1]/i");
	
	/*
	 * Click travel insurance
	 */
	public String clickTravelInsurance() {
		
		driver.findElement(insuranceProd).click();
		driver.findElement(travelInsurance).click();
		return driver.getTitle();
	}
	
	/*
	 * click car insurance
	 */
	public String clickCarInsurance()
	{
		driver.findElement(carIcon).click();
		return driver.getTitle();
	}
}
