package remote;

public interface ISongSessionFacade {
	
	public String getListSongs();
	
	public SongDTO downloadSong(String name);

}
