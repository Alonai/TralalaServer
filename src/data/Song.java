package data;

import data.dao.ArtistDAO;

public class Song {
	
	int id;
	String title;
	int duration;
	double ppp;
	Artist artist;
	
	public Song(SongDAO song, Artist artist){
		this.title=song.title;
		this.id=song.id;
		this.duration=song.duration;
		this.ppp=song.ppp;
		this.artist=artist;
	}
	
}
