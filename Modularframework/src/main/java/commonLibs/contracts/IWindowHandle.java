package commonLibs.contracts;

import java.util.Set;

public interface IWindowHandle {

	public void switchToAnyWindow(String windowHandle) throws Exception;
	
	public void switchToAnyWindow(int childWindowIndex) throws Exception;
	
	public String getWindowhandle() throws Exception;
	
	public Set<String> getWindowHandles() throws Exception;
	
}
