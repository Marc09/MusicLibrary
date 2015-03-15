package OOPCourseWork;
/**
 * This class is designed to help solving the music library back up problem(bin packing)
 *
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Discs {
	private ArrayList<Discs> disc;
	private int capasity;
	private ArrayList<MusicTrack> backUpDisc;
	
	public Discs(int capacity){
		this.capasity = capacity;
		disc = new ArrayList<Discs>();
		backUpDisc = new ArrayList<MusicTrack>();
	}
	
	public void addTrack(MusicTrack track){
		this.backUpDisc.add(track);
	}
	
	public void getNewDisc(int capasity){
		Discs d = new Discs(capasity);
		this.disc.add(d);
	}

	public int getCapasity() {
		return capasity;
	}

	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}
	
	public ArrayList<Discs> getDisc(){
		return disc;
	}
	
	public ArrayList<MusicTrack> getBackUpDisc(){
		return backUpDisc;
	}
	
}
