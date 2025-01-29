import java.util.*;
public class q11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();
		boolean isAnagram = checkAnagram(str1, str2);
		System.out.println(isAnagram ? "Anagrams" : "Not Anagrams");
		scanner.close();
	}
	static boolean checkAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}
}
