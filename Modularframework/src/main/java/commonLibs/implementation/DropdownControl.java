package commonLibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropdownControl implements IDropdown{

	private Select getSelect(WebElement element){
		Select select=new Select(element);
		
		return select;
	}
	
	public void selectByVisibleText(WebElement element, String visibleText) throws Exception {
		
		
		getSelect(element).selectByVisibleText(visibleText);
		
	}

	public void selectByValue(WebElement element, String value) throws Exception {
		getSelect(element).selectByValue(value);
		
	}

	public void selectByValue(WebElement element, int index) throws Exception {
		getSelect(element).selectByIndex(index);
		
	}

	public List<WebElement> getAllOptions(WebElement element) {
		return getSelect(element).getOptions();
	}

}
