package OOPCourseWork;
/**
 * Test class is designed to test all the functions in the program
 * 
 * There are two ways to initialize an album in my code
 * 1:create an object of Albums class, and call the defineAlbumList method which read 
 *   from a file that contains all the information needed (original way)
 * 2:create several objects of MusicTrack class, and add them one by one to an album
 * 
 * for the convenience of testing, I'm going to modify my defineAlbumList method so that it contains the two ways above
 * 
 * @author (Yihui Zhang) 
 * @version (24/10/2014)
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		System.out.println("Artists and Band class funtions testing");
//		Artists ar = new Artists("Marc", "New York");
//		if (ar.getBandName() != null){
//			System.out.println("Please enter how many members are the band besides the artist: ");
//			Scanner scan = new Scanner(System.in);
//			int otherBandMemberNumber = scan.nextInt();
//			for (int i = 0; i < otherBandMemberNumber; i++){
//				System.out.println("Please enter the band member's name: ");
//				Scanner s = new Scanner(System.in);
//				String bandMemberName = s.next();
//				ar.addBandMember(bandMemberName);
//			}
//			System.out.println("Display all members on the band " + ar.getBandName() + ": ");
//			ar.displayBandMembers();
//		}
		System.out.println();

		System.out.println("Albums, CompilationAlbum and MusicTrack class funtions testing");
		Albums album1=new Albums("Album1","rock");
		//when defineAlbumList, give a name of the album to every single track in the album, implement by the method in Album Class
		album1.defineAlbumList("Album1");
		album1.setArtist(album1.getAlbumList().get(0).getArtist());
		System.out.println("The average rating of the tracks in the album is : " + album1.getAverageRating());
		System.out.println("The overall file size of the album is : " + album1.getOverallFileSize());
		//System.out.println("The overall time of the album is : " + album1.getOverallTime());
		album1.getOverallTime();
		System.out.println("The artist of the album is :" + album1.getArtist());
		System.out.println();

		//create three new albums for testing
		Albums album2 = new Albums("Album2","pop");
		MusicTrack t11 = new MusicTrack("track11", "artist2", "20/10/2014", 175, 90, "H:\\", 5);
		MusicTrack t12 = new MusicTrack("track12", "artist2", "20/10/2014", 185, 70, "H:\\", 7);
		MusicTrack t13 = new MusicTrack("track13", "artist2", "20/10/2014", 195, 70, "H:\\", 8);
		album2.addToAlbum(t11);
		album2.addToAlbum(t12);
		album2.addToAlbum(t13);
		
		Albums album3 = new Albums("Album3","hip-hop");
		MusicTrack t14 = new MusicTrack("track14", "artist3", "20/10/2014", 170, 90, "H:\\", 4);
		MusicTrack t15 = new MusicTrack("track15", "artist3", "20/10/2014", 175, 100, "H:\\", 7);
		MusicTrack t16 = new MusicTrack("track16", "artist3", "20/10/2014", 190, 80, "H:\\", 11);
		album3.addToAlbum(t14);
		album3.addToAlbum(t15);
		album3.addToAlbum(t16);

		Albums album4 = new Albums("Album4","electronic");
		MusicTrack t17 = new MusicTrack("track17", "artist4", "20/10/2014", 180, 90, "H:\\", 3);
		MusicTrack t18 = new MusicTrack("track18", "artist4", "20/10/2014", 188, 95, "H:\\", 11);
		MusicTrack t19 = new MusicTrack("track19", "artist4", "20/10/2014", 179, 90, "H:\\", 13);
		MusicTrack t20 = new MusicTrack("track20", "artist4", "20/10/2014", 175, 70, "H:\\", 9);
		album4.addToAlbum(t17);
		album4.addToAlbum(t18);
		album4.addToAlbum(t19);
		album4.addToAlbum(t20);

		//test CompilationAlbum class if it can provide the oringinal album name and the compilation album name
		CompilationAlbum compil1 = new CompilationAlbum("compil1", "mix");
		compil1.addToCompilAlbum(album1.getAlbumList().get(0));
		compil1.addToCompilAlbum(album2.getAlbumList().get(0));
		compil1.addToCompilAlbum(album3.getAlbumList().get(0));
		compil1.addToCompilAlbum(album4.getAlbumList().get(0));
		compil1.addToCompilAlbum(album1.getAlbumList().get(5));
		System.out.println("Here are the tracks in the compil1 album and their original album and their comilation album name: ");
		for (MusicTrack track: compil1.getAlbumList()){
			System.out.println("Title: " + track.getTitle());
			System.out.println("Original: " + track.getAlbumName());
			System.out.println("Compilation: " + track.getCompilAlbumName());
			System.out.println();
		}
		
		//testing music library
		System.out.println("MusicLibrary class funtions testing");
		MusicLibrary library = new MusicLibrary();
		MusicTrack t21 = new MusicTrack("track21", "artist5", "20/10/2014", 185, 70, "H:\\", 10);
		library.addToLibrary(t21);
		library.addToLibrary(album1);
		library.addToLibrary(album2);
		library.addToLibrary(album3);
		library.addToLibrary(album4);
		library.listLowestRating();
		System.out.println("Title: " + library.getMusicLibraryList().get(0).getTitle());
		System.out.println("Played times: " + library.getMusicLibraryList().get(0).getPlayCount());
		library.playOneTrack(library.getMusicLibraryList().get(0));
		System.out.println("Played times after it has been played another time: " + library.getMusicLibraryList().get(0).getPlayCount());
		MusicLibrary newlibrary = new MusicLibrary();
		newlibrary.addToLibrary(album4);
		System.out.println("display track size of album3 and album4: ");
		for (MusicTrack track: newlibrary.getMusicLibraryList()){
			System.out.println(track.getSize());
		}
		newlibrary.backUp(20, newlibrary);
	}
}
