
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
     * Nothing happens here because all of these functions are static
     */
    public RandomFunctions()
    {

    }
    
    public static int randomInt(int min, int max)
    {
        if(min>max)
        {
            return -15;
        }
        max++;
        java.util.Random rand = new java.util.Random();
        int randomNumber = rand.nextInt(max-min)+min;
        return randomNumber;
    }
    
    public static int odds(int[] inputOddsArray)
    {
        int importantRand = RandomFunctions.randomInt(1,100);
        int counter = 0;
        int previousSum = 0;
        for(int chance : inputOddsArray)
        {
            previousSum+=chance;
            if(importantRand<=previousSum){
                return counter;
            }
            counter++;
        }
        return -15;
    }

}
