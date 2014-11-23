
/**
 * This class creates a random integer between 0 and 100 in the constructor. Later this can be tested
 * against user defined percentages (or other classes calling an object of this class)
 * 
 * @author (Laurens op 't Zandt) 
 * @version (1)
 */
public class Odds
{
    // instance variables - replace the example below with your own
    private int importantRand;

    /**
     * Constructor for objects of class Odds
     */
    public Odds()
    {
       importantRand = RandomFunctions.randomInt(0,100);
    }
}
