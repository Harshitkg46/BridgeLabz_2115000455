import java.util.*;
public class q5 {
   // TODO Auto-generated method stub
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println(isPalindrome(scanner.next()) ? "Palindrome" : "Not Palindrome");
       scanner.close();
   }
   static boolean isPalindrome(String s) {
       int l = 0, r = s.length() - 1;
       while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
       return true;
   }
}
