package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;

public class AmazonHomePageFactory {

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css="#searchDropdownBox")
	private WebElement searchCategory;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchButton;
	
	private CommonElements elementControl;
	
	private DropdownControl dropdownControl;
	
	
	//creating constructor of the class to assign locators
	public AmazonHomePageFactory(WebDriver driver){
		
		PageFactory.initElements(driver, this);
        
        elementControl=new CommonElements();
        
        
        dropdownControl=new DropdownControl();
        
        
	}
	
	public void searchProduct(String product, String category) throws Exception{
		
		elementControl.setText(searchBox, product);
		
		dropdownControl.selectByVisibleText(searchCategory, category);
		
		elementControl.clickElement(searchButton);
		
		
		
	}
}
