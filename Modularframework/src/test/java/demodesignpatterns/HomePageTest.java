package demodesignpatterns;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import designPatterns.AmazonHomePage;

public class HomePageTest {

	CommonDriver cmnDriver;
	
	AmazonHomePage amazonhomepage;
	
	WebDriver driver;

	
	String url="https://www.amazon.in/";
	
	@BeforeClass
	public void invokeBrowser() throws Exception{
		cmnDriver=new CommonDriver("chrome");
		
		cmnDriver.setPageload_timeout(60);
		
		cmnDriver.setElement_Detectiontimeout(10);
		
		cmnDriver.navigateToFirstUrl(url);
		
		driver=cmnDriver.getDriver();
		
		amazonhomepage=new AmazonHomePage(driver);
	}
	
	@Test
	public void searchproduct() throws Exception{
		String product="Iphone";
		String category="Electronics";
		
		amazonhomepage.searchProduct(product, category);
	}
	
	@AfterClass
	public void closeBrowser() throws Exception{
		cmnDriver.closeAllBrowsers();
	}
}
