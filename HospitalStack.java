
import java.util.Scanner;

class HospitalStack {
    static class Node {
        String patient;
        Node next;

        Node(String patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    Node top = null;

    void push(String patient) {
        Node newNode = new Node(patient);
        newNode.next = top;
        top = newNode;
        System.out.println(patient + " added to stack.");
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Removed: " + top.patient);
        top = top.next;
    }

    void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top patient: " + top.patient);
        }
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node temp = top;
        System.out.println("Patients (top to bottom):");

        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalStack stack = new HospitalStack();
        int choice;

        do {
            System.out.println("\n--- Hospital Patient Stack ---");
            System.out.println("1. Push patient");
            System.out.println("2. Pop patient");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();
                    stack.push(name);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
