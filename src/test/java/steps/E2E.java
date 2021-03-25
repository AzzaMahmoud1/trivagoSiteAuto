package steps;

import java.util.ArrayList;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DiscoverDashboardPage;
import pages.HotelFilterationPage;
import pages.LoginPage;
import tests.TestBase;

public class E2E extends TestBase {
	//public WebDriver driver=getDriver();
	DiscoverDashboardPage discoverObject;
	LoginPage loginObject;
	HotelFilterationPage HotelFilterationObject;
	public int miles=100;
	public String city="berlin";
	public int nights=5;
	boolean viewdealonDiscover=true;
	boolean viewdealafterImg= true;
	
@Given("^The User on Discover Page$")
public void the_User_on_Discover_Page() {
	driver.get("https://discover.trivago.co.uk/");
	Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/"));
	discoverObject=new DiscoverDashboardPage(driver);
	Assert.assertEquals(discoverObject.pageLandedCheck.getText(), "Discover it here.");
}

@When("^I Search with the Data$")
public void i_Search_with_the_Data() throws InterruptedException  {
	System.out.println("select the first deal from discover");
	viewdealonDiscover=true;
	viewdealafterImg= true;
	discoverObject.viewDeals("berlin", "4", nights,miles,viewdealafterImg);
}

@When("^I View hotels From Discover page through images and close it$")
public void i_View_hotels_From_Discover_page_through_images_and_close_it() throws InterruptedException  {
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));
	Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/forward"));
	Assert.assertNotEquals(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"), "failed to be redirected to the site now");
	driver.close();
	Thread.sleep(2000);
	driver.switchTo().window(tabs2.get(0));
}

@When("^I view Hotels from discover page through view Deal withough expanding the View$")
public void i_view_Hotels_from_discover_page_through_view_Deal_withough_expanding_the_View()  {
	
	discoverObject.ViewWithoutImg();
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	Assert.assertTrue(driver.getCurrentUrl().contains("https://discover.trivago.co.uk/forward"));
	driver.close();
	driver.switchTo().window(tabs.get(0));
}

@When("^I view the hotels through see more stays then filter the search results$")
public void i_view_the_hotels_through_see_more_stays_then_filter_the_search_results() throws InterruptedException {
	discoverObject=new DiscoverDashboardPage(driver);
	HotelFilterationObject = new HotelFilterationPage(driver);
	discoverObject.gotoSeeMoreStays();
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));
	HotelFilterationObject.SearchDetails();
}

@Then("^website is redirected to the corresponding page$")
public void website_is_redirected_to_the_corresponding_page() throws InterruptedException {
	HotelFilterationObject.filterHotels();

	Assert.assertNotEquals(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"), "failed to be redirected to the site now");

}

}
