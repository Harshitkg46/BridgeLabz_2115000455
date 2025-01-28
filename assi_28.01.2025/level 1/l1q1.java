import java.util.Scanner;
  public class l1q1{
  public static double simpleinterest(double principal, double rate,double time)
    {
     return (principal * rate * time)/100;
    }
  public static void main(String args[])
    {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the principal");
   double principal=sc.nextDouble();
   System.out.println("Enter Rate of Interest");
   double rate= sc.nextDouble();
   System.out.println("Enter Time");
   double time=sc.nextDouble();

   double simpleInterest=simpleinterest(principal,rate,time);
   System.out.println("The Simple Interest is "+simpleInterest+" for principal "+principal+" ,rate of interest "+rate+" ,time "+time);
}
}
