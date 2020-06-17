import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * This class represents a text object by array list of words.
 * Supports several operations on text objects.
 * @author Daniel and Olga.
 */
public class Text {

	private static ArrayList<Word> arr;

	/**
	 * Text
	 * Text constructor.
	 */
	public Text() {
		arr = new ArrayList<Word>();
	}

	/**
	 * readFile
	 * Read the file.
	 * @param fileName - the file name
	 */
	public static void readFile(String fileName) {

		try { // try read from the file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			read_line(str);
			for (int i = 1; str != null; i = i + 1) {
				str = br.readLine();
				if (str != null) {
					read_line(str);
				}
			}
			br.close();
		}
		catch (IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}

	/**
	 * read_line
	 * Read line from the text.
	 * @param line - the line
	 */
	private static void read_line(String line) {
		String delim = "/-().;:, ";
		StringTokenizer tok = new StringTokenizer(line, delim);
		while (tok.hasMoreTokens()) {
			String tmp = tok.nextToken();
			read_word(tmp);
		}
	}

	/**
	 * read_word
	 * Read word from the text.
	 * @param word - the word
	 */
	private static void read_word(String word) {

		boolean isExist = false;

		Iterator<Word> iter = arr.iterator();
		while (iter.hasNext() & !isExist) {
			Word w = iter.next();

			if (w.get_word().equals(word)) {
				w.update_appears();
				isExist = true;
			}
		}
		if (!isExist) {
			Word newWord = new Word(word);
			arr.add(newWord);
		}
	}

	/**
	 * num_of_words
	 * Calculates the amount of words in the text.
	 * @return - the amount of words in the text
	 */
	public int num_of_words() {

		int counter = 0;

		//go over all the words in the array list and sum the number of times each word appears.
		Iterator<Word> iter = arr.iterator();
		while (iter.hasNext()) {
			Word w = iter.next();
			counter = counter + w.get_appears();
		}
		return counter;
	}

	/**
	 * num_of_differnt_words
	 * Calculates the amount of the different words in the text.
	 * @return - the amount of the different words in the text
	 */
	public int num_of_differnt_words() {
		return arr.size();
	}

	/**
	 * most_frequent_word
	 * Search the word that repeated most often in the text.
	 * @return - the most frequent word
	 */
	public Word most_frequent_word() {

		//set the first word in the array as the most frequent word
		Word most = arr.get(0);

		//go over all the words in the array list
		Iterator<Word> iter = arr.iterator();
		while (iter.hasNext()) {
			Word w = iter.next();

			//if the current word appear more times than the most word then set it as the most frequent word
			if (most.get_appears() < w.get_appears()) {
				most = w;
			}
		}
		return most;
	}

	/**
	 * most_long_word
	 * Search for the longest word in the text.
	 * @return - the most long word
	 */
	public Word most_long_word() {

		//set the first word in the array as the most long word
		Word most = arr.get(0);

		//go over all the words in the array list
		Iterator<Word> iter = arr.iterator();
		while (iter.hasNext()) {
			Word w = iter.next();

			//if the current word is longer then set it to be the longest word in the text
			if (most.get_length() < w.get_length()) {
				most = w;
			}
		}
		return most;
	}
}