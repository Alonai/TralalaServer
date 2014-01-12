package data.dao;

@PersistenceCapable
public class PlayDAO {
	
	@PrimaryKey
	Object date;
	Object time;
	
	//SongDAO song;
	int songId
	MemberDAO member;
	
	public PlayDAO(data.Play play, MemberDAO parent){
		this.date=play.date;
		this.time=play.time;
		member=parent;
		this.songId=play.songId;
	}
	
}
