package gateways.authorization;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import service.interfaces.IAuthService;

import gateways.Gateway;

public class AuthorizationGateway extends Gateway{

	private IAuthService server;
	public AuthorizationGateway(String name) throws Exception{
		super();
		server= lookup(name);
	}

	public IAuthService lookup(String name) throws RemoteException, MalformedURLException, NotBoundException {		
		return (IAuthService) Naming.lookup(name);
	}
	public boolean doesUserExist(String user){
		try {
			return server.doesUserExist(user);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkPass(String userName, String pass) {
		try {
			return server.checkPass(userName, pass);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean signIn(String user, String pass){
		try {
			return server.signIn(user, pass);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean createUser(String name, String pass){
		try {
			return server.createUser(name, pass);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}
