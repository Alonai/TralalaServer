package gateways.payment;

import server.PPServer;

public class PayPalGW extends PaymentGateway{

	private String[] options;
	/** [0]: server name
	 *  [1]: credit card number
	 *  [2]: amount to pay
	 * @param options
	 */
	public PayPalGW(String[] options){
		super();
		this.options= options;
		
	}
	/**Pay to PayPal
	 */
	public boolean pay() {
		return payToPayPal(options[0], new Long(options[1]).longValue(), new Double(options[2]).doubleValue());
	}
	/** Method that charges the amount 'amount' to the credit card 'ccard' in the server specified by 'name'
	 * @param name
	 * @param ccard
	 * @param amount
	 * @return true if everything goes OK, false if not
	 */
	private boolean payToPayPal(String name, long ccard, double amount){
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
