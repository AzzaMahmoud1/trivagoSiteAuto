package tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DiscoverDashboardPage;

public class DiscoverDashboardTest extends TestBase {
	DiscoverDashboardPage discoverObject;
	public String city="alexandria";
	public int miles=100;
	public int nights=5;
	boolean viewdealonDiscover=true;
	boolean viewdealafterImg= true;
	@Test
	public void Search() throws InterruptedException {
		discoverObject=new DiscoverDashboardPage(driver);
		//TC01 , test that the page opened 
		driver.get("https://discover.trivago.co.uk/");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/"));
		Assert.assertEquals(discoverObject.trivagoPage.getText(), "Discover it here.");

		//test the CST viewDeal without clicking on it's info
		if(viewdealonDiscover==true) {
			//discoverObject.dealsviewCheck.click();
			discoverObject.viewDeals("berlin", "4", nights,miles,viewdealafterImg);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Assert.assertNotEquals(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"), "failed to be redirected to the site now");
		}
		else {
			System.out.println("go to see more stays");
			discoverObject.gotoSeeMoreStaysDiscoverTest("Paris", "4", nights,miles);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"));
		}
	}
}
