package OOPCourseWork;
/**
 * Artists class provide information about artists
 * 
 * if the artist is a soloist, call the first constructor with no parameter for the bandName
 * else if the artist is on a band, provide the band name in initialization
 * and in main method, if band name isn't null, the user will need to enter how many members 
 * are there besides the artist and enter their names one by one 
 * 
 * Because Artists class inherits Band class, an Artists class object will be able to call a
 * method from Band class, this way, if the artist is on the Band, the user can use a Artists
 * class object to call the method in Band class immediately without the need to create a new 
 * Band class object
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

public class Artists extends Band {
	
	private String artistName;
	
	public Artists(String artistName){
		this.artistName = artistName;
	}
	
	public Artists(String artistName, String bandName){
		super(bandName, artistName);
		this.artistName = artistName;
		
	}
	
	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String name) {
		this.artistName = name;
	}
}
