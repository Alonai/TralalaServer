package remote.payment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.Member;
import data.dao.DBItemDAO;
import server.EPaymentMethod;

public class PaymentSessionFacade  extends UnicastRemoteObject implements IPaymentSessionFacade{
	DBItemDAO dao;
	
	public PaymentSessionFacade(DBItemDAO dbDAO) throws RemoteException{
		super();
		dao = dbDAO;
	}
	
	public double currentAmount(String nick) throws RemoteException{
		Member member = dao.getMember(nick);
		return EPaymentMethod.currentAmount(member);
	}
	
}
