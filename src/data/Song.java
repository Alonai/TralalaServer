package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Song extends DBItem {

	private String songTitle;
	private int duration;
	private double ppp;
	private Artist artist;
	private Album album;
	
	public Song(String id,String title, int duration) {
		super(id);
		songTitle=title;
		this.duration=duration;
		ppp=0;
	}
	
	public String getTitle() {
		return songTitle;
	}
	public void setTitle(String title) {
		this.songTitle = title;
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