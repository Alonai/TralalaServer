package data.dao;

import data.Play;

@PersistenceCapable
public class MemberDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String name;
	String nick;
	Set<PlayDAO> plays;
	
	public MemberDAO(data.Member member){
		this.id=member.id;
		this.name=member.name;
		this.nick=member.nick;
		this.plays=new Set<PlayDAO>();
		for(Play play: member.plays){
			this.plays.add(new PlayDAO(play, this));
		}
	}
}
