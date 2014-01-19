package remote.payment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.Member;
import server.EPaymentMethod;

public class PaymentSessionFacade extends UnicastRemoteObject{
	
	public PaymentSessionFacade() throws RemoteException{
		super();
	}
	
	public double currentAmount(Member m) throws RemoteException{
		return EPaymentMethod.currentAmount(m);
	}
	
}
