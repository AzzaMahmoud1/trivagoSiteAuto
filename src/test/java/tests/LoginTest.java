package tests;

import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import pages.LoginPage;

public class LoginTest extends TestBase{
final String emailAddresss = enterEmailAddress() ;
	LoginPage loginObject;
	public final String enterEmailAddress() {
		FakeValuesService fakeValuesService = new FakeValuesService(
				new Locale("en-GB"), new RandomService());
		String emailAddress = fakeValuesService.bothify("????##@gmail.com");
		System.out.println(emailAddress);
	return emailAddress;}
	
	// test the CST login or register successfully but not tested on production because the automated test for login is forbidden
	@Test(priority = 1, alwaysRun = true)
	public void createNewUserSuccessfully() {
		driver.get("https://www.trivago.co.uk/");
		loginObject = new LoginPage(driver);
		//TC02 Cst login 
		loginObject.CustomeraActivationloginCheck(emailAddresss,"User12345678#");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trivago.co.uk/?cpt2"));
		//TC03 Cst create account
		loginObject.OpenCreateUserPage(emailAddresss,"User12345678#");
	}
	}

