package data;

public class Play {

	private String date;
	private String time;
	private String songId;
	private String memberId;
	
	public Play(String date, String time,String songID, String memberID){
		this.date=date;
		this.time=time;
		memberID=memberID;
		songId=songID;
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

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
