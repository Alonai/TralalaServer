package remote;

import java.util.Set;

import data.Song;
import data.dao.Controller;
import data.dto.SongDTO;

public class SongProvider {
	private Controller controller;
	
	public SongProvider(Controller control) {
		controller = control;
	}
	
	public Set<Song> getListSongs() {
		return controller.getAllSongs();
	}
	
	public SongDTO giveSong(String name) {
		//NEcesito el metodo para sacar la song que yo quiera
		return controller.getSong(name);
	}

	
}
