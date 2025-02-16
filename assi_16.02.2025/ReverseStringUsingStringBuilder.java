import java.util.*;
public class ReverseStringUsingStringBuilder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.print(helper(str));
		sc.close();
	}
	private static String helper(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = str.length() - 1 ; i >= 0 ; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
