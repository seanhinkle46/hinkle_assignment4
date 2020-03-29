//Sean Hinkle, Dr. Hollander, COP3330
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {
	//instance variables
	Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile) {
		//some structure and map use inspired by figure 16.17 in textbook
		
		//initiate scanner and open file in the try with resources block
		try(Scanner input = new Scanner(Paths.get(dataFile))) {
			while (input.hasNext()) {
				//gets next string from file, turns it lower case so we do not consider case
				String next = input.next().toLowerCase();
				if (wordCounter.containsKey(next)) {
					//if word is already present, increases the count by 1 for that word
					int current = wordCounter.get(next);
					wordCounter.put(next, current + 1);
				} else wordCounter.put(next, 1);
			}
		} catch (IOException e) {
			System.err.println("There was an issue with the file opening");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.err.println("There was an unexpected exception, " + e.getClass());
			e.printStackTrace();
			System.exit(0);
		}	
	}
	
	public void write(String outputFile) {
		//creates formatter and opens file in try with resources block
		try (Formatter output = new Formatter(outputFile)) {
			//keySet returns the keys (words) from the map as a Set
			Set<String> words = wordCounter.keySet();
			output.format("%-15s%15s%n%n", "Key", "Count");
			for (String s : words) {
				output.format("%-15s%15d%n", s, wordCounter.get(s));
			}
		} catch (FileNotFoundException e) {
			System.err.println("There was an issue opening/creating the file");
			e.printStackTrace();
			System.exit(0);
		} catch (FormatterClosedException e) {
			System.err.println("The formatter unexpectedly closed");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.err.println("There was an unexpected exception, " + e.getClass());
			e.printStackTrace();
			System.exit(0);
		}
	}
}