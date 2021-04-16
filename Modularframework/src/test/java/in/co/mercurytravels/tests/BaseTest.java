package in.co.mercurytravels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.CommonElements;
import commonLibs.implementation.ScreenShotControl;
import commonLibs.utilities.DateUtils;
import in.co.mercurytravels.pages.HomePage;
import in.co.mercurytravels.utils.ConfigFileUtils;

public class BaseTest {

	CommonDriver cmnDriver;
	String browserType;
	
	  WebDriver driver;
	 
	 CommonElements elementControl;
	
	
	HomePage homePage;
	
	static String configFileName;
	
	static Properties configProperties;
	
	static String currentWorkingDirectory;
	
	int pageloadTimeout;
	int elementDetectionTimeOut;
	
	String url;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	ExtentTest extentTest;
	
	String reportFileName;
	
	static String executionStartDate;
	
	String screenshotfilename;
	ScreenShotControl screenshotControl;
	
	static{
		
		try{
		currentWorkingDirectory=System.getProperty("user.dir");
		configFileName=String.format("%s/config/config.properties", currentWorkingDirectory);
		//configFileName=currentWorkingDirectory+"/config/config.properties";
		
		//date and time
		executionStartDate=DateUtils.getCurrentDateAndTime();
		
		
			configProperties=ConfigFileUtils.readProperties(configFileName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//code for extent reports
	@BeforeSuite
	public void preconfig(){
		
		reportFileName=String.format("%s/reports/MercuryTravelsTestReports-%s.html", currentWorkingDirectory,executionStartDate);
		
		htmlReporter=new ExtentHtmlReporter(reportFileName);
		
		//initializing extent reports
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeTest
	public void setUp() throws Exception{
		
		extentTest=extent.createTest("Setup pre requisite");
		
		
		
		browserType=configProperties.getProperty("browserType");
		
		extentTest.log(Status.INFO, "Browser invoked is"+browserType);
		
		
		cmnDriver=new CommonDriver(browserType);
		
		pageloadTimeout=Integer.parseInt(configProperties.getProperty("pageLoadTimeOut"));
		cmnDriver.setPageload_timeout(pageloadTimeout);
		
		extentTest.log(Status.INFO, "PageLoad Time out is"+pageloadTimeout);
		
		elementDetectionTimeOut=Integer.parseInt(configProperties.getProperty("elementDetectionTimeOut"));
		
		cmnDriver.setElement_Detectiontimeout(elementDetectionTimeOut);
		
		extentTest.log(Status.INFO, "element Detection TimeOut is"+elementDetectionTimeOut);
		
		url=configProperties.getProperty("url");
        cmnDriver.navigateToFirstUrl(url);
		
		driver=cmnDriver.getDriver();
		
		homePage=new HomePage(driver);
		
		screenshotControl=new ScreenShotControl(driver);
		
		
	}
	
	@AfterTest
	public void cleanUp() throws Exception{
		extentTest=extent.createTest("Cleanup");
		extentTest.log(Status.INFO, "Cleanup activities");
		cmnDriver.closeAllBrowsers();
	}
	
	@AfterSuite
	public void postCleanUp(){
		extent.flush();
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		String testCaseName=result.getName();
		
		String screenshotfilename=String.format("%s/screenshots/%s-%s.jpeg",currentWorkingDirectory,testCaseName,executionStartDate);
		
		if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.PASS, "Test Case Pass"+testCaseName);
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			
			extentTest.log(Status.FAIL, "Test Case Fail"+testCaseName);
			
			screenshotControl.captureAndSaveScreenShot(screenshotfilename);
			
			extentTest.addScreenCaptureFromPath(screenshotfilename);
			
		}else{
			extentTest.log(Status.SKIP, "Test Case skipped"+testCaseName);
		}
	}
	
}
