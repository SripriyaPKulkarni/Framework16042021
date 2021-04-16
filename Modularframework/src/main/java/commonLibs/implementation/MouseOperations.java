package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IMouseOperations;

public class MouseOperations implements IMouseOperations{

	private Actions action;
	
	public MouseOperations(WebDriver driver){
		Actions action=new Actions(driver);
	}
	
	public void dragAndSrop(WebElement source, WebElement target) throws Exception {
		action.dragAndDrop(source, target).build().perform();
		
	}

	public void moveToElement(WebElement element) throws Exception {
		action.moveToElement(element).build().perform();
		
	}

	public void rightClick(WebElement element) throws Exception {
		action.contextClick(element).build().perform();
		
	}

	public void doubleClick(WebElement element) throws Exception {
		action.doubleClick(element).build().perform();
		
	}

	public void moveToElementAndClick(WebElement element) throws Exception {
		action.moveToElement(element).click().build().perform();
		
	}

}
