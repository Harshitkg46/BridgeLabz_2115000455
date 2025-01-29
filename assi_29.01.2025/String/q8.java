import java.util.Scanner;
public class q8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();
		int result = compareStrings(str1, str2);
		if (result < 0) {
			System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
		} else if (result > 0) {
			System.out.println(str1 + " comes after " + str2 + " in lexicographical order");
		} else {
			System.out.println("Both strings are equal in lexicographical order");
		}
		scanner.close();
	}
	static int compareStrings(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		int minLen = Math.min(len1, len2);
		for (int i = 0; i < minLen; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return s1.charAt(i) - s2.charAt(i);
			}
		}
		return len1 - len2;
	}
}
