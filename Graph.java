import java.util.*;

// Class to represent a graph using adjacency list
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list

    // Constructor
    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's list
    }

    // BFS algorithm
    public void BFS(int start) {
        // Create a boolean array to mark visited vertices
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the starting node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int current = queue.poll();
            System.out.print(current + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int neighbor : adjList[current]) {
                // If a neighbor has not been visited, mark it as visited and enqueue it
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6); // Create a graph with 6 vertices (0 to 5)

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("Breadth First Traversal starting from vertex 0:");

        // Perform BFS starting from vertex 0
        g.BFS(0);
    }
}
