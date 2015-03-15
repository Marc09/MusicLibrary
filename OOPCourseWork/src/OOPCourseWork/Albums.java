package OOPCourseWork;
/**
 * 
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Albums implements Play{

	private String albumName;
	private String type;
	private String artist;
	private ArrayList<MusicTrack> albumList;
	
	public Albums(String albumName, String type, String artist){
		this.albumName = albumName;
		this.type = type;
		this.artist = artist;
		albumList=new ArrayList<MusicTrack>();
	}
	
	public Albums(String albumName, String type){
		this.albumName = albumName;
		this.type = type;
		albumList=new ArrayList<MusicTrack>();
	}
	
	public Albums(){
		
	}
	/**
	 * In defineAlbumList() method, I read all the data for the album from a text file
	 * @throws FileNotFoundException
	 */
	public void defineAlbumList(String albumName) throws FileNotFoundException{
		
		MusicTrack t1 = new MusicTrack("track1", "artist1", "20/10/2014", 175, 90, "H:\\", 5);
		MusicTrack t2 = new MusicTrack("track2", "artist2", "20/10/2014", 185, 70, "H:\\", 7);
		MusicTrack t3 = new MusicTrack("track3", "artist3", "20/10/2014", 195, 70, "H:\\", 8);
		MusicTrack t4 = new MusicTrack("track4", "artist4", "20/10/2014", 170, 90, "H:\\", 4);
		MusicTrack t5 = new MusicTrack("track5", "artist5", "20/10/2014", 175, 100, "H:\\", 11);
		MusicTrack t6 = new MusicTrack("track6", "artist6", "20/10/2014", 190, 80, "H:\\", 7);
		MusicTrack t7 = new MusicTrack("track7", "artist7", "20/10/2014", 180, 90, "H:\\", 6);
		MusicTrack t8 = new MusicTrack("track8", "artist8", "20/10/2014", 188, 95, "H:\\", 10);
		MusicTrack t9 = new MusicTrack("track9", "artist9", "20/10/2014", 179, 90, "H:\\", 13);
		MusicTrack t10 = new MusicTrack("track10", "artist10", "20/10/2014", 175, 70, "H:\\", 9);

		MusicTrack[] t = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10};
		for (int i = 0; i < 10; i++){
			this.albumList.add(t[i]);
		}
		for (MusicTrack track: albumList){
			track.setAlbumName(albumName);
		}
		
		/*
		 * uncomment this part and change path for the file
		 * then you can test reading from a file
		 *
		Scanner scanAlbum = new Scanner(new FileReader("D:\\album.txt"));
		while(scanAlbum.hasNextLine()){
			String al = scanAlbum.nextLine();
			String[] parts = al.split(",");
			albumList.add(new MusicTrack(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),parts[5],Integer.parseInt(parts[6])));
		}
		for (MusicTrack track: albumList){
			track.setAlbumName(albumName);
			track.setArtist(artist);
		}
		*/
		
	}
	
	public void listAlbumTracks(){
		for (MusicTrack track: this.albumList){
			System.out.println(track.getTitle());
		}
	}
	
	public void addToAlbum(MusicTrack track){
		this.albumList.add(track);
		track.setAlbumName(this.getAlbumName());
	}
	
	public void getOverallTime(){
		int overAllTime = 0;
		for(MusicTrack mt: albumList){
			overAllTime = overAllTime + mt.getLength();
		}
		int minute = overAllTime / 60;
		int seconds = overAllTime % 60;
		System.out.println("The over all time of the album is " + minute + " minutes and " + seconds + " seconds");
	}
	
	public int getOverallFileSize(){
		int overallFileSize = 0;
		for(MusicTrack mt: albumList){
			overallFileSize=overallFileSize + mt.getSize();
		}
		return overallFileSize;
	}

	public int getAverageRating(){
		int average = 0;
		int sum = 0;
		for(MusicTrack mt:albumList){
			sum = sum + mt.getRating();
		}
		average = sum / this.albumList.size();
		return average;
	}
	
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public ArrayList<MusicTrack> getAlbumList(){
		return albumList;
	}
	
	//play the whole album, and the play times counter in every track plus one
	public void play(){
		for (MusicTrack track: this.albumList){
			track.addPlayCount();
		}
	}
	
	public void playOneTrack(MusicTrack track){
		track.addPlayCount();
	}
	
	public void playSeveralTracks(int numberOfTracks){
		if (numberOfTracks < this.albumList.size()){
			for (int i = 0; i < numberOfTracks; i++){
				this.albumList.get(i).addPlayCount();
			}
		}
		System.out.println("There aren't that many tracks!");
		System.out.println("Try a number smaller than " + this.albumList.size());
	}
}
