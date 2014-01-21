package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManagementSessionFacade extends Remote{
	
	public boolean signIn(String user, String pass) throws RemoteException;
	public boolean registerUser(String nick, String pass) throws RemoteException;

}
