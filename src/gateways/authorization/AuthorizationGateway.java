package gateways.authorization;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import service.interfaces.IAuthService;
import service.interfaces.sign.ISignInService;
import gateways.Gateway;

public class AuthorizationGateway extends Gateway{

	private final String name= "//127.0.0.1:1099/AuthorizationServer";
	private IAuthService server;
	public AuthorizationGateway() throws Exception{
		super();
		server= (IAuthService) lookup(name);
	}

	public IAuthService lookup(String name) throws RemoteException, MalformedURLException, NotBoundException {		
		return (IAuthService) Naming.lookup(name);
	}
	public boolean doesUserExist(String name){
		try {
			return server.doesUserExist(name);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean checkPass(String userName, String pass) {
		try {
			return server.checkPass(name, pass);
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
