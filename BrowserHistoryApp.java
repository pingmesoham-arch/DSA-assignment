import java.util.Scanner;

class BrowserHistoryStack {
    private static final int MAX = 5; 
    private String[] history;
    private int top;


    public BrowserHistoryStack() {
        history = new String[MAX];
        top = -1; // Stack is initially empty
    }

   
    public void push(String url) {
        if (top >= MAX - 1) {
            System.out.println("\n[Stack Overflow] History is full! Cannot visit: " + url);
            return;
        }
        top++;
        history[top] = url;
        System.out.println("Visited: " + url);
    }


    public void pop() {
        if (top < 0) {
            System.out.println("\n[Stack Underflow] No history available to go back to!");
            return;
        }
        String removedUrl = history[top];
        top--;
        System.out.println("Navigating back from: " + removedUrl);
        
        if (top >= 0) {
            System.out.println("Current active page: " + history[top]);
        } else {
            System.out.println("You are on the blank starting tab.");
        }
    }


    public void peek() {
        if (top < 0) {
            System.out.println("\nHistory is empty (Blank starting tab).");
            return;
        }
        System.out.println("Current Page: " + history[top]);
    }

   
    public void display() {
        if (top < 0) {
            System.out.println("\nBrowsing history is empty.");
            return;
        }
        System.out.println("\n--- Browser History (Recent to Oldest) ---");
        for (int i = top; i >= 0; i--) {
            System.out.print("[" + i + "] " + history[i]);
            if (i == top) {
                System.out.print(" <-- (Current Page)");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }
}

public class BrowserHistoryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistoryStack browser = new BrowserHistoryStack();
        int choice;

        do {
            System.out.println("\n=== Browser History Simulation (Stack via Array) ===");
            System.out.println("1. Visit New Page (Push)");
            System.out.println("2. Click Back Button (Pop)");
            System.out.println("3. View Current Page (Peek)");
            System.out.println("4. Display Entire History (Display)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit (e.g., google.com): ");
                    String url = scanner.nextLine().trim();
                    if (!url.isEmpty()) {
                        browser.push(url);
                    } else {
                        System.out.println("URL cannot be empty.");
                    }
                    break;
                case 2:
                    browser.pop();
                    break;
                case 3:
                    browser.peek();
                    break;
                case 4:
                    browser.display();
                    break;
                case 5:
                    System.out.println("Exiting Browser History Simulator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}