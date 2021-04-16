package commonLibs.implementation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlerts;
import in.co.mercurytravels.utils.WaitUtils;

public class AlertControl implements IAlerts{

	private WebDriver driver;
	
	public AlertControl(WebDriver driver){
		this.driver=driver;
	}
	
	private Alert getAlert(){
		return driver.switchTo().alert();
	}
	public void acceptAlert() throws Exception {
		getAlert().accept();
		
	}

	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	public String getMessagefromAlert() throws Exception {
		return getAlert().getText();
	}

	public boolean checkAlertPresent(int timeOutInseconds) throws Exception {
		
		try{
			WaitUtils.waitTillAlertisPresent(driver, timeOutInseconds);
			
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
