package data.dao;

@PersistenceCapable
public class PlayDAO {
	
	@PrimaryKey
	Object date;
	Object time;
	
	SongDAO song;
	MemberDAO member;
	
	public PlayDAO(){
		
	}
	
}
