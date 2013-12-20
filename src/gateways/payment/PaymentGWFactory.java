package gateways.payment;

import gateways.payment.enums.PaymentService;

public class PaymentGWFactory {

	/** Creates the PaymentGateway specified by 'service'. Must provide options.
	 * @param service
	 * @param options
	 * @return
	 */
	public static PaymentGateway createGateway(PaymentService service, String[] options){
		switch (service) {
			case PayPal:
				return new PayPalGW(options);
			case Bank:
				return new BankingGW(options);
			default:
				return null;
		}
	}
}
