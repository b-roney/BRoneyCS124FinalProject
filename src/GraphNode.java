

import java.util.HashMap;

public class GraphNode {
    private String location;
    private HashMap<GraphNode, Integer> outboundEdges;

    // Alternative to using a map for the edges:
    // private ArrayList<GraphNode> neighbors;
    // private ArrayList<Integer> distances;

    void addEdge(String otherNode, int distance) {

    }

}