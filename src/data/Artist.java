package data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Artist {
	
	private String name;
	private ArrayList<Song> songs;
	
	public Artist(String name){
		this.name=name;
		songs=new ArrayList<Song>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addSong(Song song, String title, int duration, double ppp,Album album){
		song.setTitle(title);
		song.setDuration(duration);
		song.setPpp(ppp);
		song.setArtist(this);
		song.setAlbum(album);
		songs.add(song);
	}
	public void addSong(Song song){
		song.setArtist(this);
		songs.add(song);
	}
	public ArrayList<Song> getSongs(){
		return songs;
	}
}