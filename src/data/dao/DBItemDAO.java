package data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Artist;
import data.DBItem;
import data.Song;

public class DBItemDAO implements IDBItemDAO {

	private PersistenceManagerFactory pmf;
	
	public DBItemDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("TralalaJDO");
	}
	
	public void storeItem(DBItem item) {
		this.storeObject(item);
	}

	public void storeArtist(Artist artist) {
		this.storeItem(artist);
	}

	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + object);
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
	public List<DBItem> getItems() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<DBItem> items = new ArrayList<DBItem>();
		
		try {
			System.out.println("   * Retrieving an Extent for Items.");
			
			tx.begin();			
			Extent<DBItem> extent = pm.getExtent(DBItem.class, true);
			
			for (DBItem item : extent) {
				items.add(item);
			}
			
			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return items;
	}

	public List<Artist> getArtists() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Artist> artists = new ArrayList<Artist>();
		
		try {
			System.out.println("   * Retrieving an Extent for Artists.");
			
			tx.begin();			
			Extent<Artist> extent = pm.getExtent(Artist.class, true);
			
			for (Artist artist : extent) {
				artists.add(artist);
			}
			
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	    
		return artists;
	}
	
	public List<Song> getSongs() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Song> songs = new ArrayList<Song>();
		
		try {
			System.out.println("   * Retrieving an Extent for songs.");
			
			tx.begin();			
			Extent<Song> extent = pm.getExtent(Song.class, true);
			
			for (Song song : extent) {
				songs.add(song);
			}
			
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	    
		return songs;
	}

	public List<DBItem> getItems(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    List<DBItem> items = new ArrayList<DBItem>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Items given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<DBItem> extent = pm.getExtent(DBItem.class, true);
			Query query = pm.newQuery(extent, condition);

			for (DBItem item : (List<DBItem>)query.execute()) {
				items.add(item);
			}
			
	        tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
			
    		pm.close();
	    }
    
	    return items;
	}

	public DBItem getItem(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		DBItem item = null;
	    
		try {
			System.out.println ("   * Querying an Item: " + id);
	    	tx.begin();
	    	Query query = pm.newQuery("SELECT FROM " + DBItem.class.getName() + " WHERE id == '" + id + "'");
	    	query.setUnique(true);
	    	item = (DBItem)query.execute();	    	
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	    
	    return item;
	}

	public void updateItem(DBItem item) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(item);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}

	public void deleteItems() {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	
	    	Extent<DBItem> extent = pm.getExtent(DBItem.class, true);
			
			for (DBItem item : extent) {
				pm.deletePersistent(item);
			}
	    	
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error deleting all items: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }	   
	}

}