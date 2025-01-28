import java.util.Scanner;
 public class l1q2{
 public static int calchandshakes(int n)
{
 return (n*(n-1))/2;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of students");
int student=sc.nextInt();
int handshake=calchandshakes(student);
System.out.println("Handshakes "+handshake);
}}

