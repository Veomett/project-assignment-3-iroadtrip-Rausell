import java.util.List;
//Importing scanner modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IRoadTrip {


    public IRoadTrip (String [] args) {
        // Replace with your code//DEL
        try{
            File file = new File(args);
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (EmptyFileException e){
            System.err.println(e.getMessage());
        }
        



    }


    public int getDistance (String country1, String country2) {
        // Replace with your code
        return -1;
    }


    public List<String> findPath (String country1, String country2) {
        // Replace with your code
        return null;
    }


    public void acceptUserInput() {
        // Replace with your code
        System.out.println("IRoadTrip - skeleton");
    }


    public static void main(String[] args) {
        IRoadTrip a3 = new IRoadTrip(args);//DEL

        System.out.println("Main method works!");//DEL

        System.out.println("Enter the name of the first country (type EXIT to quit): ")
        System.out.println("Enter the name of the second country (type EXIT to quit): ");
        
        a3.acceptUserInput();
    }

}

