/*
Class that creates an ArrayList of Regiments as an Army. This class
utlizes the Regiment Class to create and manipulate regiments to be placed in
an army that is an ArrayList.
*/

import java.util.ArrayList ;

/**
 *A class that creates an Army ArrayList of Regiment objects
 *
 */
public class Army
{
    private ArrayList<Regiment> javaArmy ;   // ArrayList of Regiment objects
    
    /**
     * Constructs an Army with no Regiments
     */
    public Army()
    {
        this.javaArmy = new ArrayList<Regiment>() ;
    }

    /**
     * Adds a Regiment to the Army
     * @param a the Regiment to add
     */
    public void addRegiment(Regiment r)
    {
        javaArmy.add(r) ;
    }
    
    /**
     * Adds additional men to Regiments
     */
    public void addNewMen()
    {
        // Loops through each Regiment in the army
        for (int i = 0; i < javaArmy.size(); i++)
        {
            // Creates regiment object
            Regiment regObject = javaArmy.get(i) ;
            
            // Regiment 5 gets 30 new men each week
            if ( regObject.getNumber() == 5 )
                regObject.addStrength( 30 ) ;
            // Each other regiment gets 100 new men each week
            else
                regObject.addStrength( 100 ) ;
        }
    }
    
    /**
     * Gets the Regiment with the most men
     * @return the Regiment with the most men
     */
    public int findLargest()
    {
        int regimentNum = 0 ; // Regiment with the most men, after new men added
        
        int largest = 0 ;     // Regiment currently with most men
        
        // Loops though each Regiment in the army
        for (int i = 0; i < javaArmy.size(); i++)
        {
            // Loops through each regiment during a week, sets variable 
            // "regimentNum" to the regiment that has the most men
            if ( javaArmy.get(i).getStrength() > largest )
            {
                regimentNum = i ;
                largest = javaArmy.get(i).getStrength() ;
            }
        }
        
        return regimentNum ; // returns regiment with most men that week
    }
    
    /**
     * Prints original Army, with all Regiments and starting strengths
     */
    public void printOriginal()
    {
        // Prints heading
        System.out.printf("%26s%n%n", "[ ORIGINAL ARMY ]") ;
        System.out.printf("%-12s%-18s%-15s%n", "Number", "Name", "Strength") ;
        
        // Loops though each Regiment in the army
        for (int i = 0; i < javaArmy.size(); i++)
        {
            // Creates regiment object
            Regiment original = javaArmy.get(i) ;
            
            // Prints regiment number, name, strength
            System.out.printf("%-12d%-18s%-15d", original.getNumber(), 
                    original.getName(),original.getStrength()) ;

            System.out.println() ;
        }
        
        System.out.println("=======================================") ;
        System.out.println("=======================================" + "\n") ;
    }
  
    /**
     * Prints a weekly report that shows each Regiment, their strengths,
     * and which Regiment to be shipped that week
     * @param week the week of the report
     */
    public void printReport(int week)
    {
        // sets variable to the regiment with the most men
        int regimentToShip = findLargest() ;
        
        // Prints heading
        System.out.printf("%12s%d%-15s%n%n", "####### REPORT:  WEEK ", week, 
                " #######") ;
        
        System.out.printf("%-12s%-18s%-15s%n", "Number", "Name", "Strength") ;
        
        // Loops through each Regiment in the army
        for (int i = 0; i < javaArmy.size(); i++)
        {
            // Creates regiment object
            Regiment report = javaArmy.get(i) ;
         
            // Prints regiment number, name, strength
            System.out.printf("%-12d%-18s%-15d", report.getNumber(), 
                    report.getName(),report.getStrength()) ;

            System.out.println() ; 
        }
        
        System.out.println() ;
        
        // Loop to find regiment that will ship this week (contains most men)
        for (int i = 0; i < javaArmy.size(); i++)
        {
            // Creates regiment object
            Regiment shipping = javaArmy.get(i) ;
            
            // Loops through regiments, gets regiment with most men, labels 
            // this regiment as the regiment to be shipped this week
            if (i == regimentToShip)
            {
                System.out.printf("%23s%n%n", "[ SHIPPING ]") ;
                System.out.printf("%-12d%-18s%-15d%n", shipping.getNumber(), 
                        shipping.getName(),shipping.getStrength()) ;
            }
        }
        System.out.println("=======================================" + "\n") ;
    }
    
    /**
     * Removes the Regiment that is shipped from subsequent reports
     */
    public void removeRegiment()
    {
            int shipping = findLargest() ;   // Gets regiment with the most men
            javaArmy.remove(shipping) ;      // Removes this regiment from the
                                             // following weekly report
            
    }    
}
