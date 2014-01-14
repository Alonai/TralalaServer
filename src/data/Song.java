package data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class Song extends DBItem {

	private String title;
	private int duration;
	private double ppp;
	private Artist artist;
	private Album album;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		album.addSong(this);
	}
	
}