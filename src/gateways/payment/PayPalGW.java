package gateways.payment;

import server.PPServer;

public class PayPalGW extends PaymentGateway{

	private final String name= "//127.0.0.1:1099/PayPalServer";
	private String[] options;
	/** [0]: credit card number
	 *  [1]: amount to pay
	 * @param options
	 */
	public PayPalGW(String[] options){
		super();
		this.options= options;
		
	}
	/**Pay to PayPal
	 */
	public boolean pay() {
		return payToPayPal(new Long(options[0]).longValue(), new Double(options[1]).doubleValue());
	}
	/** Method that charges the amount 'amount' to the credit card 'ccard' in the server specified by 'name'
	 * @param name
	 * @param ccard
	 * @param amount
	 * @return true if everything goes OK, false if not
	 */
	private boolean payToPayPal(long ccard, double amount){
		boolean ret= false;
		try {
			PPServer server= (PPServer) lookup(name);
			ret= server.pay(ccard, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
