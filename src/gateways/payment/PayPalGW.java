package gateways.payment;

import java.rmi.Naming;

import server.IPPServer;
import server.PPServer;

public class PayPalGW extends PaymentGateway{

	private IPPServer server;
	private String[] options= null;
	
	public PayPalGW(String name) throws Exception{
		super();
		server= (IPPServer) Naming.lookup(name);
	}

	/** [0]: credit card number
	 *  [1]: amount to pay
	 * @param options
	 */
	public void setOptions(String[] options){
		this.options= options;
	}
	/**Pay to PayPal
	 */
	public boolean pay() {
		if(options==null) return false;
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
			ret= server.pay(ccard, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
