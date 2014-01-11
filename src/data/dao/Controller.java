package data.dao;

public class Controller {
	
	PersistenceManagerFactory pmf;
	PersistenceManager pm;
	
	public Controller(){
		pmf = JDOHelper.getPersistenceManagerFactory("TralalaDAO");
		pm = pmf.getPersistenceManager();
	}
	public void persist(Set<data.Artist> artists){
		Transaction tx=pm.currentTransaction();
		try
		{
		    tx.begin();
		    for(data.Artist artist: artists){
		    	ArtistDAO artistDAO=new ArtistDAO(artist);
		    	pm.makePersistent(artistDAO);
		    }
		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
	}
}
