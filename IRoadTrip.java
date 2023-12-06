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

public class IRoadTrip {
    //Creating hashmap to store the country code and country name
    private static HashMap<String, String> countries = new HashMap<String, String>();

    public IRoadTrip (String [] args) {
        // Replace with your code//DEL
        try{

            //Dealing with file state_name.tsv
            //Opening & reading file
            File file = new File(args[2]);
            Scanner line = new Scanner(file);
            
            //Adding to hashmap
            while(line.hasNextLine()){
                String countryInfo = line.nextLine();

                //Breaking down the line to determine if country is recent (2020)
                String[] parts = countryInfo.toLowerCase().split("\\s+");
                //Getting the last 'word' in line which is the year it 'ended'
                String lastWord = parts[parts.length - 1];
                String countryCode = parts[0];

                //Loop that reads in the 2020 year portion to determine accuracy
                if(lastWord.equals("2020-12-31")){ 
                    String[] countryNames = Arrays.copyOfRange(parts, 2, parts.length - 2);
                    String countryName = String.join(" ", countryNames);
                    //System.out.println(countryName);//DEL
                    //Adding countries that are still 'alive' into hashmap
                    countries.put(countryCode, countryName);
                }
            }

            line.close();

        } catch (FileNotFoundException e){
            System.err.println("Error " + e.getMessage());
        }
    }//End of IRoadTrip


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
        System.out.println("Hello, what is your name? ");
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
    }//End of acceptUserInput


    public static void main(String[] args) {
        //Passes args files to IRoadTrip
        IRoadTrip documents = new IRoadTrip(args);

        documents.acceptUserInput();
    }//End of main
}//End of IRoadTrip

