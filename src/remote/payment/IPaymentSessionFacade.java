package remote.payment;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.Member;

public interface IPaymentSessionFacade extends Remote{
	
	public double currentAmount(Member m) throws RemoteException;

}
