class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    BookNode next;
    BookNode prev;

    public BookNode(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private BookNode head;
    private BookNode tail;

    // Add a new book at the beginning, end, or a specific position
    public void addBook(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus, String position) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        switch (position.toLowerCase()) {
            case "beginning":
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                break;
            case "end":
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                break;
            default:
                System.out.println("Invalid position! Use 'beginning' or 'end'.");
        }
    }

    // Remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search for a book by Book Title or Author
    public void searchBook(String searchKey) {
        BookNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(searchKey) || current.author.equalsIgnoreCase(searchKey)) {
                System.out.println("Found -> Title: " + current.bookTitle + ", Author: " + current.author + 
                                   ", Genre: " + current.genre + ", ID: " + current.bookId + 
                                   ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No book found with Title or Author: " + searchKey);
        }
    }

    // Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean newStatus) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = newStatus;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        System.out.println("Books in Forward Order:");
        BookNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.bookTitle + ", Author: " + current.author + 
                               ", Genre: " + current.genre + ", ID: " + current.bookId + 
                               ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }

        System.out.println("Books in Reverse Order:");
        BookNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.bookTitle + ", Author: " + current.author + 
                               ", Genre: " + current.genre + ", ID: " + current.bookId + 
                               ", Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public void countBooks() {
        int count = 0;
        BookNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Total Number of Books in Library: " + count);
    }
}

class Main {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add books
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1, true, "beginning");
        library.addBook("1984", "George Orwell", "Dystopian", 2, false, "end");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction", 3, true, "end");

        // Display books in forward order
        library.displayBooksForward();

        // Display books in reverse order
        library.displayBooksReverse();

        // Update availability
        library.updateAvailability(2, true);

        // Search for a book
        library.searchBook("George Orwell");
        library.searchBook("The Great Gatsby");

        // Count books
        library.countBooks();

        // Remove a book
        library.removeBook(1);

        // Display books again
        library.displayBooksForward();
    }
}
