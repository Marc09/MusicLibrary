package OOPCourseWork;
/**
 * Band class is the super class of Artists class
 * 
 * Two constructors are built in this class
 * 1: empty constructor is for soloist or if user wants to 
 * 	  create a new band(user need to call setBandName method to give the band a name)
 * 2: the second constructor is for artists who are in a band
 * 
 * User can display all band members by calling displayBandMembers
 * method with Band class 
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.util.ArrayList;

public class Band {
	
	private String bandName;
	private ArrayList<String> bandMembers;
	
	public Band(){
		
	}
	
	public Band(String bandName, String artist){
		this.bandName = bandName;
		bandMembers = new ArrayList<String>();
		bandMembers.add(artist);
	}
	
	public ArrayList<String> getAllBand(){
		return bandMembers;
	}
	
	public void addBandMember(String artist){
		bandMembers.add(artist);
	}
	
	public void displayBandMembers(){
		System.out.println("The band members are: ");
		for (String artist: bandMembers){
			System.out.println(artist);
		}
	}

	public String getBandName() {
		return bandName;
	}

	public void setName(String name) {
		this.bandName = name;
	}
}
