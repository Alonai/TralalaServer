package remote;

import java.rmi.Remote;

public interface IManagementSessionFacade extends Remote{
	
	public boolean signIn(String user, String pass);

}
