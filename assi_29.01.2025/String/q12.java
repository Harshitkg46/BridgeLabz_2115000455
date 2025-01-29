import java.util.*;
public class q12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		String oldWord = scanner.next();
		String newWord = scanner.next();
		String modifiedSentence = replaceWord(sentence, oldWord, newWord);
		System.out.println("Modified Sentence: " + modifiedSentence);
		scanner.close();
	}
	static String replaceWord(String sentence, String oldWord, String newWord) {
		return sentence.replace(oldWord, newWord);
	}
}
