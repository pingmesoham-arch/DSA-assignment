import java.util.Scanner;

class CircularQueue {
    int[] queue;
    int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Add print request
    void enqueue(int job) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow! Printer queue is full.");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = job;
        System.out.println("Print request " + job + " added.");
    }

    // Complete print request
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow! No print requests.");
            return;
        }

        System.out.println("Print request " + queue[front] + " completed.");

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display pending requests
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Pending print requests: ");

        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear)
                break;

            i = (i + 1) % size;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        int choice;

        do {
            System.out.println("\n--- Printer Queue ---");
            System.out.println("1. Add Print Request");
            System.out.println("2. Complete Print Request");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter print request number: ");
                    int job = sc.nextInt();
                    cq.enqueue(job);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}