import java.util.Scanner;
   public class q5
{
  public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter a String");
   String str=sc.nextLine();
   String word="";
   String longestword="";
   str=str.trim();
   str=str+" ";
   for(int i=0;i<str.length();i++)
{
    if(str.charAt(i)==' ')
    {
    if(word.length()>longestword.length())
{
longestword=word;
}
word="";
}
word=word+str.charAt(i);
}
System.out.println("Longest word "+longestword);
}}

   
    

