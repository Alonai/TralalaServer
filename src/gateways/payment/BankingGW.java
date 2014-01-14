package gateways.payment;

import server.BankingServer;

public class BankingGW extends PaymentGateway{
	
	private final String name= "//127.0.0.1:4321/BankingServer";
	private String[] options;
	/** [0]: bank account
	 *  [1]: amount to pay
	 * @param options
	 */
	public BankingGW(String[] options){
		super();
		this.options= options;
		
	}
	/**Pay to PayPal
	 */
	public boolean pay() {
		return payToBank(options[0], new Double(options[1]).doubleValue());
	}
	/** Method that charges the amount 'amount' to the bank account 'account' in the server specified by 'name'
	 * @param name
	 * @param ccard
	 * @param amount
	 * @return true if everything goes OK, false if not
	 */
	private boolean payToBank(String account, double amount){
		boolean ret= false;
		try {
			BankingServer server= (BankingServer) lookup(name);
			ret= server.pay(account, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
