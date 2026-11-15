
import java.util.Scanner;

public class SortingProgram {

    // Selection Sort
    static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Display array
    static void display(int[] arr) {

        for (int mark : arr) {
            System.out.print(mark + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of students!");
            sc.close();
            return;
        }

        int[] marks = new int[n];

        System.out.println("Enter student marks:");

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        int choice;

        do {

            System.out.println("\n===== STUDENT MARKS SORTING =====");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Create a copy of original marks
            int[] arr = marks.clone();

            switch (choice) {

                case 1:
                    selectionSort(arr);

                    System.out.println("\nSelection Sort Output:");
                    display(arr);
                    break;

                case 2:
                    insertionSort(arr);

                    System.out.println("\nInsertion Sort Output:");
                    display(arr);
                    break;

                case 3:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
