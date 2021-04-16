package in.co.mercurytravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.MouseOperations;
import in.co.mercurytravels.utils.WaitUtils;

public class HomePage extends BasePage{

	@FindBy(linkText="International Holidays")
	private WebElement internationalholidays;
	
	@FindBy(linkText=" Indian Holidays")
	private WebElement indianholidays;
	
	@FindBy(linkText="Luxury Rails")
	private WebElement luxuryrails;
	
	@FindBy(linkText="Luxury Holidays")
	private WebElement luxuryholidays;
	
	@FindBy(partialLinkText="Customer Log")
	private WebElement customer_login;
	
	@FindBy(linkText="User Login")
	private WebElement userlogin;
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(id="sign_user_email")
	private WebElement signinemail;
	
	@FindBy(id="sign_user_password")
	private WebElement signinpassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginbutton;
	
	@FindBy(partialLinkText="Welcome,")
	private WebElement welcomeText;
	

	
	
	
	public HomePage(WebDriver driver){
		
		super(driver);
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void user_login(String username,String password) throws Exception{
		
		mouseControl.moveToElement(customer_login);
		WaitUtils.waitForSeconds(5);
		
		mouseControl.moveToElementAndClick(userlogin);
		WaitUtils.waitForSeconds(3);
		
		elementControl.setText(signinemail, username);
		
		WaitUtils.waitForSeconds(3);
		
		elementControl.setText(signinpassword, password);
		WaitUtils.waitForSeconds(3);
		
		elementControl.clickElement(loginbutton);
		
		
		
	}
	
	public String getWelcomeTextMessage() throws Exception
	{
		return elementControl.getText(welcomeText);
	}
	
	public void verifyLuxuryRailspage() throws Exception
	{
		 elementControl.clickElement(luxuryrails);
		 
	}
	
	
}
