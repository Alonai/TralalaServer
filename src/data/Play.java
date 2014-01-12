package data;

import data.dao.MemberDAO;

public class Play {

	public Object date;
	public Object time;
	public int songId;
	Member member;
	
	public Play(PlayDAO play, Member parent){
		this.date=play.date;
		this.time=play.time;
		member=parent;
		this.songId=play.songId;
	}
	
}
