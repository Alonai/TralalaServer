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
import data.Member;
import data.Song;

public class DBItemDAO implements IDBItemDAO {

	private PersistenceManagerFactory pmf;
	private final int FETCHDEPTH=10;
	
	public DBItemDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("TralalaJDO");
	}
	
	public void storeItem(Object item) {
		this.storeObject(item);
	}

	public void storeArtist(Artist artist) {
		this.storeItem(artist);
	}

	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
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
	
	public List<Object> getItems() {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		List<Object> items = new ArrayList<Object>();
		
		try {
			System.out.println("   * Retrieving an Extent for Items.");
			
			tx.begin();			
			Extent<Object> extent = pm.getExtent(Object.class, true);
			
			for (Object item : extent) {
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
		setFetchDepth(pm);
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
	
	public Member getMember(String nick) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		Member member=null;
		
		try {
			System.out.println("   * Retrieving an Extent for Member.");
			
			tx.begin();			
			Extent<Member> extent = pm.getExtent(Member.class, true);
			
			for (Member memberE : extent) {
				if (memberE.getNick().equals(nick)){
					member=memberE;
				}
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
		return member;
	}
	
	public Song getSong(String name) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		Song song=null;
		
		try {
			System.out.println("   * Retrieving an Extent for Member.");
			
			tx.begin();			
			Extent<Song> extent = pm.getExtent(Song.class, true);
			
			for (Song songE : extent) {
				if (songE.getTitle().equals(name)){
					song=songE;
				}
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
		return song;
	}
	
	public List<Song> getSongs() {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
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

	public List<Object> getItems(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
	    Transaction tx = pm.currentTransaction();
	    List<Object> items = new ArrayList<Object>();
	        
	    try {
	    	System.out.println("   * Executing a Query for Items given a condition: " + condition);
	    	
	    	tx.begin();	    	
			Extent<Object> extent = pm.getExtent(Object.class, true);
			Query query = pm.newQuery(extent, condition);

			for (Object item : (List<Object>)query.execute()) {
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

	public void updateItem(Object item) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
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
		setFetchDepth(pm);
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	
	    	Extent<Object> extent = pm.getExtent(Object.class, true);
			
			for (Object item : extent) {
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
	private void setFetchDepth(PersistenceManager pm){
		pm.getFetchPlan().setMaxFetchDepth(FETCHDEPTH);
	}

}