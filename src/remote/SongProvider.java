package remote;

import java.util.List;

import data.Song;
import data.dao.DBItemDAO;
import data.dto.SongAssembler;
import data.dto.SongDTO;

public class SongProvider {
	private DBItemDAO controller;
	
	public SongProvider(DBItemDAO control) {
		controller = control;
	}
	
	public List<Song> getListSongs() {
		return controller.getSongs();
	}
	
	public SongDTO giveSong(String name) {
		//NEcesito el metodo para sacar la song que yo quiera
		return SongAssembler.createSongDTO((Song)controller.getItem(name));
	}

	
}
