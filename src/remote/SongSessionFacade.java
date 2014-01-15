package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import data.Song;
import data.dto.SongDTO;

public class SongSessionFacade extends UnicastRemoteObject implements ISongSessionFacade{
	private SongProvider provider;
	
	public SongSessionFacade(SongProvider sp) throws RemoteException{
		super();
		this.provider = sp;
	}

	@Override
	public ArrayList<String> getListSongs() {
		//Convertir lista de songs a list de strings
		ArrayList<String> ret = new ArrayList<String>();
		List<Song> songs = provider.getListSongs();
		for (Iterator<Song> it = songs.iterator(); it.hasNext(); ) {
	        Song song = it.next();
	        ret.add(song.getTitle() + " - " + song.getArtist() + " - " + song.getId());
	    }
		return ret;
	}

	@Override
	public SongDTO downloadSong(String name) {
		return provider.giveSong(name);
	}

}
