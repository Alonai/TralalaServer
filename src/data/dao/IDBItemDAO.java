package data.dao;

import java.util.List;

import data.Artist;
import data.DBItem;

public interface IDBItemDAO {
	public void storeItem(DBItem item);
	public void storeArtist(Artist artist);
	public List<DBItem> getItems();
	public List<Artist> getArtists();
	public List<Song> getSongs();
	public List<DBItem> getItems(String condition);
	public DBItem getItem(String id);
	public void updateItem(DBItem product);
	public void deleteItems();
}
