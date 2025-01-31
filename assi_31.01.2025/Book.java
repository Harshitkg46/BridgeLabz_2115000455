class Book
{
private String title;
private String author;
private double price;

 Book(String title,String author,double price)
{
this.title=title;
this.author=author;
this.price=price;
}
void displayDetails(){
System.out.println("Title of the book: "+title);
System.out.println("Author of the book: "+author);
System.out.println("Price of the book: "+price);
}
public static void main(String args[])
{
Book book=new Book("Alice in Wonderland","Lewis Carrol",500);
book.displayDetails();
}
} 
