package remote.payment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.Member;
import server.EPaymentMethod;

public class PaymentSessionFacade extends UnicastRemoteObject{
	private EPaymentMethod payServ;
	
	public PaymentSessionFacade(EPaymentMethod pay) throws RemoteException{
		super();
		payServ = pay;
	}
	
	public double currentAmount(Member m) {
		return payServ.currentAmount(m);
	}
	
}
