import java.util.ArrayList;

public class Path {
    private ArrayList<String> pathCities;
    private int length;

    public Path(String startCity){
        length = 0;
        pathCities = new ArrayList<String>();
        pathCities.add(startCity);
    }

    // methods
    public void addCity(String city, int distance) {
        // add node to the end,
        // increase length by distance
        pathCities.add(city);
        length = length + distance;
    }

    public String getLastCity() {
        return pathCities.get(pathCities.size()-1);
    }

    public int getLength(){
        return length;
    }
}
