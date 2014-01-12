package data;

import data.dao.ArtistDAO;

public class Song {
	
	public int id;
	public String title;
	public int duration;
	public double ppp;
	public Artist artist;
	
	public Song(SongDAO song, Artist artist){
		this.title=song.title;
		this.id=song.id;
		this.duration=song.duration;
		this.ppp=song.ppp;
		this.artist=artist;
	}
	
}
