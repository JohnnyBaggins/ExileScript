package charter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void printDecade(BufferedWriter output) throws IOException{
	    
			java.util.Collections.sort(albums, new AlbumComparator());
			output.write("The years "+yearStart+" to "+yearEnd+":\n");
			printSuperList(output);
			output.write("============================================\n");
			for (Year y : years){
				  y.printYear(output);
			}
	}
	private void printSuperList(BufferedWriter output) throws IOException {
		ArrayList<Album> superList = createSuperList();
		java.util.Collections.sort(superList, new AlbumComparator());
		int counter = 1;
		for (Album a : superList){
			output.write("Place "+counter+": "+a.artistName+" - "+a.albumName+" ("+a.count+")\n");
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
