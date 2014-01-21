package launcher;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import service.interfaces.IAuthService;
import gateways.authorization.AuthorizationGateway;

public class PruebasDebug {

	public static void main(String [] argv){
		for(String s: argv)
			System.out.println(s);
		if(System.getSecurityManager()==null)
			System.setSecurityManager(new RMISecurityManager());
		String auth=  "//" + argv[9] + ":" + argv[10] + "/" + argv[11];
		
		System.out.println("auth: " + auth);
		try {
			IAuthService server= (IAuthService) Naming.lookup(auth);
			server.createUser("irene", "irene");
			if(server.doesUserExist("irene")) System.out.println("ok");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
