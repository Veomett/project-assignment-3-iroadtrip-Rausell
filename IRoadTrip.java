import java.util.List;
//Importing scanner modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Importing hashmap module
import java.util.HashMap;
//Import array module
import java.util.Arrays;

public class IRoadTrip {

    public IRoadTrip (String [] args) {
        // Replace with your code//DEL
        try{

            //Dealing with file state_name.tsv
            //Opening & reading file
            File file = new File(args[2]);
            Scanner line = new Scanner(file);
            
            //Creating hashmap to store the country code and country name
            HashMap<String, String> countries = new HashMap<String, String>();
            
            //Adding to hashmap
            while(line.hasNextLine()){
                String countryInfo = line.nextLine();

                //Breaking down the line to determine if country is recent (2020)
                String[] parts = countryInfo.split("\\s+");
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
        // Replace with your code
        System.out.println("IRoadTrip - skeleton");
    }//End of acceptUserInput


    public static void main(String[] args) {
        //Passes args files to IRoadTrip
        IRoadTrip documents = new IRoadTrip(args);

        System.out.println("Main method works!");//DEL

        System.out.println("Enter the name of the first country (type EXIT to quit): ");
        System.out.println("Enter the name of the second country (type EXIT to quit): ");
        
        //documents.acceptUserInput();
    }//End of main
}//End of IRoadTrip

