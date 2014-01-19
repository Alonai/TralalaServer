package launcher;

import java.util.ArrayList;
import java.util.List;

import data.*;
import data.dao.DBItemDAO;

public class DBDataCreator {
	public static void main(String[]argv){
		ArrayList<Object>items=new ArrayList<Object>();
		Artist daftPunk=new Artist("Daft Punk");
		Album homework=new Album("Homework","17/01/1997");
		Song one=new Song("Daftendirekt", 164,"");
		Song two=new Song("WDPK 83.7 FM", 28,"");
		Song three=new Song("Revolution 909", 326,"");
		Song four=new Song("Da Funk", 328,"");
		Song five=new Song("Phoenix", 164,"");
		Song six=new Song("Fresh", 164,"");
		Song seven=new Song("Around the World", 164,"");
		Song eight=new Song("Rollin' & Scratchin'", 164,"");
		Song nine=new Song("Teachers", 164,"");
		Song ten=new Song("High Fidelity", 164,"");
		Song eleven=new Song("Rock'n Roll", 164,"");
		Song twelve=new Song("Oh Yeah", 164,"");
		Song thirteen=new Song("Burnin'", 164,"");
		Song fourteen=new Song("Indo Silver Club", 164,"");
		Song fifteen=new Song("Alive", 164,"");
		Song sixteen=new Song("Funk Ad", 164,"");
		items.add(one);
		items.add(two);
		items.add(three);
		items.add(four);
		items.add(five);
		items.add(six);
		items.add(seven);
		items.add(eight);
		items.add(nine);
		items.add(ten);
		items.add(eleven);
		items.add(twelve);
		items.add(thirteen);
		items.add(fourteen);
		items.add(fifteen);
		items.add(sixteen);
		for(Object song:items){
			daftPunk.addSong((Song)song);
			homework.addSong((Song)song);
			System.out.println(((Song)song).getArtist().getName()+" - "+((Song)song).getTitle());
		}
		items.add(daftPunk);
		items.add(homework);
		DBItemDAO dao=new DBItemDAO();
		for(Object o: items){
			dao.storeItem(o);
		}
		//dao.storeArtist(daftPunk);
		System.out.println("Getting list of songs...");
		List<Song> songs=dao.getSongs();
		/*for(Song song:songs){
			if(song!=null){
				if(song.getAlbum()!=null){
					System.out.println(song.getAlbum().getTitle()+" - "+song.getTitle());
				}else{
					System.out.println("Albums are null");
				}
			}else{
				System.out.println("songs are null");
			}
		}*/
		for(Song song:songs){
			if(song!=null){
				if(song.getArtist()!=null){
					System.out.println(song.getArtist().getName()+" - "+song.getTitle());
				}else{
					System.out.println("Artists are null");
				}
			}else{
				System.out.println("songs are null");
			}
		}
		/*List<Artist> artists=dao.getArtists();
		for(Artist artist: artists){
			System.out.println(artist.getName());
			for(Song song: artist.getSongs()){
				System.out.println(artist.getName()+" - "+song.getTitle());
			}
		}*/
	}
}
