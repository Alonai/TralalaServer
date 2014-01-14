package server;

import java.util.ArrayList;

import data.Member;
import data.Play;
import data.Song;

public abstract class EPaymentMethod implements IPaymentService{

	/** Returns the amount of money that the member has to play.
	 * @param m : Member
	 * @return double : amount of money.
	 */
	public double currentAmount(Member m) {
		
		double amount = 0;
		
		//Gets user's playList
		ArrayList<Play> playList = m.getPlayList();
		//Processes all the plays of the member.
		for(int i = 0; i < playList.size(); i++) {
			//Gets the song of the current play.
			Song song = playList.get(i).getSong();
			//Adds the price per play to the current amount.
			amount += song.getPPP();
		}
		//returns the amount of all the songs.
		return amount;
	}
	
	public abstract void pay(Member m);
	
}