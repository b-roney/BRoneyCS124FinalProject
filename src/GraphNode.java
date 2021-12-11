

import java.util.HashMap;

public class GraphNode {
    private String location;
    private HashMap<GraphNode, Integer> outboundEdges;

    public GraphNode(String location) {
        this.location = location;
        outboundEdges = new HashMap<>();
    }
    // Alternative to using a map for the edges:
    // private ArrayList<GraphNode> neighbors;
    // private ArrayList<Integer> distances;

    void addEdge(String otherNode, int distance) {
        //Get the node for the destination city
        GraphNode node = Main.graph.getNode(otherNode);
        //Adds the distance between the start and destination cities
        outboundEdges.put(node, distance);
    }

}