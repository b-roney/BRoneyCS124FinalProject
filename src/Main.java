import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Graph graph;

    public static void main(String[] args) {

        graph = new Graph();

        try {
            File file = new File("california-data.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(",");
                //Add to graph
                String cityA = data[0];
                String cityB = data[1];
                int distance = (int) Double.parseDouble(data[2]);
                graph.addNode(cityA);
                graph.addNode(cityB);
                graph.addEdge(cityA, cityB, distance);

//                System.out.println("City A: " + data[0]);
//                System.out.println("City B: " + data[1]);
//                System.out.println("Distance: " + data[2]); okay
            }
            //graph.listAllCities();
            //graph.listMatchingCities("San");
            //graph.displayCityInfo("Oakland");
            graph.displayCityInfo("Okland");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.print("*** File could not be opened.");
            return;

        }
    }


}