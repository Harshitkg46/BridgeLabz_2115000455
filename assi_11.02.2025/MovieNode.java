class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public void addMovie(String title, String director, int year, double rating, String position) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (position.equals("beginning")) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
    }

    public void removeMovie(String title) {
        MovieNode current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        } else {
            System.out.println("Movie not found!");
        }
    }

    public void searchByDirectorOrRating(String searchTerm) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equals(searchTerm) || String.valueOf(current.rating).equals(searchTerm)) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    public void displayMovies(boolean reverse) {
        if (reverse) {
            MovieNode current = tail;
            while (current != null) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
                current = current.prev;
            }
        } else {
            MovieNode current = head;
            while (current != null) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
                current = current.next;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MovieLinkedList movies = new MovieLinkedList();
        movies.addMovie("Inception", "Christopher Nolan", 2010, 9.0, "beginning");
        movies.addMovie("Interstellar", "Christopher Nolan", 2014, 8.5, "end");
        movies.displayMovies(false);
        movies.removeMovie("Inception");
        movies.displayMovies(false);
    }
}
