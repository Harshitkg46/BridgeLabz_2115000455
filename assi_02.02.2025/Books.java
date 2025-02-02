import java.util.*;
public class Books{
     String title;
     String author;
     int price;
     public Books(String title, String author, int price){//parametrized
          this.title=title;
          this.author=author;
          this.price=price;
     }
     public Books(){//default
          this.title="Unknown";
          this.author="Unknown";
          this.price=0;
     }
     public String getTitle(){
          return title;
     }
     public String getAuthor(){
          return author;
     }
     public int getPrice(){
          return price;
     }
     public void setTitle(String title){
          this.title=title;
     }
      public void setAuthor(String author){
          this.author=author;
     }
      public void setPrice(int price){
          this.price=price;
     }
     public void display(){
          System.out.println("Title of the book is "+title);
          System.out.println("Author of the book is "+author);
          System.out.println("Price of the book is "+price);
     }
     public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         Books book=new Books();
         System.out.println("Enter the book title:");
         String title=sc.nextLine();
         System.out.println("Enter the author's name:");
         String author=sc.nextLine();
         System.out.println("Enter the price");
         int price=sc.nextInt();
         Books book1=new Books(title, author, price);
         book.display();
         book1.display();
     }
}

