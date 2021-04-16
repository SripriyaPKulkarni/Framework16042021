package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface ICommonWebElements {

	public String getText(WebElement element) throws Exception;
	
	//public String getTitle(WebElement element) throws Exception;
	
	public void clickElement(WebElement element) throws Exception;
	
	public String getAttribute(WebElement element,String Attribute) throws Exception;
	
	public String getCssValue(WebElement element,String CssPropertyName) throws Exception;
	
	public Boolean isElementEnabled(WebElement element) throws Exception;
	
	public Boolean isElementVisible(WebElement element) throws Exception;
	
	public Boolean isElementSelected(WebElement element) throws Exception;
	
	public void setText(WebElement element,String TextToWrite) throws Exception;
	
	public void clearText(WebElement element) throws Exception;
	
	public void changeCheckboxStatus(WebElement element,boolean ExpectedStatus) throws Exception;
	
	public int getXLocation(WebElement element) throws Exception;
	
	public int getYLocation(WebElement element) throws Exception;
	
	
}
