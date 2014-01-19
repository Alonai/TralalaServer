package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Song {

	private String songTitle;
	private int duration;
	private double ppp;
	private Artist artist;
	private Album album;
	private String lyrics;
	
	public Song(String title, int duration, String lyrics) {
		songTitle=title;
		this.duration=duration;
		ppp=0;
		this.lyrics=lyrics;
	}
	
	public String getTitle() {
		return songTitle;
	}
	public void setTitle(String title) {
		this.songTitle = title;
	}
	public String getLyrics(){
		return lyrics;
	}
	public void setLyrics(String lyrics){
		this.lyrics=lyrics;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getPpp() {
		return ppp;
	}
	public void setPpp(double ppp) {
		this.ppp = ppp;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Album getAlbum(){
		return album;
	}
	public void setAlbum(Album album){
		this.album = album;
	}
	
}