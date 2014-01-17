package gateways.payment;

import gateways.payment.enums.PaymentService;

public class PaymentGWFactory {

	private static PaymentGWFactory instance=null;
	private PayPalGW payPalGW;
	private BankingGW bankingGW;
	
	private PaymentGWFactory(PayPalGW paypal, BankingGW banking){
		payPalGW= paypal;
		bankingGW= banking;
	}
	public static PaymentGWFactory getInstance(PayPalGW p, BankingGW b){
		if(instance== null){
			instance= new PaymentGWFactory(p, b);
		}
		return instance;
	}
	
	/** Creates the PaymentGateway specified by 'service'. Must provide options.
	 * @param service
	 * @param options
	 * @return
	 */
	public PaymentGateway createGateway(PaymentService service, String[] options){
		switch (service) {
			case PayPal:
				payPalGW.setOptions(options);
				return payPalGW;
			case Bank:
				bankingGW.setOptions(options);
				return bankingGW;
			default:
				return null;
		}
	}
}
