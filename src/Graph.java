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
            return null;
        }
    }

    public void addEdge(String cityA, String cityB, int distance) {
        //Get cityA GraphNode
        GraphNode nodeA = getNode(cityA);
        GraphNode nodeB = getNode(cityB);
        //Add edge to cityB okay
        nodeA.addEdge(nodeB, distance);
        nodeB.addEdge(nodeA, distance);

    }

    public void findPath(String start, String end) {

    }

    public void listAllCities(){
       String [] cityNames = getSortedCities();
        for(String cityName : cityNames){
            System.out.println(cityName);
        }

    }


    public String[] getSortedCities(){
        String [] cityNames = cityMap.keySet().toArray(new String[0]);
        Arrays.sort(cityNames);
        return cityNames;
    }

    public void listMatchingCities(String target){
        String [] cityNames = getSortedCities();
        for(String cityName : cityNames){
            if(cityName.contains(target)){
                System.out.println(cityName);
            }
        }
    }


}
