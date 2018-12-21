import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ArmyTester

{
    public static void main(String args[]) throws IOException
    {
        // Starting strength of largest Regiment
        int strength = 1000 ;    
        
        // Create Army object
        Army army = new Army() ; 
        
        // Create scanner object associated withe input file
        Scanner fileIn = new Scanner( new File ("regiments.txt") ) ;
        
        // Read input file, create Regiment objects from data, add to ArrayList
        while ( fileIn.hasNext() ) // while not end of file
        {
            int regNum = fileIn.nextInt() ;      // set integers in file to 
                                                 // variable "regNum"
            String regName = fileIn.next() ;     // set Strings in file to
                                                 // variable "regName"
            // Create Regiment object
            Regiment regiment = new Regiment(regNum, regName, strength) ;
            
            // add regiments to army
            army.addRegiment(regiment) ;
            
            // First regiment gets 1000 men, each other regiment gets
            // 50 less men than its preceeding regiment
            strength -= 50 ;
        }
        
        // Print original army before adding men and shipping regiments
        army.printOriginal() ;
        
        // For each week, 1 through 20...
        for (int week = 1; week <= 20; week++)
        {
            army.addNewMen() ;       // Add new men to each regiment
            army.printReport(week) ; // Print weekly report
            army.removeRegiment() ;  // Remove the regiment that was shipped
                                     // from weekly report
        }
    }        
}
