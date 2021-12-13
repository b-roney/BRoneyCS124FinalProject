import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Graph graph;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
            //graph.displayCityInfo("Okland");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.print("*** File could not be opened.");
            return;

        }

        while(true){
            System.out.println("A. List all cities");
            System.out.println("B. Search cities");
            System.out.println("C. Display city information");
            System.out.println("D. Add new city");
            System.out.println("E. Add/Update link");
            System.out.println("Choose from the menu above.");
            String userInput = scanner.nextLine().toUpperCase();
            if(userInput.equals("A")){
                graph.listAllCities();
            }
            if(userInput.equals("B")){
                System.out.println("Enter city name:");
                String search = scanner.nextLine();
                graph.listMatchingCities(search);
            }
            if(userInput.equals("C")){
                System.out.println("Enter starting city:");
                String city = scanner.nextLine();
                graph.displayCityInfo(city);
            }
            if(userInput.equals("D")){
                System.out.println("Enter city name:");
                String city = scanner.nextLine();
                graph.addNode(city);
            }
            if(userInput.equals("E")){
                System.out.println("Enter starting city:");
                String start = scanner.nextLine();
                System.out.println("Enter ending city:");
                String end = scanner.nextLine();
                System.out.println("Enter distance:");
                int distance = scanner.nextInt();
                graph.addEdge(start, end, distance);
            }

        }

    }


}