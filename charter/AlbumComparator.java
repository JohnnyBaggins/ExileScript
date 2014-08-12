package charter;

import java.util.Comparator;

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