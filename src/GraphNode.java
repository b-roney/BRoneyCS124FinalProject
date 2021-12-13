

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
    // private ArrayList<Integer> distances; okay

    public void addEdge(GraphNode otherNode, int distance) {
        //Adds the distance between the start and destination cities
        outboundEdges.put(otherNode, distance);
    }

    public void displayCityInfo(){
        for(GraphNode node : outboundEdges.keySet()){
            String cityName = node.location;
            int distance = outboundEdges.get(node);
            System.out.println(cityName + ", " + distance);
        }
    }

}