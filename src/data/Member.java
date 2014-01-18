package data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;

import server.IVisitable;
import server.Visitor;

@PersistenceCapable(detachable = "true")
public class Member implements IVisitable{

	private String name;
	private String nick;
	private ArrayList<Play> plays;
	private long bankAccount;
	private String paymentService;
	
	
	public Member(String name, String nick, long bankAccount){
		this.name=name;
		this.nick=nick;
		this.bankAccount=bankAccount;
		this.plays=new ArrayList<Play>();
		paymentService="none";
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

	public void addPlay(String date, String time, Song song) {
		plays.add(new Play(date, time, song,this));
	}

	public long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(String paymentService){
		this.paymentService=paymentService;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	
}
