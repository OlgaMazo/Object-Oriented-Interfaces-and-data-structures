/**
 * This class include main function that print some details about the text.
 * @author Daniel and Olga
 */
public class TestBet {

	public static void main(String[] args) {

		Text tested_text3 = new Text();
		tested_text3.readFile("src//text3.txt");
		
		System.out.println("text3 report:");
		System.out.println("The Number of Differnt Words: " + tested_text3.num_of_differnt_words());
		System.out.println("The Number of Words: " + tested_text3.num_of_words());
		System.out.println("The Most Frequent Word: (" + tested_text3.most_frequent_word().get_word() + "), frequenncy: "
				+ tested_text3.most_frequent_word().get_appears());
		System.out.println("The Longest Word: (" + tested_text3.most_long_word().get_word() + ")");
		
		System.out.println("\n--------------------------\n");
		
		Text tested_text1 = new Text();
		tested_text1.readFile("src//text1.txt");
		System.out.println("text1 report:");
		System.out.println("The Number of Differnt Words: " + tested_text1.num_of_differnt_words());
		System.out.println("The Number of Words: " + tested_text1.num_of_words());
		System.out.println("The Most Frequent Word: (" + tested_text1.most_frequent_word().get_word() + "), frequenncy: "
				+ tested_text1.most_frequent_word().get_appears());
		System.out.println("The Longest Word: (" + tested_text1.most_long_word().get_word() + ")");
	}
}