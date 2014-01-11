package data;

import data.dao.AlbumDAO;
import data.dao.SongDAO;

public class Artist {
	
	int id;
	String name;
	public Set<Album> albums;
	Set<Song> songs;
	
	public Artist(ArtistDAO artist){
		this.id=artist.id;
		this.name=artist.name;
		this.albums=new Set<Album>();
		this.songs=new Set<Song>();
		for (Album album : artist.albums){
			Album albumS=new Album(album);
			this.albums.add(albumS);
		}
	}
	
}
