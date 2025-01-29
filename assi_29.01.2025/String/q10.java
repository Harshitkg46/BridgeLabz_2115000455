import java.util.Scanner;
public class q10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char toRemove = scanner.next().charAt(0);
		String modified = removeChar(input, toRemove);
		System.out.println("Modified String: " + modified);
		scanner.close();
	}
	static String removeChar(String str, char ch) {
		StringBuilder result = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c != ch) {
				result.append(c);
			}
		}
		return result.toString();
	}
}
