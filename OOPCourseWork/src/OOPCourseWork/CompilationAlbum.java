package OOPCourseWork;
/**
 * CompilationAlbum is a class for tracks from different albums
 * 
 * CompilationAlbum inherits Albums class and implements Play interface 
 * to keep counting how many times a track have been played
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.util.ArrayList;

public class CompilationAlbum extends Albums implements Play{
		
	public CompilationAlbum(String name, String type){
		super(name, type);
	}
	
	public void addToCompilAlbum(MusicTrack track){
		this.getAlbumList().add(track);
		track.setCompilAlbumName(this.getAlbumName());
	}
	
	public void listAllArtist(){
		System.out.println("All artists on the compilation album: ");
		for (MusicTrack track: this.getAlbumList()){
			System.out.println(track.getArtist());
		}
	}
	
	public ArrayList<MusicTrack> getCompilAlbumList() {
		return this.getAlbumList();
	}
	
	public String getOriginalAlbumName(MusicTrack track){
		return track.getAlbumName();
	}
	
	public void play(){
		for (MusicTrack track: this.getAlbumList()){
			track.addPlayCount();
		}
	}
	
	public void playOneTrack(MusicTrack track){
		track.addPlayCount();
	}
	
	public void playSeveralTracks(int numberOfTracks){
		for (int i = 0; i < numberOfTracks; i++){
			this.getAlbumList().get(i).addPlayCount();
		}
	}
}
