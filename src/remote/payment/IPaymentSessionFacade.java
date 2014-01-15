package remote.payment;

import java.rmi.Remote;

import data.Member;

public interface IPaymentSessionFacade extends Remote{
	
	public double currentAmount(Member m);

}
