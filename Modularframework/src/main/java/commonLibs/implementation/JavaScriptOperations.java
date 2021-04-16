package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScriptOperations;

public class JavaScriptOperations implements IJavaScriptOperations {

	private JavascriptExecutor jsEngine;
	
	public JavaScriptOperations(WebDriver driver){
		//typecasting
		jsEngine=(JavascriptExecutor)driver;
	}
	
	public void executeJavaScript(String scriptToExecute) throws Exception {
		jsEngine.executeScript(scriptToExecute);
		
	}

	public void scrollDown(int x, int y) {
		String jsCommand=String.format("window.scrollBy(%d,%d)",x,y);
		
		jsEngine.executeScript(jsCommand);
		
	}

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return jsEngine.executeScript(scriptToExecute).toString();
		
	}

	
}
