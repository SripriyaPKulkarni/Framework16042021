package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {

	private WebDriver driver;
	private int pageload_timeout;
	private int element_Detectiontimeout;
	
	private String currentWorkingDirectory;
	
	
	//need it outside also
	public WebDriver getDriver() {
		return driver;
	}

	
	public void setPageload_timeout(int pageload_timeout) {
		this.pageload_timeout = pageload_timeout;
	}

	public void setElement_Detectiontimeout(int element_Detectiontimeout) {
		this.element_Detectiontimeout = element_Detectiontimeout;
	}

	//creating constructor to invoke browser
	public CommonDriver(String browserType) throws Exception{
		pageload_timeout=60;
		element_Detectiontimeout=10;
		
		currentWorkingDirectory=System.getProperty("user.dir");
		
		
		
		if(browserType.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory+"/drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		}else{
			throw new Exception("Invalid BrowserType");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void navigateToFirstUrl(String Url) throws Exception {
		
		driver.manage().timeouts().pageLoadTimeout(pageload_timeout, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(element_Detectiontimeout, TimeUnit.SECONDS);
		
		Url=Url.trim();
		
		driver.get(Url);
		
	}

	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		String title=driver.getTitle();
		return title;
	}

	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
	
		return driver.getCurrentUrl();
	}

	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	public void navigateToUrl(String Url) throws Exception {
		// TODO Auto-generated method stub
		Url=Url.trim();
		driver.navigate().to(Url);
	}

	public void navigateForward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().forward();
	}

	public void navigateBackward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}

	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}

	public void closeBrowser() throws Exception {
		// TODO Auto-generated method stub
		if(driver!=null){
			driver.close();
		}
		
	}

	public void closeAllBrowsers() throws Exception {
		// TODO Auto-generated method stub
		if(driver!=null){
			driver.quit();
		}
		
	}
}
