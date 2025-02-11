class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode currentTask = null;

    // Add a task at the beginning, end, or a specific position
    public void addTask(int taskId, String taskName, int priority, String dueDate, String position) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            currentTask = head;
        } else if (position.equals("beginning")) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove!");
            return;
        }

        TaskNode current = head, previous = null;
        do {
            if (current.taskId == taskId) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    tail.next = head;
                }

                if (head == tail && head.taskId == taskId) {
                    head = tail = null;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("Current Task -> ID: " + currentTask.taskId + ", Name: " + currentTask.taskName + ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
        currentTask = currentTask.next;
    }

    // Display all tasks in the circular list
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display!");
            return;
        }

        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available to search!");
            return;
        }

        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Found -> Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks
        scheduler.addTask(1, "Task 1", 1, "2025-02-12", "end");
        scheduler.addTask(2, "Task 2", 2, "2025-02-13", "end");
        scheduler.addTask(3, "Task 3", 1, "2025-02-14", "beginning");

        // Display all tasks
        System.out.println("\nAll Tasks:");
        scheduler.displayTasks();

        // View current task and move to the next
        System.out.println("\nView Current Task:");
        scheduler.viewCurrentTask();

        // Search by priority
        System.out.println("\nSearch Tasks by Priority 1:");
        scheduler.searchByPriority(1);

        // Remove a task
        System.out.println("\nRemove Task with ID 2:");
        scheduler.removeTask(2);

        // Display all tasks after removal
        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayTasks();

        // View current task
        System.out.println("\nView Current Task Again:");
        scheduler.viewCurrentTask();
    }
}
