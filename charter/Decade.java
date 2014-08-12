package charter;

public class Decade extends AbstractTimePhase {

	int yearStart;
	int yearEnd;
	
	public Decade(int year){
		this.yearStart = year;
		this.yearEnd = year+9;
		
	}
	
	public void printDecade(){
		java.util.Collections.sort(albums, new AlbumComparator());
		System.out.println("The years "+yearStart+" to "+yearEnd+":");
		for (Album a : albums){
			System.out.println(a.artistName+" - "+a.albumName+" ("+a.count+")");
		}System.out.println("");
	}
}
