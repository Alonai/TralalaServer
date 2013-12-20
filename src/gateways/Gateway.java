package gateways;

import java.rmi.RMISecurityManager;
import java.rmi.Remote;

public abstract class Gateway{

	public Gateway(){
		if(System.getSecurityManager()==null)
			System.setSecurityManager(new RMISecurityManager());
	}

	public abstract Remote lookup(String name) throws Exception;
}
