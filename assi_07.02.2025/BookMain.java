
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book {
    private String name;
    private String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

class BookMain{
    public static void main(String[] args) {
        
        Author author1 = new Author("Harry Potter and the Sorcerer's Stone", 1997, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        author1.displayInfo();
    }
}

