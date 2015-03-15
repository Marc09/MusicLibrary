package OOPCourseWork;
/**
 * Interface Play helps MusicLibrary class, Albums class and MusicTrack class to 
 * refresh the number of how many times a track has been played
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

public interface Play {
	void play();
	void playOneTrack(MusicTrack track);
	void playSeveralTracks(int numberOfTracks);
}
