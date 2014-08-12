package charter;

public class Year extends AbstractTimePhase {
	
	int yearNumber;
	
	public Year(int year){
		this.yearNumber = year;
	}
	
	public void printYear(){
		java.util.Collections.sort(albums, new AlbumComparator());
		System.out.println("The year "+yearNumber+":");
		for (Album a : albums){
			System.out.println(a.artistName+" - "+a.albumName+" ("+a.count+")");
		}System.out.println("");
	}
	
	public int getYear(){
		return yearNumber;
	}
	
}
