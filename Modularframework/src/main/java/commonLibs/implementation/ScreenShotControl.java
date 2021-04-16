package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenShotControl implements IScreenshot{

	private TakesScreenshot camera;
	
	public ScreenShotControl(WebDriver driver){
		TakesScreenshot camera=(TakesScreenshot)driver;
	}
	
	public void captureAndSaveScreenShot(String pathFile) throws Exception {
		
		pathFile=pathFile.trim();
		
		File imgFile,tmpFile;
		
		imgFile=new File(pathFile);
		
		if(imgFile.exists()){
			throw new Exception("Image File with this name altready exists");
			
		}
		
		tmpFile=camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile,imgFile);
		
		
		
	}

	

}
