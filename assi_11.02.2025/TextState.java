class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head; // Start of the doubly linked list
    private TextState current; // Pointer to the current state
    private int historyLimit = 10; // Maximum size of undo/redo history
    private int size = 0; // Current size of the list

    // Add a new state to the text editor
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If this is the first state
        if (head == null) {
            head = newState;
            current = newState;
            size = 1;
            System.out.println("State added: " + content);
            return;
        }

        // If adding after performing some undo actions, remove forward redo history
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        // Add the new state at the end
        current.next = newState;
        newState.prev = current;
        current = newState;

        // If the size exceeds the limit, remove the oldest state
        size++;
        if (size > historyLimit) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("State added: " + content);
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No more undo actions available.");
            return;
        }

        current = current.prev;
        System.out.println("Undo: Current state -> " + current.content);
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No more redo actions available.");
            return;
        }

        current = current.next;
        System.out.println("Redo: Current state -> " + current.content);
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No states available.");
        } else {
            System.out.println("Current state: " + current.content);
        }
    }

    // Display all states for debugging
    public void displayAllStates() {
        System.out.println("All states:");
        TextState temp = head;
        while (temp != null) {
            System.out.print(temp.content + (temp == current ? " <- Current" : "") + " | ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Add states
        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How");
        editor.addState("Hello, World! How are");
        editor.addState("Hello, World! How are you?");

        // Display the current state
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();
        editor.undo();

        // Display the current state after undo
        editor.displayCurrentState();

        // Perform redo operations
        editor.redo();

        // Display the current state after redo
        editor.displayCurrentState();

        // Add a new state after undo
        editor.addState("Hello again!");

        // Display all states for debugging
        editor.displayAllStates();

        // Undo beyond limit
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();

        // Redo beyond limit
        editor.redo();
        editor.redo();
        editor.redo();
    }
}
