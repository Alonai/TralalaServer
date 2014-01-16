package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dto.SongDTO;

public interface ISongSessionFacade extends Remote{
	
	public ArrayList<String> getListSongs() throws RemoteException;
	
	public SongDTO downloadSong(String name) throws RemoteException;

}
