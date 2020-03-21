import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.Set;



public class DuplicateRemover {
	//instance variable uniqueWords
	//ArrayList<String> uniqueWords = new ArrayList<String>();
	Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) {
		try(Scanner input = new Scanner(Paths.get(dataFile))) {
			while(input.hasNext()) {
				//Scans in the next string, adds it to the set as a lower case
				//So that the set checks if there are duplicates, including differences in capitalization
				String next = input.next();
				uniqueWords.add(next.toLowerCase());
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