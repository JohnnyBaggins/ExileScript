package charter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private Path path;
	private final static Charset ENCODING = StandardCharsets.UTF_8; 
	private static ArrayList<Decade> decades;
	
	public static void main(String... aArgs) throws IOException {
		Parser p = new Parser();
		p.openFile("C:\\Users\\Jo\\Desktop\\hello.txt");
		p.processLineByLine();
		
		for (Decade d : decades){
			d.printDecade();
		}
	}
	
	public void openFile(String path){
		decades = new ArrayList<Decade>();
		this.path = Paths.get(path);
	}
	
	public void processLineByLine() throws IOException {
		try{
			Scanner scanner =  new Scanner(path, ENCODING.name());
			while (scanner.hasNextLine()){
		        processLine(scanner.nextLine());
		      }  
		}finally{
			
		}
	}
	
	private void processLine(String inLine){
		String[] splitted = inLine.split("-");
		if (splitted.length > 1){
			processAlbum(splitted[0],splitted[1]);
		}else{
			if (!splitted[0].isEmpty()){
				processYear(splitted[0]);
			}
		}
	}
	
	private void processAlbum(String artistName, String albumName){
		Album newAlbum = new Album(artistName,albumName);	
		decades.get(decades.size()-1).addAlbum(newAlbum);
		
	}
	
	private void processYear(String year){
		int decadeValue = Integer.parseInt(year);
		Decade decade = new Decade(decadeValue);
		decades.add(decade);
	}
	
	
	
}
