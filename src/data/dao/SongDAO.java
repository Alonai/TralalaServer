package data.dao;

@PersistenceCapable
public class SongDAO {
	
	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String title;
	int duration;
	double ppp;
	ArtistDAO artist;
	
	public SongDAO(data.Song song, ArtistDAO artist){
		this.title=song.title;
		this.id=song.id;
		this.duration=song.duration;
		this.ppp=song.ppp;
		this.artist=artist;
	}
	
}
