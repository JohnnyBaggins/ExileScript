package charter;

import java.util.ArrayList;
import java.util.Comparator;

public class Decade {
	
	ArrayList<Album> albums;
	int yearStart;
	int yearEnd;
	
	public Decade(int year){
		this.yearStart = year;
		this.yearEnd = year+9;
		albums = new ArrayList<Album>();
	}
	
	public void addAlbum(Album newAlbum){
		if (!isAlreadyInTheYear(newAlbum)){
			albums.add(newAlbum);
		}
	}
	
	private boolean isAlreadyInTheYear(Album check){
		for (Album a : albums){
			if (a.equalsToAlbum(check)){
				a.increaseCount();
				return true;
			}
		}
		return false;
	}
	
	public void printDecade(){
		java.util.Collections.sort(albums, new AlbumComparator());
		System.out.println("The years "+yearStart+" to "+yearEnd+":");
		for (Album a : albums){
			System.out.println(a.artistName+" - "+a.albumName+" ("+a.count+")");
		}System.out.println("");
	}

	public class AlbumComparator implements Comparator<Album> {
	    @Override
	    public int compare(Album a1, Album a2) {
	        if (a1.getCount() < a2.getCount()){
	        	return 1;
	        }
	        if (a1.getCount() > a2.getCount()){
	        	return -1;
	        }
	        else{
	        	int artistCompare = a1.getArtistName().compareTo(a2.getArtistName());
	        	if (artistCompare != 0){
	        		return artistCompare;
	        	}else{
	        		return a1.getAlbumName().compareTo(a2.getAlbumName());
	        	}
	        }
	    }
	}
}
