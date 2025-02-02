import java.util.Scanner;
class Library{
   String title;
   String author;
   double price;
   boolean available;

   public Library(String title, String author, double price) {
       this.title = title;
       this.author = author;
       this.price = price;
       this.available = true;
   }
   public void borrowBook() {
       if (available) {
           available = false;
           System.out.println("You have successfully borrowed: " + title);
       } else {
           System.out.println("Sorry, the book is not available.");
       }
   }

   public String getTitle() {
       return title;
   }

   public boolean isAvailable() {
       return available;
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
      
       Library book1 = new Library("Java Programming", "James Gosling", 599.99);
       Library book2 = new Library("Data Structures", "Robert Lafore", 499.99);

       System.out.println("Enter book title to borrow: ");
       String title = sc.nextLine();       
       if (book1.getTitle().equalsIgnoreCase(title)) {//comparing
           book1.borrowBook();
       } else if (book2.getTitle().equalsIgnoreCase(title)) {
           book2.borrowBook();
       } else {
           System.out.println("Book not found.");
       }
   }
}

