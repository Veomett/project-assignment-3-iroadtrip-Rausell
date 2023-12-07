import java.util.List;
//Importing scanner modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Importing hashmap module
import java.util.HashMap;
//Import arrays module
import java.util.ArrayList;
import java.util.Arrays;
//Importing map module for graph creation
import java.util.Map;

public class IRoadTrip {
    //Creating hashmap to store the country code and country name & check existence
    private static HashMap<String, String> countries = new HashMap<String, String>();

    //Graph creation
    private Map<String, Map<String, Integer>> adj;//Newly added
    private Map<String, String> worldMap;

    public IRoadTrip (String [] args) {
        if(args.length != 3){
            System.err.println("Three files needed.");
            System.exit(1);
        }

        //Initializing adj & worldMap map
        adj = new HashMap<>();
        worldMap = new HashMap<>();

        try{
            //TESTING BELOW
            //Reading information from file borders.txt
            File fileI = new File(args[0]);
            Scanner lineI = new Scanner(fileI);

            while(lineI.hasNextLine()){
                String borderInfo = lineI.nextLine();
                String[] goodneighbors = borderInfo.toLowerCase().split(" = ");
                String country = goodneighbors[0];
                if(!(adj.containsKey(country))){
                    adj.put(country, new HashMap<>());
                }
                if(goodneighbors.length > 1){
                    String[] myNeighbors = goodneighbors[1].split(";");
                    for(String neighbor : myNeighbors){
                        System.out.println(neighbor);//DEL
                        String[] neighborNames = neighbor.split(" ");
                        String neighborID = neighborNames[0];
                        //Setting distance at 0, aka starting on the user given country
                        adj.get(country).put(neighborID, 0);
                    }
                    //System.out.println();//DEL
                }
            }


            //Reading information from capdist.csv
            File fileII = new File(args[1]);
            Scanner lineII = new Scanner(fileII);

            /*This small if statement should skip the first line in capdist.csv 
            in order to ensure that we can extract the distance (integer) without issues
            as the first line is filled with only chars.*/
            if(lineII.hasNextLine()) {
                lineII.nextLine();
            }

            while(lineII.hasNextLine()){
                String capitalStats = lineII.nextLine();
                String[] distances = capitalStats.toLowerCase().split(",");
                //Getting input validation for both country A & B
                String countryA = exists(distances[1]); 
                String countryB = exists(distances[3]);
                //Taking note of the distance difference in km between capitals
                int distanceKm = Integer.parseInt(distances[4]);
                //Updating distance in adj for land connected countries
                if(adj.containsKey(countryA) && adj.get(countryA).containsKey(countryB)){
                    //getting both stats for country A and B as they are stored in an undirected graph
                    adj.get(countryA).put(countryB, distanceKm);
                    adj.get(countryB).put(countryA, distanceKm);
                }
            }

            //TESTING ABOVE


            //Reading information from file state_name.tsv
            File fileIII = new File(args[2]);
            Scanner lineIII = new Scanner(fileIII);

            //NEWLY Added below
            if(lineIII.hasNextLine()) {
                lineIII.nextLine();
            }
            //Newly Added above

            //Adding to hashmap
            while(lineIII.hasNextLine()){
                String countryInfo = lineIII.nextLine();
                //Breaking down the line to determine if country is recent (2020)
                String[] parts = countryInfo.toLowerCase().split("\\s+");
                //Getting the last 'word' in line which is the year it 'ended'
                String lastWord = parts[parts.length - 1];
                String countryCode = parts[1];
                String officialName = parts[2];

                //Loop that reads in the 2020 year portion to determine accuracy
                if(lastWord.equals("2020-12-31")){ 
                    String[] countryNames = Arrays.copyOfRange(parts, 2, parts.length - 2);
                    String countryName = String.join(" ", countryNames);
                    //System.out.println(countryName);//DEL
                    //Adding countries that are still 'alive' into hashmap
                    countries.put(countryCode, countryName);
                    worldMap.put(countryCode, officialName);
                }
            }

            lineIII.close();
            lineII.close();
            lineI.close();//Newly Added

        } catch (FileNotFoundException e){
            System.err.println("Error " + e.getMessage());
        }
    }//End of IRoadTrip

    //Called upon to check the existence of the given country
    private String exists(String country){
        if(countries.containsKey(country)){
            //If contry exists, return its proper name
            return countries.get(country);
        }
        return null;
    }//End of method exists


    public int getDistance (String country1, String country2) {
        // Replace with your code
        return -1;
    }//End of getDistance


    public List<String> findPath (String country1, String country2) {
        // Replace with your code
        return null;
    }//End of findPath


    public void acceptUserInput() {
        //Setting up input & country variables
        Scanner input = new Scanner(System.in);
        System.out.println("\nHello, what is your name? ");
        String country1 = input.nextLine().toLowerCase();
        String country2 = country1;
        
        //while(!(input.nextLine().equalsIgnoreCase("EXIT"))){
        while(true){
            System.out.println("\nEnter the name of the first country (type EXIT to quit): ");
            country1 = input.nextLine().toLowerCase();
            if(country1.equalsIgnoreCase("EXIT")){
                break;
            }
            //Checking to see if given country name exists in our hashMap
            boolean countryReal = countries.containsValue(country1);
            if(!countryReal){
                System.out.println("Invalid country name. Please enter a valid country name.");
                continue;
            }

            System.out.println("\nEnter the name of the second country (type EXIT to quit): ");
            country2 = input.nextLine().toLowerCase();
            if(country2.equalsIgnoreCase("EXIT")){
                break;
            }
            //Checking to see if given country name exists in our hashMap
            countryReal = countries.containsValue(country2);
            if(!countryReal){
                System.out.println("Invalid country name. Please enter a valid country name.");
                continue;
            }

            

        }//End of while loop
        input.close();
    }//End of acceptUserInput


    public static void main(String[] args) {
        //Passes args files to IRoadTrip
        IRoadTrip documents = new IRoadTrip(args);
        documents.acceptUserInput();

    }//End of main
}//End of IRoadTrip

