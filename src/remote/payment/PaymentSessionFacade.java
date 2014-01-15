package remote.payment;

public class PaymentSessionFacade {
	private EPaymentMethod payServ;
	
	public PaymentSessionFacade(EPaymentMethod pay) {
		payServ = pay;
	}
	
	public double currentAmount() {
		return payServ.currentAmount();
	}
	
}
