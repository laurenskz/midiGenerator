
/**
 * Write a description of class Chords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomFunctions
{
    /**
     * Constructor for objects of class RandomFunctions
     * Nothing happens here because all of these functions are non-static
     */
    public RandomFunctions()
    {

    }
    
    public static int randomInt(int min, int max)
    {
        max++;
        java.util.Random rand = new java.util.Random();
        int randomNumber = rand.nextInt(max-min)+min;
        return randomNumber;
    }
    
}
