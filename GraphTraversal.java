
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class GraphTraversal {

    static int[][] adjMatrix;
    static String[] cities;
    static int n;

    // Breadth First Search
    static void BFS(int start) {

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(cities[current] + " ");

            for (int i = 0; i < n; i++) {

                if (adjMatrix[current][i] == 1
                        && !visited[i]) {

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.println();
    }

    // Depth First Search
    static void DFS(int start, boolean[] visited) {

        visited[start] = true;

        System.out.print(cities[start] + " ");

        for (int i = 0; i < n; i++) {

            if (adjMatrix[start][i] == 1
                    && !visited[i]) {

                DFS(i, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();
        sc.nextLine();

        cities = new String[n];
        adjMatrix = new int[n][n];

        // Enter city names
        System.out.println("Enter city names:");

        for (int i = 0; i < n; i++) {
            System.out.print("City " + (i + 1) + ": ");
            cities[i] = sc.nextLine();
        }

        // Enter adjacency matrix
        System.out.println("\nEnter Adjacency Matrix (0 or 1):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        sc.nextLine();

        // Display adjacency matrix
        System.out.println("\nAdjacency Matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Enter starting city
        System.out.print("\nEnter starting city: ");
        String startCity = sc.nextLine();

        int start = -1;

        for (int i = 0; i < n; i++) {
            if (cities[i].equalsIgnoreCase(startCity)) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            System.out.println("City not found!");
        } else {

            System.out.println("\nStarting City: " + cities[start]);

            BFS(start);

            boolean[] visited = new boolean[n];

            System.out.print("DFS Traversal: ");
            DFS(start, visited);

            System.out.println();
        }

        sc.close();
    }
}
