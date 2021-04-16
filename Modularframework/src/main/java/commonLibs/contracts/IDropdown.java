package commonLibs.contracts;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IDropdown {

	public void selectByVisibleText(WebElement element, String visibleText) throws Exception;
	
	public void selectByValue(WebElement element, String value) throws Exception;
	
	public void selectByValue(WebElement element,int index) throws Exception;
	
	public List<WebElement> getAllOptions(WebElement element);
}
