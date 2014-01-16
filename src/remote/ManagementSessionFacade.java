package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import management.MemberManagement;

public class ManagementSessionFacade extends UnicastRemoteObject implements IManagementSessionFacade{
	private MemberManagement manager;
	
	public ManagementSessionFacade(MemberManagement memberM) throws RemoteException{
		super();
		manager = memberM;
	}
	
	public boolean signIn(String user, String pass) throws RemoteException{
		return manager.signIn(user, pass);
	}
}
