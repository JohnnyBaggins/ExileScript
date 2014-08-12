package charter;

import java.util.ArrayList;

public class AbstractTimePhase {
	
	ArrayList<Album> albums;
	
	public AbstractTimePhase(){
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

}
