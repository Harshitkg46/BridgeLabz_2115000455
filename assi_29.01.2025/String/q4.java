import java.util.Scanner;
   public class q4
{
  public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter a String");
   String str=sc.nextLine();
   String result="";
   char ch;
   for(int i=0;i<str.length();i++)
{
    ch=str.charAt(i);
    if(result.indexOf(ch)==-1){
    result=result+ch;
}}
    System.out.println("Result "+result);
}}
