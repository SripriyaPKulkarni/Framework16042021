package in.co.mercurytravels.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.CommonElements;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.MouseOperations;

public class BasePage {

protected AlertControl alertControl;
	
	protected CommonElements elementControl;
	
	protected DropdownControl dropdownControl;
	
	protected FrameControl frameControl;
	
	protected MouseOperations mouseControl;
	
	public BasePage(WebDriver driver){
		
		alertControl=new AlertControl(driver);
		
		elementControl=new CommonElements();
		
		mouseControl=new MouseOperations(driver);
		
		dropdownControl=new DropdownControl();
		
		frameControl=new FrameControl(driver);
		
		
	}
	
	
}
