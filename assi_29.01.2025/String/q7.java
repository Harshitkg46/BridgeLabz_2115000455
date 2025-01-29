import java.util.Scanner;
public class q7 {
   public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
	String str = scanner.next();
System.out.println(toggleCase(str));
       scanner.close();
   }
   static String toggleCase(String str) {
       char[] chars = str.toCharArray();
       for (int i = 0; i < chars.length; i++) {
           if (chars[i] >= 'A' && chars[i] <= 'Z') {
               chars[i] = (char) (chars[i] + 32);
           } else if (chars[i] >= 'a' && chars[i] <= 'z') {
               chars[i] = (char) (chars[i] - 32);
           }
       }
       return new String(chars);
    }
}
