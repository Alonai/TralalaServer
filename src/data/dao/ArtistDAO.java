package data.dao;

import data.Album;
import data.Artist;

@PersistenceCapable
public class ArtistDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String name;
	Set<AlbumDAO> albums;
	Set<SongDAO> songs;
	
	public ArtistDAO(Artist artist){
		this.id=artist.id;
		this.name=artist.name;
		this.albums=new Set<AlbumDAO>();
		this.songs=new Set<SongDAO>();
		for (Album album : artist.albums){
			AlbumDAO albumD=new AlbumDAO(album);
			this.albums.add(albumD);
		}
	}
	
}
