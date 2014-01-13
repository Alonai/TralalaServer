package data.dao;

import org.datanucleus.store.query.Query;

import data.Song;

public class Controller {
	
	PersistenceManagerFactory pmf;
	PersistenceManager pm;
	
	public Controller(){
		pmf = JDOHelper.getPersistenceManagerFactory("TralalaDAO");
		pm = pmf.getPersistenceManager();
	}
	public void persist(Set<data.Artist> artists, Set<data.Member> members){
		Transaction tx=pm.currentTransaction();
		try
		{
		    tx.begin();
		    for(data.Artist artist: artists){
		    	ArtistDAO artistDAO=new ArtistDAO(artist);
		    	pm.makePersistent(artistDAO);
		    }
		    for(data.Member member: members){
		    	MemberDAO memberDAO=new MemberDAO(member);
		    	pm.makePersistent(memberDAO);
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
	public Set<Song> getAllSongs(){
		Transaction tx = pm.currentTransaction();
		Set<Song> doSongs=new Set<Song>();
		try
		{
		    tx.begin();

		    Query q = pm.newQuery("SELECT FROM " + SongDAO.class.getName());
		    Set<SongDAO> songs = (Set<SongDAO>)q.execute();
		    Iterator<SongDAO> iter = songs.iterator();
		    while (iter.hasNext())
		    {
		        SongDAO s = iter.next();
		        doSongs.add(new Song(s));
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
		return doSongs;
	}
}
