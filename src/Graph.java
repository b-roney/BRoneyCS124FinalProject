import java.util.Arrays;
import java.util.HashMap;

public class Graph {
    // map from names of cities to nodes
    private HashMap<String, GraphNode> cityMap;

    public Graph(){
        cityMap = new HashMap<>();
    }
    // methods
    public void addNode(String cityName) {
        GraphNode node = new GraphNode(cityName);
        cityMap.put(cityName, node);
    }

    public GraphNode getNode(String cityName){
        //Check if the city is in the Map
        if(cityMap.containsKey(cityName)){
            //If true, return the city
            return cityMap.get(cityName);
        } else {
            //If false, create node and add the city to the map
            addNode(cityName);
        }
        return cityMap.get(cityName);
    }

    public void addEdge(String cityA, String cityB, int distance) {
        //Get cityA GraphNode
        GraphNode nodeA = getNode(cityA);
        //Add edge to cityB okay
        nodeA.addEdge(cityB, distance);
    }

    public void findPath(String start, String end) {

    }

    public void listAllCities(){
        String [] cityNames = cityMap.keySet().toArray(new String[0]);
        Arrays.sort(cityNames);
        for(String cityName : cityNames){
            System.out.println(cityName);
        }

    }


}
