import java.util.Scanner;
 public class l1q3{
 public static int calchandshakes(int n)
{
 return (n*(n-1))/2;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter number of students");
int numberOfStudents=sc.nextInt();
int handshake=calchandshakes(numberOfStudents);
System.out.println("Handshakes "+handshake);
}}

