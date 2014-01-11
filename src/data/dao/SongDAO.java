package data.dao;

@PersistenceCapable
public class SongDAO {
	
	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String title;
	int duration;
	double ppp;
	Set<ArtistDAO> artists;
	
	public SongDAO(data.Song song){
		
	}
	
}
