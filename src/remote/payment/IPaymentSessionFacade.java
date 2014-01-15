package remote.payment;

import data.Member;

public interface IPaymentSessionFacade {
	
	public double currentAmount(Member m);

}
