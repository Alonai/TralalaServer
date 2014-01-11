package data;

import data.dao.ArtistDAO;
import data.dao.SongDAO;


public class Album {
	
	int id;
	public String title;
	Object releaseDate;
	Artist artist;
	Set<Song> songs;
	
	public AlbumDAO(AlbumDAO album, Artist artistC){
		this.title= album.title;
		this.releaseDate=album.releaseDate;
		this.artist=artistC;
		this.songs=new Set<Song>();
		for(SongDAO song:album.songs){
			this.songs.add(new Song(song, artistC));
		}
	}
	
}
