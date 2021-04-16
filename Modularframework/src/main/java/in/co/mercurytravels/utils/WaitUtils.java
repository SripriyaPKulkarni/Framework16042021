package in.co.mercurytravels.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitForSeconds(int timeOutInSeconds) throws InterruptedException{
		Thread.sleep(timeOutInSeconds*1000);
	}
	public static void waitTillAlertisPresent(WebDriver driver,int timeOutInSeconds) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public static void waitTillElementVisible(WebDriver driver,WebElement element,int timeOutInSeconds) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitTillElementClickable(WebDriver driver,WebElement element,int timeOutInSeconds) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitTillElementSelectable(WebDriver driver,WebElement element,int timeOutInSeconds) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

}
