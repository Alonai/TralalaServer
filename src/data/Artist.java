package data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Artist extends DBItem {
	
	private String name;
	private ArrayList<Song> songs;
	
	public Artist(int id, String name){
		super(id);
		this.name=name;
		songs=new ArrayList<Song>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addSong(Song song, int id, String title, int duration, double ppp,Album album){
		song.setId(id);
		song.setTitle(title);
		song.setDuration(duration);
		song.setPpp(ppp);
		song.setArtist(this);
		song.setAlbum(album);
		songs.add(song);
	}
	public ArrayList<Song> getSongs(){
		return songs;
	}
}