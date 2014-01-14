package data.dto;

import data.Song;

public class SongAssembler {

	public SongDTO createSongDTO(Song song){
		return new SongDTO(song);
	}
}
