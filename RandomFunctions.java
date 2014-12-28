
/**
 * An abstract class containing only static functions, it contains functions used for random number generations.
 */
public abstract class RandomFunctions
{
    /**
     * This method returns a random number generated between the limits. It includes min and max.
     */
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
    
    /**
     * This method takes an input array of odds, and checks if the odd is met, if it is it returns the index of the number.
     * If no odd is met it returns -15. (This can only happen if the odds combined are smaller than 100.
     */
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
