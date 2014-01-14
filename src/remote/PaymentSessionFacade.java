package remote;

public class PaymentSessionFacade {
	private EPaymentMethod payServ;
	
	public PaymentSessionFacade(EPaymentMethod pay) {
		payServ = pay;
	}
	
	public double currentAmount() {
		return payServ.currentAmount();
	}

}
