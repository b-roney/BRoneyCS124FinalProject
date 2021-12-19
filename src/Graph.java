import java.util.ArrayList;
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
        if(!cityMap.containsKey(cityName)) {
            GraphNode node = new GraphNode(cityName);
            cityMap.put(cityName, node);
        }
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

        if(!cityMap.containsKey(cityA) || !cityMap.containsKey(cityB)) {
            System.out.println("One of the cities is not in the map.");
        } else {
            GraphNode nodeA = getNode(cityA);
            GraphNode nodeB = getNode(cityB);

            //Add edge to cityB okay
            nodeA.addEdge(nodeB, distance);
            nodeB.addEdge(nodeA, distance);
        }
    }

    public void findPath(String start, String end) {
        HashMap<String, Integer> distanceTable = new HashMap<>();
        String currentLocation = start;
        Path currentPath = new Path(currentLocation);
        ArrayList<Path> pathQueue = new ArrayList<Path>();
        while(!currentLocation.equals(end)){
            if(!distanceTable.containsKey(currentLocation)){
                distanceTable.put(currentLocation, currentPath.getLength());
                HashMap<GraphNode, Integer> adjEdgeInfo = getNode(currentLocation).getOutboundEdges();
                for(GraphNode key : adjEdgeInfo.keySet()){
                    Path path = new Path(currentPath);
                    path.addCity(key.getLocation(), adjEdgeInfo.get(key));
                        pathQueue.add(path);


                }
            }
        }
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

    public void displayCityInfo(String target){
        if(!cityMap.containsKey(target)){
            System.out.print("Map does not contain " + target +".");
        } else {
            GraphNode node = getNode(target);
            node.displayCityInfo();
        }
    }




}
