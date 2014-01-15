package data.dto;

import data.Song;

public class SongAssembler {

	public static SongDTO createSongDTO(Song song){
		return new SongDTO(song);
	}
}
