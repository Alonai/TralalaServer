package remote;

import gateways.payment.enums.PaymentService;

public class PaymentSessionFacade {
	private PaymentService payServ;
	
	public PaymentSessionFacade(PaymentService pay) {
		payServ = pay;
	}

}
