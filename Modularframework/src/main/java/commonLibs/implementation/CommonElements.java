package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonWebElements;

public class CommonElements implements ICommonWebElements{

	public String getText(WebElement element) throws Exception {
		return element.getText();
	}

	public void clickElement(WebElement element) throws Exception {
		 element.click();
		
	}

	public String getAttribute(WebElement element, String Attribute) throws Exception {
		return element.getAttribute(Attribute)
;	}

	public String getCssValue(WebElement element, String CssPropertyName) throws Exception {
		return element.getCssValue(CssPropertyName);
	}

	public Boolean isElementEnabled(WebElement element) throws Exception {
	
		return element.isEnabled();
	}

	public Boolean isElementVisible(WebElement element) throws Exception {
		
		return element.isDisplayed();
	}

	public Boolean isElementSelected(WebElement element) throws Exception {
		return element.isSelected();
	}

	public void setText(WebElement element, String TextToWrite) throws Exception {
		element.sendKeys(TextToWrite);
		
	}

	public void clearText(WebElement element) throws Exception {
		element.clear();
	}

	public void changeCheckboxStatus(WebElement element, boolean ExpectedStatus) throws Exception {
		Boolean currentStatus=element.isSelected();
		
		if(currentStatus!=ExpectedStatus){
			element.click();
		}
		
	}

	public int getXLocation(WebElement element) throws Exception {
		
		return element.getLocation().x;
	}

	public int getYLocation(WebElement element) throws Exception {
		return element.getLocation().y;
	}

	
	
	

	
}
