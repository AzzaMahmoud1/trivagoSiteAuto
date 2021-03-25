package pages;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscoverDashboardPage extends PageBase {
	
	public DiscoverDashboardPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(className = "Hero_subline__2ikLV")
	public WebElement trivagoPage;


	@FindBy(className = "DestinationControl_input__23k7O")
	WebElement searchInputElement;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[2]/div/ul/li[1]/button/span[1]")
	WebElement firstElement;


	@FindBy(xpath   = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/ul/li[3]/button")
	WebElement spanElement;



	@FindBy(className = "StayControl_label__1CxEt")
	WebElement stayElement;


	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/button/span/span")
	WebElement daysINCElement;


	@FindBy(className = "StaySelect_apply__1bMzT")
	WebElement stayApplyBtnElement;

	@FindBy(xpath = "//*[@data-qa='button-inspiration-distance']")
	WebElement milesBTN;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/ul/li[1]/button")
	WebElement milesDistance100;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/ul/li[2]/button")
	WebElement milesDistance150;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/ul/li[3]/button")
	WebElement milesDistance200;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div/div[2]/div/ul/li[1]/button/span[2]")
	WebElement country;


	@FindBy(className = "Hero_subline__2ikLV")
	public WebElement pageLandedCheck;

	@FindBy(className = "Header_country__2m6hu")
	List<WebElement> countiresList;

	@FindBy(linkText  = "See more stays")
	WebElement DirectLinkElement;

	@FindBy(css = "#overlay-portal > div > div > div > div > button")
	WebElement closeOpenedImage;
	//click on first elment
	@FindBy(css = "#__next > main > div.Inspiration_container__11ZhC > div:nth-child(3) > div:nth-child(1) > div.fresnel-container.fresnel-greaterThanOrEqual-md > div > div > section > ul > li:nth-child(1) > article > a")
	public	WebElement dealsviewCheck;


	@FindBy(className = "DealTilesDesktop_tile__2kdmF")
	WebElement dealsview;

	//	@FindBy(className = "tile-button-clickout")
	//	WebElement clickViewDealMainPage;

	@FindBy(css = "#__next > main > div.Inspiration_container__11ZhC > div:nth-child(3) > div:nth-child(1) > div.fresnel-container.fresnel-greaterThanOrEqual-md > div > div > section > ul > li:nth-child(1) > article > div.Tile_footer__3vXXE > footer > div.Footer_deal__11xGU > div.Footer_button__6d5Ut > button")
	WebElement clickViewDealMainPage;


	@FindBy(css = "#__next > main > div.Inspiration_container__11ZhC > div:nth-child(3) > div:nth-child(1) > div.fresnel-container.fresnel-greaterThanOrEqual-md > div > div > section > ul > li:nth-child(2) > article > div.Tile_footer__3vXXE > footer > div.Footer_deal__11xGU > div.Footer_button__6d5Ut")
	WebElement clickSecondDealMainPage;


	@FindBy(xpath = "//*[@data-qa='gallery-clickout']")
	WebElement clickViewDealByLink;

	public void searchDetails(String srchInput, String days,int noOfNights, int Miles) throws InterruptedException {

		try {

			Thread.sleep(3000);
			setTextElementText(searchInputElement, srchInput);
			//	waitElement(firstElement, driver);
			//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			clickButton(firstElement);
		


			if(Miles==100){
				clickButton(milesDistance100);
			}
			else if (Miles==150) {
				clickButton(milesDistance150);
			}
			else {
				clickButton(milesDistance200);
			}

			clickButton(stayElement);
			Thread.sleep(2000);
			for(int i= 0; i<noOfNights-2;i++) {
				clickButton(daysINCElement);
			}
			clickButton(stayApplyBtnElement);
		}catch (ElementClickInterceptedException e) {
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("cookies handling");
		
			clickButton(stayApplyBtnElement);
		}




	}
	public void gotoSeeMoreStays() throws InterruptedException{
		clickButton(DirectLinkElement);

	}
	public void gotoSeeMoreStaysDiscoverTest(String srchInput1, String days1, int noOfNights1, int Miles1 ) throws InterruptedException{

		searchDetails(srchInput1,days1,noOfNights1,Miles1);

		clickButton(DirectLinkElement);

	}



	public void viewDeals(String srchInput1, String days1, int noOfNights1, int Miles1, boolean imgclicked ) throws InterruptedException {
		//	searchDetails(srchInput1,days1,noOfNights1,Miles1);
		System.out.println("we will check on the image clicked status ");
		searchDetails(srchInput1,days1,noOfNights1,Miles1);
		boolean image_clicked= cstviewdealsInfo(imgclicked);
		System.out.println("image clicked status is  "+image_clicked);
		if(image_clicked==false) {

			clickButton(clickViewDealMainPage);
		}
		else {

			clickButton(clickViewDealByLink);
		}
	}
	public boolean cstviewdealsInfo(boolean imgclicked) {

		boolean action_status= false;
		if(imgclicked==true) {

			System.out.println("img will be clikecd now");

			clickButton(dealsviewCheck);
			action_status=true;
		}

		return action_status;
	}

	public void ViewWithoutImg() {
		clickButton(closeOpenedImage);
		clickButton(clickSecondDealMainPage);
	}

}
