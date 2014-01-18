package data.dao;

import java.util.List;

import data.Artist;
import data.Song;

public interface IDBItemDAO {
	public void storeItem(Object item);
	public void storeArtist(Artist artist);
	public List<Object> getItems();
	public List<Artist> getArtists();
	public List<Song> getSongs();
	public List<Object> getItems(String condition);
	public void updateItem(Object product);
	public void deleteItems();
}
