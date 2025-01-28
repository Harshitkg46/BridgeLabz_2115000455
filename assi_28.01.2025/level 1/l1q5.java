import java.util.Scanner;
public class l1q5{
public static int calc(int n)
{
if(n>0)
{ 
return 1;
}
else if(n<0){
return -1;
}
else{
return 0;}}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number");
int number=sc.nextInt();
int result=calc(number);
if(result==1){
System.out.println("Positive number");}
else if(result==-1){
System.out.println("Negative number");}
else{
System.out.println("Zero");
}
}
}

