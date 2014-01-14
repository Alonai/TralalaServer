package data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Album extends DBItem {
	
	private String title;
	private Object releaseDate;
	private ArrayList<Song> songs;
	
	public Album(String id){
		super(id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Object getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Object releaseDate) {
		this.releaseDate = releaseDate;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void addSong(Song song){
		songs.add(song);
	}	
}