import java.util.Scanner;
public class q9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		char mostFrequent = findMostFrequentChar(input);
		System.out.println("Most Frequent Character: " + mostFrequent);
		scanner.close();
	}
	static char findMostFrequentChar(String str) {
		int[] freq = new int[256];
		int maxFreq = 0;
		char result = ' ';
		for (char ch : str.toCharArray()) {
			freq[ch]++;
			if (freq[ch] > maxFreq) {
				maxFreq = freq[ch];
				result = ch;
			}
		}
		return result;
	}
}
