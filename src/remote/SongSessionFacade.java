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
	public ArrayList<String> getListSongs() throws RemoteException{
		return provider.getListSongs();
	}

	@Override
	public SongDTO downloadSong(String name, String nick) throws RemoteException{
		return provider.giveSong(name, nick);
	}

}
