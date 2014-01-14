package server;

import data.Member;

public class FavourablePay extends EPaymentMethod{

	//Discount percentage.
	private final float OFF = 15;
	
	@Override
	public void pay(Member m) {
		//Calculate the amount to pay and applies the discount percentage.
		double amount = this.currentAmount(m) * (100 - OFF) / 100;
		
	}

}
