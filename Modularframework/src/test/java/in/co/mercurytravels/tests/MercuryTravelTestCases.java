package in.co.mercurytravels.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestCases extends BaseTest{

	
	@Test
	public void verifyUserLoginwithCorrectCredentials() throws Exception{
		
		extentTest=extent.createTest("TC-001");
		
		String username=configProperties.getProperty("useremailid");
		
	
		
		String password=configProperties.getProperty("userpassword");
		homePage.user_login(username, password);
		
		String expectedText=configProperties.getProperty("expectedWelcomeText");
		
		String actualText=homePage.getWelcomeTextMessage();
		
	    AssertJUnit.assertEquals(actualText, expectedText);
	    
	    extentTest.log(Status.INFO, "User login success");
	}
	@Test
	public void verifyLuxuryRailslink() throws Exception {
		
		extentTest=extent.createTest("TC-002");
		homePage.verifyLuxuryRailspage();
		
		String expectedText="Luxury Rail Holiday Packages Holidays - Book Luxury Rail Holiday Packages Tour Packages Online | Mercury Travels | Budget & Luxury Holidays";
		
		String actualText=driver.getTitle();
		
		Assert.assertEquals(expectedText, actualText);
		
		extentTest.log(Status.INFO, "TC-002 success");
	}
}
