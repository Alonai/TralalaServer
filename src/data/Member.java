package data;

import data.dao.PlayDAO;

public class Member {

	public int id;
	public String name;
	public String nick;
	public Set<Play> plays;
	public Member(MemberDAO member){
		this.id=member.id;
		this.name=member.name;
		this.nick=member.nick;
		this.plays=new Set<Play>();
		for(PlayDAO play: member.plays){
			this.plays.add(new Play(play, this));
		}
	}
	
}
