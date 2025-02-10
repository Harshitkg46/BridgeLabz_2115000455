// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        if (itemId != null && !itemId.trim().isEmpty()) {
            this.itemId = itemId;
        } else {
            throw new IllegalArgumentException("Item ID cannot be null or empty.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

// Interface Reservable
interface Reservable {
    void reserveItem(String borrower);

    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan period for books
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved by: " + borrower);
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan period for magazines
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved by: " + borrower);
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days loan period for DVDs
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved by: " + borrower);
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Array to store library items
        LibraryItem[] items = new LibraryItem[3];

        // Creating library item instances
        items[0] = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        items[1] = new Magazine("M001", "National Geographic", "Various");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        // Processing library items
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservable = (Reservable) item;
                System.out.println("Availability: " + (reservable.checkAvailability() ? "Available" : "Not Available"));
                reservable.reserveItem("John Doe");
                System.out.println("Availability after reservation: " + (reservable.checkAvailability() ? "Available" : "Not Available"));
            }

            System.out.println("---------------------------");
        }
    }
}
