package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindowHandle;

public class WindowControl implements IWindowHandle{

	private WebDriver driver;
	
	public WindowControl(WebDriver driver){
		this.driver=driver;
	}
	
	public void switchToAnyWindow(String windowHandle) throws Exception {
		
		driver.switchTo().window(windowHandle);
	}

	public void switchToAnyWindow(int childWindowIndex) throws Exception {
		String childWindowHandle=driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childWindowHandle);
		
	}

	public String getWindowhandle() throws Exception {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() throws Exception {
		return driver.getWindowHandles();
	}

}
