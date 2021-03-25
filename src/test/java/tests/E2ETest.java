package tests;

import java.util.ArrayList;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import pages.DiscoverDashboardPage;
import pages.HotelFilterationPage;
import pages.LoginPage;

public class E2ETest extends TestBase{

	DiscoverDashboardPage discoverObject;
	LoginPage loginObject;
	HotelFilterationPage HotelFilterationObject;
	public int miles=100;
	public String city="berlin";
	public int nights=5;
	boolean viewdealonDiscover=true;
	boolean viewdealafterImg= true;

	final String emailAddresss = enterEmailAddress() ;

	public final String enterEmailAddress() {
		FakeValuesService fakeValuesService = new FakeValuesService(
				new Locale("en-GB"), new RandomService());
		String emailAddress = fakeValuesService.bothify("????##@gmail.com");
		System.out.println(emailAddress);
		return emailAddress;}

	//TC01 checck page landed 
	@Test(priority = 1, alwaysRun = true)
	public void Search() throws InterruptedException {
		driver.get("https://discover.trivago.co.uk/");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/"));
		discoverObject=new DiscoverDashboardPage(driver);
		//System.out.println(discoverObject.pageLandedCheck.getText());
		Assert.assertEquals(discoverObject.pageLandedCheck.getText(), "Discover it here.");

	}

	//TC02/TC03 test the CST login or register successfully

	/*-----------this test is commented because login for automated tests are forbidden-------------*/

	/*@Test(dependsOnMethods = "Search")
	public void createNewUserSuccessfully() {

	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    System.out.println(driver.getCurrentUrl());
	  //  driver.close();
	    //driver.switchTo().window(tabs2.get(0));
		//TC02 Cst Create user successfully 
		loginObject.CustomeraActivationloginCheck(emailAddresss,"User12345678#");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"));
		//TC03 Cst login succesfully
		loginObject.CustomeraActivationloginCheck(emailAddresss,"User12345678#");
	}*/


	@Test(dependsOnMethods = "Search")
	public void selectHotelFromDiscover() throws InterruptedException{
		System.out.println("select the first deal from discover");
		viewdealonDiscover=true;
		viewdealafterImg= true;
		discoverObject.viewDeals("berlin", "4", nights,miles,viewdealafterImg);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/forward"));
		Assert.assertNotEquals(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"), "failed to be redirected to the site now");
		driver.close();
		Thread.sleep(2000);

		driver.switchTo().window(tabs2.get(0));
		discoverObject.ViewWithoutImg();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/forward"));
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}
	@Test(dependsOnMethods = "selectHotelFromDiscover")
	public void hotelFilteration() throws InterruptedException{

		discoverObject=new DiscoverDashboardPage(driver);
		HotelFilterationObject = new HotelFilterationPage(driver);
		discoverObject.gotoSeeMoreStays();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		HotelFilterationObject.SearchDetails();
		HotelFilterationObject.filterHotels();

		Assert.assertNotEquals(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"), "failed to be redirected to the site now");

	}

}
