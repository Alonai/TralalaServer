package data.dao;

@PersistenceCapable
public class AlbumDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String title;
	Object releaseDate;
	Set<ArtistDAO> artists;
	Set<SongDAO> songs;
	
	public AlbumDAO(){
		
	}
	
}
