import java.util.List;
//Importing scanner modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IRoadTrip {


    public IRoadTrip (String [] args) {
        // Replace with your code//DEL
        try{
            File file = new File(args[0]);
            Scanner line = new Scanner(file);
            
            //Reading in content of the files
            while(line.hasNextLine()){
                String words = line.nextLine();
                System.out.println(words);
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
        IRoadTrip a3 = new IRoadTrip(args);//DEL

        System.out.println("Main method works!");//DEL

        System.out.println("Enter the name of the first country (type EXIT to quit): ");
        System.out.println("Enter the name of the second country (type EXIT to quit): ");
        
        //a3.acceptUserInput();
    }//End of main
}//End of IRoadTrip

