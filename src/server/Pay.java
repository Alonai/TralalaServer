package server;

import gateways.payment.PaymentGWFactory;
import gateways.payment.enums.PaymentService;
import data.Member;

public class Pay extends EPaymentMethod{

	@Override
	public void pay(Member m) {
		double amount = this.currentAmount(m);
		//Depending on the member  
		//PaymentGWFactory.createGateway(PaymentService.Bank, options);
		//PaymentGWFactory.createGateway(PaymentService.PayPal, options);
	}
}
