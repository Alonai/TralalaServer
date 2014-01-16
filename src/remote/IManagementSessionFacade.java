package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManagementSessionFacade extends Remote{
	
	public boolean signIn(String user, String pass) throws RemoteException;

}
