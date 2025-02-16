import java.util.*;
public class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.print(helper(str));
		sc.close();
	}
	private static String helper(String str) {
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<Character>();
		for(char ch : str.toCharArray()) {
			if(!set.contains(ch)) {
				sb.append(ch);
				set.add(ch);
			}
		}
		return sb.toString();
	}
}
