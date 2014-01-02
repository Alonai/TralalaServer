package gateways.payment;

import java.rmi.Naming;
import java.rmi.Remote;

import gateways.Gateway;

public abstract class PaymentGateway extends Gateway{

	public PaymentGateway(){
		super();
	}
	
	public Remote lookup(String name)throws Exception{
		return Naming.lookup(name);
	}
	
	public abstract boolean pay();
	
}

