package gateways.authorization;

import java.rmi.Naming;
import java.rmi.Remote;

import service.interfaces.IAuthService;
import service.interfaces.sign.ISignInService;
import gateways.Gateway;

public class AuthorizationGateway extends Gateway{

	private final String name= "//127.0.0.1:4322/AuthorizationServer";
	private Remote server;
	public AuthorizationGateway() throws Exception{
		super();
		server= lookup(name);
	}

	public Remote lookup(String name) throws Exception {		
		return Naming.lookup(name);
	}
	public boolean doesUserExist(String name){
		return ((IAuthService) server).doesUserExist(name);
	}
	public boolean checkPass(String userName, String pass) {
		return ((IAuthService) server).checkPass(name, pass);
	}
	public boolean signIn(String user, String pass){
		return ((ISignInService) server).signIn(user, pass);
	}
	public boolean createUser(String name, String pass){
		return ((AuthorizationGateway) server).createUser(name, pass);
	}
}
