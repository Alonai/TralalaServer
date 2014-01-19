package remote.payment;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPaymentSessionFacade extends Remote{
	
	public double currentAmount(String nick) throws RemoteException;

}
