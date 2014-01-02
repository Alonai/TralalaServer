package remote;

import java.rmi.server.UnicastRemoteObject;

public class ManagementSessionFacade extends UnicastRemoteObject implements IManagementSessionFacade{
	private MemberManagement manager;
	
	public ManagementSessionFacade(MemberManagement memberM) {
		manager = memberM;
	}
	
	public boolean signIn(String user, String pass) {
		return manager.signIn(user, pass);
	}
}
