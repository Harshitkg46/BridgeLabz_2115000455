import java.util.Scanner;
   public class q1
{
  public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter a String");
   String str=sc.nextLine();
   str=str.toUpperCase();
   int v=0,c=0;
char ch;
   for(int i=0;i<str.length();i++)
    {
    ch=str.charAt(i);
 if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
{
v++;}
else
c++;
}
System.out.println("Vowels= "+v+" and Consonents are "+c);
}}

