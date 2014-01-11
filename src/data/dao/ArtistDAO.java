package data.dao;

@PersistenceCapable
public class ArtistDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String name;
	Set<AlbumDAO> albums;
	Set<SongDAO> songs;
	
	public ArtistDAO(){
		
	}
	
}
