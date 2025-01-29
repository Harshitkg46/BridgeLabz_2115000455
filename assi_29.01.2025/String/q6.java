import java.util.Scanner;
public class q6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String wholeString = scanner.nextLine();
       String substring = scanner.next();
       int count = countOccurrences(wholeString, substring);
       System.out.println("Occurrences: " + count);
       scanner.close();
   }
   static int countOccurrences(String wholeString, String substring) {
       int count = 0;
       int index = 0;
       while ((index = wholeString.indexOf(substring, index)) != -1) {
           count++;
           index += substring.length();
       }
       return count;
	}
}
