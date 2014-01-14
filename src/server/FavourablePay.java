package server;

import gateways.payment.PaymentGWFactory;
import gateways.payment.PaymentGateway;
import gateways.payment.enums.PaymentService;
import data.Member;

public class FavourablePay extends EPaymentMethod{

	//Discount percentage.
	private final float OFF = 15;
	
	@Override
	public void pay(Member m) {
		//Calculate the amount to pay and applies the discount percentage.
		double amount = this.currentAmount(m) * (100 - OFF) / 100;
		//Depending on the member
		PaymentGateway pgw;
		switch(m.getPaymentService()) {
			case Bank:
			pgw = PaymentGWFactory.createGateway(PaymentService.Bank, 
					new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
			break;
			case PayPal:
				pgw = PaymentGWFactory.createGateway(PaymentService.PayPal, 
						new String[] {String.valueOf(m.getBankAccount()), String.valueOf(amount)});
				break;
			default:
				pgw = null;
				break;
		}
		pgw.pay();
	}

}
