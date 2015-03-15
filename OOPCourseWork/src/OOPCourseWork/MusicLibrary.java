
package OOPCourseWork;
/**
 * This MusicLibrary class stores all the tracks, and stores all objects as MusicTrack type;
 * 
 * In order to add albums and tracks to the MusicLibrary, I wrote 2 addToLibrary method;
 * 
 * After you store some tracks in the MusicLibrary, you can find out which tracks have the 
 * lowest ratings by calling method listLowestRating, you will get an output of every track with
 * the lowest rating in the library;
 * 
 * And you can back up all the track to disc by calling method backup;
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public class MusicLibrary implements Play{
	
	private ArrayList<MusicTrack> musicLibrary;
	private HashMap<MusicTrack, Integer> playTimeCounter;
	
	public MusicLibrary(){
		musicLibrary = new ArrayList<MusicTrack>();
		playTimeCounter = new HashMap<MusicTrack, Integer>();
	}
	//here I can read a number of count from the MusicTrack class for playTimes to store how many times the song has been played
	public void addToLibrary(Albums album){
		for (MusicTrack track: album.getAlbumList()){
			musicLibrary.add(track);
			playTimeCounter.put(track, track.getPlayCount());
		}
	}
	
	public void addToLibrary(MusicTrack track){
		musicLibrary.add(track);
		playTimeCounter.put(track, track.getPlayCount());
	}
	
	public void listAllMusicLibraryTracks(){
		for (MusicTrack track: this.musicLibrary){
			System.out.println(track.getTitle());
		}
	}
	
	/**
	 * each time the song has been played, the track's play counter add one, and it gives the value to HashMap playTimeCounter
	 * to store the value for that particular song
	 * @param track
	 */
	public void play(){
		for (MusicTrack track: this.musicLibrary){
			track.addPlayCount();
		}
	}
	
	public void playOneTrack(MusicTrack track){
		track.addPlayCount();
		playTimeCounter.put(track, track.getPlayCount());
	}
	
	public void playSeveralTracks(int numberOfTracks){
		if (numberOfTracks < this.musicLibrary.size()){
			for (int i = 0; i < numberOfTracks; i++){
				this.musicLibrary.get(i).addPlayCount();
			}
		}
		System.out.println("There aren't that many tracks!");
		System.out.println("Try a number smaller than " + this.musicLibrary.size());
	}
	
	public void listLowestRating(){
		int temp = musicLibrary.get(0).getRating();
		for (int i = 1; i < musicLibrary.size(); i++){
			if (musicLibrary.get(i).getRating() < temp){
				temp = musicLibrary.get(i).getRating();
			}
		}
		System.out.println("The lowest rating in the library is " + temp);
		System.out.println("The track(s) in the library with the lowest rating is(are): ");
		for (int j = 0; j < musicLibrary.size(); j++){
			if (musicLibrary.get(j).getRating() == temp){
				System.out.println(musicLibrary.get(j).getTitle());
			}
		}
	}
	
	//figure out the smallest number of discs possible to store all the tracks in the library
	public void backUp(int capasity, MusicLibrary m){
		Discs d = new Discs(capasity);
		d.getNewDisc(capasity);
		int leftCapasity = 0;
		int lastLeftCapasity = 10000;
		for (int i = 0; i < this.musicLibrary.size(); i++){
			//check if need to insert another disc
			int unAvailableDiscCounter = 0;
			for (int discNumber = 0; discNumber < d.getDisc().size(); discNumber++){
				leftCapasity = d.getDisc().get(discNumber).getCapasity();
				
				if (leftCapasity < m.musicLibrary.get(i).getSize()){
					unAvailableDiscCounter++;
				}
				if (unAvailableDiscCounter == d.getDisc().size()){
					d.getNewDisc(capasity);
					leftCapasity = capasity;
				}
			}
			//check which one of the discs have the most suitable room left, after insert, the left capasity should be smaller than other discs
			for (int discNumber = 0; discNumber < d.getDisc().size(); discNumber++){
				leftCapasity = d.getDisc().get(discNumber).getCapasity();
				if(leftCapasity > m.musicLibrary.get(i).getSize() && leftCapasity < lastLeftCapasity){
					lastLeftCapasity = leftCapasity;
					d.getDisc().get(discNumber).setCapasity(leftCapasity - m.musicLibrary.get(i).getSize());
				}
			}
			for (int discNumber = 0; discNumber < d.getDisc().size(); discNumber++){
				if (d.getDisc().get(discNumber).getCapasity() == lastLeftCapasity){
					d.getBackUpDisc().add(m.musicLibrary.get(i));
					d.getDisc().get(discNumber).setCapasity(leftCapasity - m.musicLibrary.get(i).getSize());
				}
			}
		
		}
		System.out.println("A small number of discs to back up all the tracks in my library is: " + d.getDisc().size());
	}
	
	public ArrayList<MusicTrack> getMusicLibraryList(){
		return this.musicLibrary;
	}
	
}
