
import java.util.Scanner;
class Book {
   public String ISBN;
   protected String title;
   private String author;
   public Book(String ISBN, String title, String author) {
       this.ISBN = ISBN;
       this.title = title;
       this.author = author;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public String getAuthor() {
       return author;
   }
}

class EBook extends Book {
   public EBook(String ISBN, String title, String author) {
       super(ISBN, title, author);
   }

   public void displayDetails() {
       System.out.println("ISBN: " + ISBN);
       System.out.println("Title: " + title);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter ISBN: ");
       String ISBN = sc.nextLine();
       System.out.print("Enter Title: ");
       String title = sc.nextLine();
       System.out.print("Enter Author: ");
       String author = sc.nextLine();
       EBook ebook = new EBook(ISBN, title, author);
       ebook.displayDetails();
       System.out.println("Author: " + ebook.getAuthor());
   }
}

