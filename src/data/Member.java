package data;

import gateways.payment.enums.PaymentService;
import data.dao.PlayDAO;

public class Member {

	public int id;
	public String name;
	public String nick;
	public Set<Play> plays;
	private long bankAccount;
	private PaymentService paymentService;
	
	public Member(MemberDAO member){
		this.id=member.id;
		this.name=member.name;
		this.nick=member.nick;
		this.plays=new Set<Play>();
		for(PlayDAO play: member.plays){
			this.plays.add(new Play(play, this));
		}
	}
	
	public long getBankAccount() {
		return bankAccount;
	}
	
	public PaymentService getPaymentService() {
		return paymentService;
	}
}
