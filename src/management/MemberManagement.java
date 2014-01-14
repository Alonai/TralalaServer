package management;

import gateways.authorization.AuthorizationGateway;

public class MemberManagement implements IMemberManagement{
	private AuthorizationGateway auth;
	
	public MemberManagement(AuthorizationGateway ag) {
		auth = ag;
	}
	
	public boolean signIn(String user, String pass) {
		if (auth.doesUserExist(user) && auth.checkPass(user, pass)) {
			return true;
		}
		
		return false;
	}

}
