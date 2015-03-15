package OOPCourseWork;
/**
 * MusicTrack class is aimed to provide the basic data type for the whole program
 * MusicTrack is like an album with only one track in it, so MusicTrack class should inherit Albums class
 * Write a description of class CompilationAlbum here.
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

public class MusicTrack extends Albums implements Play{
	
	private String title;
	private String artist;
	private String date;
	private int length;
	private int rating;
	private String location;
	private int size;
	
	private int count;
	private String guestArtist;
	private String compilAlbumName;
	
	public MusicTrack(String title, String artist, String date, int length, int rating, String location, int size){
		super();
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.length = length;
		this.rating = rating;
		this.location = location;
		this.size = size;
	}
	
	public MusicTrack(String albumName, String musicType, String title, String artist, String date, int length, int rating, String location, int size){
		super(albumName, musicType, artist);
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.length = length;
		this.rating = rating;
		this.location = location;
		this.size = size;
	}
	
	public void listMembersOnTheTrack(MusicTrack track){
		System.out.println("artist:" + track.getArtist());
		if (guestArtist != null){
			System.out.println(track.getGuestArtist());
		}
	}
	
	public void addGuestArtist(String name){
		this.guestArtist = name;
	}
	
	public void  addPlayCount(){
		count++;
	}
	
	public int getPlayCount(){
		return count;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date=date;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getGuestArtist() {
		return guestArtist;
	}

	public void play(){
		this.addPlayCount();
	}
	
	public void playOneTrack(MusicTrack track){
		track.addPlayCount();
	}
	
	public void playSeveralTracks(int numberOfTracks){
		System.out.println("This is only one track!");
	}

	public String getCompilAlbumName() {
		return compilAlbumName;
	}

	public void setCompilAlbumName(String compilAlbumName) {
		this.compilAlbumName = compilAlbumName;
	}
}
