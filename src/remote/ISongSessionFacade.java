package remote;

import java.rmi.Remote;
import java.util.ArrayList;

import data.dto.SongDTO;

public interface ISongSessionFacade extends Remote{
	
	public ArrayList<String> getListSongs();
	
	public SongDTO downloadSong(String name);

}
