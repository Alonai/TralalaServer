package data.dao;

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
}
