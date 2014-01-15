package remote.payment;

import data.Member;
import server.EPaymentMethod;

public class PaymentSessionFacade {
	private EPaymentMethod payServ;
	
	public PaymentSessionFacade(EPaymentMethod pay) {
		payServ = pay;
	}
	
	public double currentAmount(Member m) {
		return payServ.currentAmount(m);
	}
	
}
