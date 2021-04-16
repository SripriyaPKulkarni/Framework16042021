package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;

public class AmazonHomePage {

	private WebElement searchBox;
	
	private WebElement searchCategory;
	
	private WebElement searchButton;
	
	private CommonElements elementControl;
	
	private DropdownControl dropdownControl;
	
	
	//creating constructor of the class to assign locators
	public AmazonHomePage(WebDriver driver){
		
		searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		
        searchCategory=driver.findElement(By.cssSelector("#searchDropdownBox"));
        
        searchButton=driver.findElement(By.id("nav-search-submit-button"));
        
        elementControl=new CommonElements();
        
        
        dropdownControl=new DropdownControl();
        
        
	}
	
	public void searchProduct(String product, String category) throws Exception{
		
		elementControl.setText(searchBox, product);
		
		dropdownControl.selectByVisibleText(searchCategory, category);
		
		elementControl.clickElement(searchButton);
		
		
		
	}
}
