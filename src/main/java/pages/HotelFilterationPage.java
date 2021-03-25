package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelFilterationPage extends PageBase {

	public HotelFilterationPage(WebDriver driver) {
		super(driver);
	}



	@FindBy(id = "querytext")
	WebElement hotelSearchTxt;

	@FindBy(xpath = "//*[@data-title='Hotel']")
	WebElement hotelBox;

	@FindBy(xpath = "//*[@title='All']")
	WebElement RatingList;	

	@FindBy(css = "#page_wrapper > section > div > div > ul > li.toolbar-list__item.toolbar-list__item--rating.js-toolbar__item--rating.js-toolbar-rating > div > div > section > div > div > div.refinement-row__content > ul > li:nth-child(2)")
	WebElement RatingValue;


	@FindBy(xpath = "//*[@title='Select']")
	WebElement moreFiltersList;

	@FindBy(css = "#i3")
	WebElement weekendRadioBTN;

	@FindBy(css  = ".df_overlay_close_wrap")
	WebElement closeCalender;

	@FindBy(name = "sQuery")
	WebElement searchInput;


	@FindBy(className = "btn btn--primary btn--regular search-button js-search-button")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@title='5-star hotels']")
	WebElement fiveStarsHotel;

	@FindBy(id="filter-popover-done-button")
	WebElement DoneBtn;

	@FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/div[4]/div[2]/div/table[1]")
	WebElement fstMonthDate;

	@FindBy(css = "#\\31 5732888 > div > article > div.pos-relative.item__wrapper > div.item__image-area > div.bookmarks__itemCompare--06783.has-tooltip > button")
	WebElement addtoFav;


	@FindBy(xpath = "//*[@data-qa='shortlist-button']")
	WebElement shortListBTN;

	@FindBy(css = "body > div.js-shortlisting > div > div > div > div > ul > li > button.bookmarks__itemDetails--05180")
	WebElement ViewElment;

	@FindBy(css = "#\\31 5732888 > div > article > div.pos-relative.item__wrapper > div.item__flex-column > section > div.accommodation-list__rowLast--340b8.accommodation-list__row--10531 > article > div > div.accommodation-list__dealInfo--e4f9a.accommodation-list__offset--bbc99 > button")
	public WebElement ViewDealBTN;

	@FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/div[2]/button[3]/span/span[2]/time")
	WebElement Time;



	@FindBy(xpath = "//*[@data-qa='itemlist-element']")
	List<WebElement> HotelListResults;



	@FindBy(xpath = "//*[@data-qa='item-name']")
	List<WebElement> HotelListNamesResults;

	@FindBy(className = "rating-number")
	List<WebElement> Ratings;


	@FindBy(className = "bui-review-score__text")
	List<WebElement> reviewScore;

	@FindBy(xpath = "/div/article/div[1]/div[1]/div[1]/button")
	List<WebElement> test;


	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/button")
	WebElement closePopUp;



	public void SearchDetails 	() throws InterruptedException {
	
		clickButton(weekendRadioBTN);
		Thread.sleep(2000);
		clickButton(closeCalender);
	
	}
	public void filterHotels() throws InterruptedException {
		clickButton(fiveStarsHotel);
		clickButton(DoneBtn);
		Thread.sleep(2000);
		clickButton(RatingList);
		clickButton(RatingValue);

		clickButton(addtoFav);
		Thread.sleep(3000);
		clickButton(shortListBTN);
		clickButton(ViewElment);
		Thread.sleep(3000);

		clickButton(ViewDealBTN);
	}}

