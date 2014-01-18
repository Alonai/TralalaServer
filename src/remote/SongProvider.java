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
		List<Song> songs= getListSongs();
		for(Song song:songs){
			if(song.getTitle().equals(name)){
				return SongAssembler.createSongDTO(song);
			}
		}
		return null;
	}
	
}
