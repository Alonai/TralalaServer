package remote;

import java.util.ArrayList;

import data.dto.SongDTO;

public interface ISongSessionFacade {
	
	public ArrayList<String> getListSongs();
	
	public SongDTO downloadSong(String name);

}
