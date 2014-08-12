package charter;

import java.io.BufferedWriter;
import java.io.IOException;

public class Year extends AbstractTimePhase {
	
	int yearNumber;
	
	public Year(int year){
		this.yearNumber = year;
	}
	
	public void printYear(BufferedWriter output) throws IOException {
		java.util.Collections.sort(albums, new AlbumComparator());
		output.write("The year "+yearNumber+":\n");
		for (Album a : albums){
			output.write(a.artistName+" - "+a.albumName+" ("+a.count+")\n");
		}output.write("\n");
	}
	
	public int getYear(){
		return yearNumber;
	}
	
}
