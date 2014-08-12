package charter;

public class Album {
	String albumName;
	String artistName;
	int count;
	
	public Album(String artist, String album){
		albumName = album;
		artistName = artist;
		count = 1;
	}
	
	public void increaseCount(){
		System.out.println("Increased a count!");
		count++;
	}
	
	public String getAlbumName(){
		return albumName;
	}
	
	public String getArtistName(){
		return artistName;
	}
	
	public int getCount(){
		return count;
	}
	
	public boolean equalsToAlbum(Album compared){
		if (compared.getAlbumName().equals(this.albumName)){
			if (compared.getArtistName().equals(this.artistName)){
				return true;
			}
		}
		return false;
	}

}
