class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime; // To track the remaining burst time of the process
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;

        do {
            if (current.processId == processId) {
                if (current == head && current == tail) {
                    // Only one process in the list
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }

                System.out.println("Process with ID " + processId + " removed.");
                return;
            }

            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        ProcessNode current = head;

        while (true) {
            boolean allCompleted = true;

            do {
                if (current.remainingTime > 0) {
                    allCompleted = false;

                    if (current.remainingTime > timeQuantum) {
                        System.out.println("Process " + current.processId + " executed for " + timeQuantum + " units.");
                        current.remainingTime -= timeQuantum;
                    } else {
                        System.out.println("Process " + current.processId + " completed execution.");
                        totalWaitingTime += (totalTurnaroundTime - current.burstTime);
                        totalTurnaroundTime += current.burstTime;
                        current.remainingTime = 0;
                        removeProcess(current.processId);
                    }
                }

                current = current.next;
            } while (current != head);

            if (allCompleted) break;

            displayProcesses();
        }

        // Calculate average waiting time and turnaround time
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("Processes in the queue:");
        ProcessNode current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Remaining Time: " + current.remainingTime + 
                               ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}
class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        // Display initial processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with time quantum = 4
        scheduler.simulateRoundRobin(4);
    }
}
