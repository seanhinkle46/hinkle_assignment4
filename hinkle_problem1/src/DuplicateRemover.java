import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;



public class DuplicateRemover {
	//instance variable uniqueWords
	ArrayList<String> uniqueWords = new ArrayList<String>();
	
	public void remove(String dataFile) {
		try(Scanner input = new Scanner(Paths.get(dataFile))) {
			while(input.hasNext()) {
				String next = input.next();
				if(!uniqueWords.contains(next)) {
					uniqueWords.add(next);
				}
			}
		} catch (IOException e) {
			System.err.print("There was an issue with the file opening");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void write(String outputFile) {
		try(Formatter output = new Formatter("unique_words.txt")) {
			for(String s : uniqueWords) {
				output.format("%s ", s);
			}
			//Do i need to manually output the end of file character?
		} catch (FileNotFoundException e) {
			System.err.print("The file was not found/not able top be created");
			e.printStackTrace();
			System.exit(0);
		} catch (FormatterClosedException e ) {
			System.err.print("The Formatter was closed at some point during execution");
			e.printStackTrace();
			System.exit(0);
		}
	}
}