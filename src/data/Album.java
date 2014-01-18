package data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Album {
	
	private String title;
	private String releaseDate;
	private ArrayList<Song> songs;
	
	public Album(String title, String releaseDate){
		this.releaseDate=releaseDate;
		this.title=title;
		songs=new ArrayList<Song>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void addSong(Song song){
		song.setAlbum(this);
		songs.add(song);
	}	
}