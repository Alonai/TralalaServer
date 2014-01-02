package remote;

import java.rmi.server.UnicastRemoteObject;

import data.dto.SongDTO;

public class SongSessionFacade extends UnicastRemoteObject implements ISongSessionFacade{
	private SongProvider provider;

	@Override
	public String getListSongs() {
		return provider.getListSongs();
	}

	@Override
	public SongDTO downloadSong(String name) {
		return provider.giveSong(name);
	}

}
