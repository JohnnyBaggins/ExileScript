package charter;

import java.util.ArrayList;

public class Decade extends AbstractTimePhase {

	private int yearStart;
	private int yearEnd;
	private ArrayList<Year> years;
	
	public Decade(int year){
		years = new ArrayList<Year>();
		this.yearStart = (year/10)*10;
		this.yearEnd = yearStart+9;
	}
	
	public boolean yearBelongsIntoDecade(Year year){
		int yearValue = year.getYear()/10;
		yearValue *= 10;
		if (yearValue == yearStart){
			return true;
		}
		return false;
	}
	
	public void addYear(Year year){
		years.add(year);
	}
	
	public void addAlbum(Album album){
		years.get(years.size()-1).addAlbum(album);
	}
	
	public void printDecade(){
		java.util.Collections.sort(albums, new AlbumComparator());
		System.out.println("The years "+yearStart+" to "+yearEnd+":");
		printSuperList();
		System.out.println("============================================");
		for (Year y : years){
			y.printYear();
		}
	}
	
	private void printSuperList(){
		ArrayList<Album> superList = createSuperList();
		java.util.Collections.sort(superList, new AlbumComparator());
		int counter = 1;
		for (Album a : superList){
			System.out.println("Place "+counter+": "+a.artistName+" - "+a.albumName+" ("+a.count+")");
			counter++;
			if (counter == 11){
				break;
			}
		}
	}
	
	private ArrayList<Album> createSuperList(){
		ArrayList<Album> superList = new ArrayList<Album>();
		for (Year y : years){
			for (Album a : y.getAlbums()){
				superList.add(a);
			}
		}
		return superList;
	}
}
