package data;

import java.util.ArrayList;

import gateways.payment.enums.PaymentService;

public class Member {

	private String id;
	private String name;
	private String nick;
	private ArrayList<Play> plays;
	private long bankAccount;
	private PaymentService paymentService;
	
	public Member(String id, String name, String nick, long bankAccount){
		this.id=id;
		this.name=name;
		this.nick=nick;
		this.bankAccount=bankAccount;
		this.plays=new ArrayList<Play>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public ArrayList<Play> getPlays() {
		return plays;
	}

	public void addPlay(String date, String time, String songId) {
		plays.add(new Play(date, time, songId, id));
	}

	public long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
	}
	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService){
		this.paymentService=paymentService;
	}
	
	
}
