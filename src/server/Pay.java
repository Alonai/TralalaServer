package server;

import gateways.payment.PaymentGWFactory;
import gateways.payment.PaymentGateway;
import gateways.payment.enums.PaymentService;
import data.Member;

public class Pay extends EPaymentMethod{

	@Override
	public void pay(Member m) {
		double amount = this.currentAmount(m);
		//Depending on the member
		PaymentGateway pgw;
		pgw = PaymentGWFactory.createGateway(PaymentService.Bank, 
				new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
		pgw = PaymentGWFactory.createGateway(PaymentService.PayPal, 
				new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
		pgw.pay();
	}
}
