package data.dao;

import data.Song;

@PersistenceCapable
public class AlbumDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String title;
	Object releaseDate;
	ArtistDAO artist;
	Set<SongDAO> songs;
	
	public AlbumDAO(data.Album album, ArtistDAO artistC){
		this.title= album.title;
		this.releaseDate=album.releaseDate;
		this.artist=artistC;
		this.songs=new Set<SongDAO>();
		for(Song song:album.songs){
			this.songs.add(new SongDAO(song, artistC));
		}
	}
	
}
