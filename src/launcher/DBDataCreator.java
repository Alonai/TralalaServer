package launcher;

import java.util.ArrayList;
import java.util.List;

import data.*;
import data.dao.DBItemDAO;

public class DBDataCreator {
	public static void main(String[]argv){
		ArrayList<DBItem>items=new ArrayList<DBItem>();
		Artist daftPunk=new Artist("AR0001","Daft Punk");
		Album homework=new Album("AL0001","Homework","17/01/1997");
		Song one=new Song("S0001", "Daftendirekt", 164);
		Song two=new Song("S0002", "WDPK 83.7 FM", 28);
		Song three=new Song("S0003","Revolution 909", 326);
		Song four=new Song("S0004", "Da Funk", 328);
		Song five=new Song("S0005", "Phoenix", 164);
		Song six=new Song("S0006", "Fresh", 164);
		Song seven=new Song("S0007", "Around the World", 164);
		Song eight=new Song("S0008", "Rollin' & Scratchin'", 164);
		Song nine=new Song("S0009", "Teachers", 164);
		Song ten=new Song("S0010", "High Fidelity", 164);
		Song eleven=new Song("S0011", "Rock'n Roll", 164);
		Song twelve=new Song("S0012", "Oh Yeah", 164);
		Song thirteen=new Song("S0013", "Burnin'", 164);
		Song fourteen=new Song("S0014", "Indo Silver Club", 164);
		Song fifteen=new Song("S0015", "Alive", 164);
		Song sixteen=new Song("S0016", "Funk Ad", 164);
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
		for(DBItem song:items){
			daftPunk.addSong((Song)song);
			homework.addSong((Song)song);
			System.out.println(((Song)song).getArtist().getName()+" - "+((Song)song).getTitle());
		}
		items.add(daftPunk);
		items.add(homework);
		DBItemDAO dao=new DBItemDAO();
		dao.storeArtist(daftPunk);
		System.out.println("Getting list of songs...");
		List<Song> songs=dao.getSongs();
		for(Song song:songs){
			if(song!=null){
				if(song.getArtist()!=null){
					System.out.println(song.getArtist().getName()+" - "+song.getTitle());
				}else{
					System.out.println("artists are null");
				}
			}else{
				System.out.println("songs are null");
			}
		}
	}
}
