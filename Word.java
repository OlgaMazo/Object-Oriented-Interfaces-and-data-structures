/**
 * This class represents a word object.
 * Supports several operations on word objects.
 * @author Daniel and Olga.
 */
public class Word {
	
	private String word = ""; //word content
	private int appears = 0; //number of times the word appears
	private int length = 0; //word length
	
	/**
	 * Word
	 * Word constructor.
	 * @param word - the word content
	 */
	public Word (String word) {
		this.word = word;
		appears = 1;
		length = word.length();
	}
	
	/**
	 * get_word
	 * @return - the word content
	 */
	public String get_word() {
		return word;
	}
	
	/**
	 * get_appears
	 * @return - the number of times the word appears
	 */
	public int get_appears() {
		return appears;
	}
	
	/**
	 * get_length
	 * @return - the word length
	 */
	public int get_length() {
		return length;
	}
	
	/**
	 * update_appears
	 * Increase the number of times the word appears in one.
	 */
	public void update_appears () {
		appears++;
	}
}