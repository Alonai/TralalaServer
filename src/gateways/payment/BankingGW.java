package gateways.payment;

import server.BankingServer;

public class BankingGW extends PaymentGateway{
	
	private String[] options=null;
	private BankingServer server;
	

	public BankingGW(String name)throws Exception{
		super();
		server= (BankingServer) lookup(name);
	}
	/** [0]: bank account
	 *  [1]: amount to pay
	 * @param options
	 */
	public void setOptions(String[] options){
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
			ret= server.pay(account, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
