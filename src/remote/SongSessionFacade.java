package remote;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import data.Song;
import data.dto.SongDTO;

public class SongSessionFacade extends UnicastRemoteObject implements ISongSessionFacade{
	private SongProvider provider;

	@Override
	public ArrayList<String> getListSongs() {
		//Convertir lista de songs a list de strings
		ArrayList<String> ret = new ArrayList<String>();
		Set<Song> songs = provider.getListSongs();
		for (Iterator<Song> it = songs.iterator(); it.hasNext(); ) {
	        Song song = it.next();
	        ret.add(song.title + " - " + song.artist);
	    }
		return ret;
	}

	@Override
	public SongDTO downloadSong(String name) {
		return provider.giveSong(name);
	}

}
