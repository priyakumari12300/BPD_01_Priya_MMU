import java.util.*;

// Definition for a graph node
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {

    // Function to clone the graph using BFS
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        // A map to store the original node and its corresponding cloned node
        Map<GraphNode, GraphNode> map = new HashMap<>();

        // Queue for BFS
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        // Clone the root node and put it in the map
        map.put(node, new GraphNode(node.val));

        // Perform BFS
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();

            // Iterate over all the neighbors of the current node
            for (GraphNode neighbor : current.neighbors) {
                // If the neighbor hasn't been cloned yet
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor and put it in the map
                    map.put(neighbor, new GraphNode(neighbor.val));
                    // Add the neighbor to the queue for further processing
                    queue.add(neighbor);
                }

                // Add the cloned neighbor to the cloned current node's neighbors list
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return map.get(node);
    }

    public static void main(String[] args) {
        // Create an example graph
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        // Set up neighbors (edges)
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        CloneGraph graphCloner = new CloneGraph();
        GraphNode clonedGraph = graphCloner.cloneGraph(node1);

        // Output to verify the structure is preserved (optional)
        System.out.println("Cloned graph node: " + clonedGraph.val);
        for (GraphNode neighbor : clonedGraph.neighbors) {
            System.out.println("Neighbor: " + neighbor.val);
        }
    }
}
