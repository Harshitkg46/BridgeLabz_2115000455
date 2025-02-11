class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next; // Pointer to the next ticket

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last; // Points to the last node in the circular list
    private int totalTickets = 0;

    // Add a new ticket reservation at the end of the circular list
    public void addReservation(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (last == null) { // If the list is empty
            last = newTicket;
            last.next = last; // Circular pointer
        } else {
            newTicket.next = last.next; // Point to the first ticket
            last.next = newTicket; // Update the last node's next pointer
            last = newTicket; // Update the last pointer to the new ticket
        }

        totalTickets++;
        System.out.println("Ticket added: " + ticketID + " | " + customerName + " | " + movieName);
    }

    // Remove a ticket by Ticket ID
    public void removeReservation(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = last.next; // Start from the first node
        Ticket previous = last;

        do {
            if (current.ticketID == ticketID) { // Found the ticket
                if (current == last && current.next == last) { // Only one ticket in the list
                    last = null;
                } else {
                    previous.next = current.next;
                    if (current == last) { // If the ticket is the last node
                        last = previous;
                    }
                }
                totalTickets--;
                System.out.println("Ticket removed: " + ticketID);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket not found: " + ticketID);
    }

    // Display all tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("All Tickets:");
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTickets(String query) {
        if (last == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket current = last.next;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public void calculateTotalTickets() {
        System.out.println("Total number of booked tickets: " + totalTickets);
    }
}
class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding reservations
        system.addReservation(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addReservation(102, "Bob", "Interstellar", "B2", "1:00 PM");
        system.addReservation(103, "Charlie", "Inception", "A3", "10:00 AM");

        // Display all tickets
        system.displayTickets();

        // Search for tickets
        system.searchTickets("Inception");
        system.searchTickets("David");

        // Calculate total tickets
        system.calculateTotalTickets();

        // Remove a ticket
        system.removeReservation(102);

        // Display all tickets after removal
        system.displayTickets();

        // Calculate total tickets after removal
        system.calculateTotalTickets();

        // Attempt to remove a non-existent ticket
        system.removeReservation(200);
    }
}
