package remote;

import java.util.List;

import data.Member;
import data.Play;
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
	
	public SongDTO giveSong(String name, String nick) {
		Song song = controller.getSong(name);
		String date = "1/1/11";
		String time = "00:00";
		Member member = controller.getMember(nick);
		if (member != null) {
			member.addPlay(date, time, song);
			controller.updateItem(member);
		}
		return SongAssembler.createSongDTO(song);
	}
	
}
