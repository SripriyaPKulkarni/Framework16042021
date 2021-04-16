package commonLibs.contracts;

public interface IAlerts {

	public void acceptAlert() throws Exception;
	
	public void rejectAlert() throws Exception;
	
	public String getMessagefromAlert() throws Exception;
	
	public boolean checkAlertPresent(int timeOutInseconds) throws Exception;
}
