package data.dto;

import data.Artist;
import data.Song;

public class SongDTO implements Serializable{

	int id;
	String title;
	int duration;
	double ppp;
	String artistName;
	
	public SongDTO(Song song){
		this.id=song.id;
		this.title=song.title;
		this.duration=song.duration;
		this.ppp=song.ppp;
		artistName=song.artist.name;
	}
	
}
