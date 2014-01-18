package data.dto;

import java.io.Serializable;

import data.Artist;
import data.Song;

public class SongDTO implements Serializable{

	private String title;
	private int duration;
	private double ppp;
	private String artistName;
	
	protected SongDTO(Song song){
		title=song.getTitle();
		duration=song.getDuration();
		ppp=song.getPpp();
		artistName=song.getArtist().getName();
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public double getPpp() {
		return ppp;
	}

	public String getArtistName() {
		return artistName;
	}
	
}
