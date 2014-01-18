package data;

import data.dao.DBItemDAO;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable = "true")
public class Play{

	private String date;
	private String time;
	private Song song;
	private Member member;
	
	public Play(String date, String time,Song song, Member member){
		this.date=date;
		this.time=time;
		this.member=member;
		this.song=song;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setSong(Song song) {
		this.song= song;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public Song getSong(){
	 	return song;
	}
	
}
