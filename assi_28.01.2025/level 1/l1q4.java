import java.util.Scanner;
public class l1q4{
public static double calcperimeter(double a,double b,double c)
{
return (a+b+c)/5000;
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter all three sides");
double s1=sc.nextDouble();
double s2=sc.nextDouble();
double s3=sc.nextDouble();

double rounds=calcperimeter(s1,s2,s3);
System.out.println("Number of rounds are "+rounds);
}}
