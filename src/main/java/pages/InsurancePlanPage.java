package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class InsurancePlanPage extends TestBase {

	public InsurancePlanPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * Sorting price from low to high
	 */
	public void sortPrice() {
		Select sort = new Select(driver
				.findElement(By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[4]/ul/li[5]/div/select")));
		sort.selectByVisibleText("Price: Low to High");
	}

	/*
	 * Getting insurance details
	 */
	public void insuranceDetails() {
		Select sort = new Select(driver
				.findElement(By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[4]/ul/li[5]/div/select")));
		sort.selectByVisibleText("Price: Low to High");
		for (int i = 8; i < 11; i++) {
			List<WebElement> total = driver.findElements(
					By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[" + i + "]/div/div/div[1]/div[1]/p"));
			if (total.size() > 1) {
				WebElement name = driver.findElement(By.xpath(
						"//*[@id=\"root\"]/main/div/div[2]/div/div[1]/div[" + i + "]/div/div/div[1]/div[1]/div"));
				String n = name.getAttribute("class").substring(5);
				System.out.print(n + "-");
				System.out
						.print("Rs." + driver
								.findElement(By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[" + i
										+ "]/div/div/div[2]/div[1]/div/div[1]/div[2]/div/button"))
								.getText().substring(2));
				WebElement morePlan=driver.findElement(By
						.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[" + i + "]/div/div/div[1]/div[1]/p"));
				
					morePlan.click();
				
				System.out.println();
				System.out.print(n + "-");
				System.out
						.print("Rs." + driver.findElement(By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div["
								+ i + "]/div/div/div[2]/div[2]/div/div[1]/div[2]/button")).getText().substring(2));
				System.out.println();
			} else {
				WebElement name = driver.findElement(By.xpath(
						"//*[@id=\"root\"]/main/div/div[2]/div/div[1]/div[" + i + "]/div/div/div[1]/div[1]/div"));
				String n = name.getAttribute("class").substring(5);
				System.out.print(n + "-");
				System.out
						.print("Rs." + driver
								.findElement(By.xpath("/html/body/section/main/div/div[2]/div/div[1]/div[" + i
										+ "]/div/div/div[2]/div[1]/div/div[1]/div[2]/div/button"))
								.getText().substring(2));
				System.out.println();
			}
		}
	}

}
