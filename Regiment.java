/*
Class that creates and defines a Regiment object to be used 
in an Army class when creating an army.

/**
 *A class that builds a Regiment object. 
 *
 */
public class Regiment
{
    private int number;     // the regiment number
    private String name;    // the regiment name
    private int strength;   // the amount of men in a regiment
    
    /**
     * Creates a Regiment object.
     * @param number the regiment number
     * @param name the regiment name
     * @param strength the amount of men in a regiment
     */
    public Regiment(int number, String name, int strength)
    {
        this.number = number;
        this.name = name;
        this.strength = strength;   
    }
    
    /**
     * Returns the Regiment number as an integer
     * @return the Regiment number
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * Returns the Regiment name as a string 
     * @return the Regiment name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the amount of men in a Regiment as an integer
     * @return the amount of men in a Regiment
     */
    public int getStrength()
    {
        return strength;
    }
    
    /**
     * Adds additional men to a Regiment
     * @param men the amount of men to add to a Regiment
     */
    public void addStrength(int men)
    {
        strength += men; 
    }
}
