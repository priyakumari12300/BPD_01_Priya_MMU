import java.util.*;

class Graph1 {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph1() {
        adjacencyList = new HashMap<>();
    }

    // Method to add a vertex
    public void addVertex(int v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    // Method to add an edge (wired connection)
    public void addEdge(int v1, int v2) {
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.putIfAbsent(v2, new ArrayList<>());
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1); // If undirected graph
    }

    // Method to display the graph
    public void displayGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Graph1 graph = new Graph1();
        
        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        
        // Add edges (wired connections)
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        // Display the graph
        graph.displayGraph();
    }
}
