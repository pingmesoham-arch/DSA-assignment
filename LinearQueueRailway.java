import java.util.Scanner;

class RailwayQueue {
    private int front;
    private int rear;
    private int capacity;
    private String[] queue;

    // Constructor to initialize queue
    public RailwayQueue(int size) {
        this.capacity = size;
        this.queue = new String[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // Check if the queue is full (Overflow condition)
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Check if the queue is empty (Underflow condition)
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Enqueue: Customer joins the line at the rear
    public void enqueue(String customerName) {
        if (isFull()) {
            System.out.println("Queue Overflow: The counter line is full. " + customerName + " cannot join.");
            return;
        }
        if (front == -1) {
            front = 0; // First element entering the queue
        }
        rear++;
        queue[rear] = customerName;
        System.out.println("Customer joined: " + customerName + " is now in line.");
    }

    // Dequeue: Customer at the front is served and leaves
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No customers in line to serve.");
            return null;
        }
        String servedCustomer = queue[front];
        System.out.println("Serving ticket to: " + servedCustomer);
        front++;

        // Reset indices if the queue becomes completely empty after dequeue
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return servedCustomer;
    }

    // Peek: Look at the customer currently at the front
    public void peek() {
        if (isEmpty()) {
            System.out.println("The line is currently empty.");
            return;
        }
        System.out.println("Next customer to be served: " + queue[front]);
    }

    // Display: Print all customers currently waiting in order
    public void display() {
        if (isEmpty()) {
            System.out.println("No customers are waiting in line.");
            return;
        }
        System.out.print("Current Line (Front -> Rear): ");
        for (int i = front; i <= rear; i++) {
            System.out.print("[" + queue[i] + "] ");
        }
        System.out.println();
    }
}

public class LinearQueueRailway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum counter capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        RailwayQueue counterQueue = new RailwayQueue(capacity);
        int choice;

        do {
            System.out.println("\n--- Railway Ticket Counter Menu ---");
            System.out.println("1. Enqueue (Customer Arrives)");
            System.out.println("2. Dequeue (Serve Customer)");
            System.out.println("3. Peek (Next Customer)");
            System.out.println("4. Display Line");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    counterQueue.enqueue(name);
                    break;
                case 2:
                    counterQueue.dequeue();
                    break;
                case 3:
                    counterQueue.peek();
                    break;
                case 4:
                    counterQueue.display();
                    break;
                case 5:
                    System.out.println("Closing counter.");
                    break;
                default:
                    System.out.println("Invalid choice! Enter an option between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}