package remote;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public ArrayList<String> getListSongs() {
		//Convertir lista de songs a list de strings
		ArrayList<String> ret = new ArrayList<String>();
		List<Song> songs = controller.getSongs();
		for (Iterator<Song> it = songs.iterator(); it.hasNext(); ) {
			Song song = it.next();
			ret.add(song.getTitle() + " - " + song.getArtist());
		}
		return ret;
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
