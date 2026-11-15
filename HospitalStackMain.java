
import java.util.Scanner;

// Doubly Linked List Node
class Node {
    int patientId;
    String patientName;
    String problem;

    Node prev;
    Node next;

    Node(int id, String name, String problem) {
        this.patientId = id;
        this.patientName = name;
        this.problem = problem;
        this.prev = null;
        this.next = null;
    }
}

// Stack using Doubly Linked List
class HospitalStack {

    Node top;

    // Push operation
    void push(int id, String name, String problem) {

        Node newNode = new Node(id, name, problem);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top.prev = newNode;
            top = newNode;
        }

        System.out.println("Patient added successfully!");
    }

    // Pop operation
    void pop() {

        if (top == null) {
            System.out.println("No patient records available!");
            return;
        }

        System.out.println("\nPatient processed:");
        System.out.println("Patient ID: " + top.patientId);
        System.out.println("Patient Name: " + top.patientName);
        System.out.println("Problem: " + top.problem);

        top = top.next;

        if (top != null) {
            top.prev = null;
        }
    }

    // Peek operation
    void peek() {

        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("\nLatest Patient Record:");
        System.out.println("Patient ID: " + top.patientId);
        System.out.println("Patient Name: " + top.patientName);
        System.out.println("Problem: " + top.problem);
    }

    // Display all patients
    void display() {

        if (top == null) {
            System.out.println("No patient records available!");
            return;
        }

        Node temp = top;

        System.out.println("\nHospital Patient Records:");
        System.out.println("--------------------------------");

        while (temp != null) {

            System.out.println("Patient ID: " + temp.patientId);
            System.out.println("Patient Name: " + temp.patientName);
            System.out.println("Problem: " + temp.problem);
            System.out.println("--------------------------------");

            temp = temp.next;
        }
    }
}

// Main Class
public class HospitalStackMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HospitalStack hospital = new HospitalStack();

        int choice;

        do {
            System.out.println("\n===== HOSPITAL PATIENT MANAGEMENT =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Process Latest Patient");
            System.out.println("3. Display All Patients");
            System.out.println("4. View Latest Patient");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Patient Problem: ");
                    String problem = sc.nextLine();

                    hospital.push(id, name, problem);
                    break;

                case 2:
                    hospital.pop();
                    break;

                case 3:
                    hospital.display();
                    break;

                case 4:
                    hospital.peek();
                    break;

                case 5:
                    System.out.println("Exiting Hospital System...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
