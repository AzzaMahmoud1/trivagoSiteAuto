package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(className = "siteheader__control")
	WebElement loginBTN;

	@FindBy(id = "check_email")
	WebElement loginEmailTxtElement;



	@FindBy(css ="#unified-sign-in > section > div > div > h1" )
	WebElement validateUserexist;
	
	
	@FindBy(className = "box__headline js_headLine")
	WebElement createaccValid;
	
	@FindBy(id="login_password" )
	WebElement loginPasswd;
	
	
	@FindBy(id="login_email_submit" )
	WebElement loginemailSBT;

	@FindBy(id="login_submit")
	WebElement loginlBtn;

	@FindBy(id="login_signup_link")
	WebElement loginEmailBtn;

	@FindBy(id = "login_signup_link")
	WebElement createAccBTn;

	@FindBy(id = "register_email")
	WebElement createEmailTxtelement;

	@FindBy(id = "register_password")
	WebElement paswdTxt;


	@FindBy(id ="register_email_submit")
	WebElement registerSbmtBtn;

	public void OpenCreateUserPage(String email, String Passwrod) {

		clickButton(loginBTN);
		clickButton(createAccBTn);
		Assert.assertEquals(validateUserexist.getText(), "Create your account");
		setTextElementText(createEmailTxtelement, email);
		setTextElementText(paswdTxt, Passwrod);
		clickButton(registerSbmtBtn);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"));

	}
	public void CustomeraActivationloginCheck(String email, String Pswd) {
		clickButton(loginBTN);
//		System.out.println(driver.getCurrentUrl());
//		Assert.assertTrue(driver.getCurrentUrl().contains("https://access.trivago.com/oauth/en-GB/login"));
		setTextElementText(loginEmailTxtElement, email);
		clickButton(loginemailSBT);
		if(validateUserexist.getText().equalsIgnoreCase("Welcome back!")) {
		Assert.assertEquals(validateUserexist.getText(), "Welcome back!");
		System.out.println("cst already has account");
		if(validateUserexist.getText().equalsIgnoreCase("Welcome back!")) {
			System.out.println("email valid and user will login");
			setTextElementText(loginPasswd, Pswd);
			clickButton(loginlBtn);
			Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"));
		}
		else 
			OpenCreateUserPage(email,Pswd);
		
	}
	else {
		System.out.println("automated login,,, forbidden");
	}
}}
