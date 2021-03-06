package commonLibs.contracts;

public interface IDriver {

	public void navigateToFirstUrl(String Url) throws Exception;
	
	public String getTitle() throws Exception;
	
	public String getCurrentUrl() throws Exception;
	
	public String getPageSource() throws Exception;
	
	public void navigateToUrl(String Url) throws Exception;
	
	public void navigateForward() throws Exception;
	
	public void navigateBackward() throws Exception;
	
	public void refresh() throws Exception;
	
	public void closeBrowser() throws Exception;
	
	public void closeAllBrowsers() throws Exception;
}
