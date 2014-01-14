package data;

public class Play {

	public Object date;
	public Object time;
	public int songId;
	int memberId;
	
	public Play(Object date, Object time,int songID, int memberID){
		this.date=date;
		this.time=time;
		memberID=memberID;
		songId=songID;
	}
	
}
