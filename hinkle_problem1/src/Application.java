
public class Application {
	public static void main(String[] args) {
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove("problem1.txt");
//		for(String e : duplicateRemover.uniqueWords) {
//			System.out.println(e);
//		}
		duplicateRemover.write("unique_words.txt");
	}
}