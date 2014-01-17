package server;

import gateways.payment.PaymentGWFactory;
import gateways.payment.PaymentGateway;
import gateways.payment.enums.PaymentService;
import data.Member;

public class Pay extends EPaymentMethod{
	
	// Factory used to create the gateways, the factory previously has been created with one instance of each gateway type
	private PaymentGWFactory factory;
	
	public Pay(PaymentGWFactory factory){
		this.factory= factory;
	}
	
	
	@Override
	public void pay(Member m) {
		double amount = this.currentAmount(m);
		//Depending on the member
		PaymentGateway pgw;
		switch(m.getPaymentService()) {
			case "Bank":
			pgw = factory.createGateway(PaymentService.Bank, 
					new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
			break;
			case "PayPal":
				pgw = factory.createGateway(PaymentService.PayPal, 
						new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
				break;
			default:
				pgw = null;
				break;
		}
		pgw.pay();
	}
}
