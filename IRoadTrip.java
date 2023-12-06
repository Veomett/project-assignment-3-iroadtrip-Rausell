import java.util.List;
//Importing scanner modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Importing hashmap module
import java.util.HashMap;

public class IRoadTrip {

    public IRoadTrip (String [] args) {
        // Replace with your code//DEL
        try{

            //Dealing with file state_name.tsv
            //Opening & reading file
            File file = new File(args[2]);
            Scanner line = new Scanner(file);
            
            //Creating hashmap to store the country code and country name
            HashMap<String, String> stateNames = new HashMap<String, String>();
            
            //Adding to hashmap
            while(line.hasNextLine()){

                
                String countryCode = line.nextLine();
                //Testing the breaking of 
                System.out.println(countryCode);
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

