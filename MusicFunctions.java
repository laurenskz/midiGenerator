
/**
 * Write a description of class MusicFunctions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicFunctions
{    
    /**
     * Constructor for objects of class MusicFunctions
     */
    public MusicFunctions()
    {
    }
    
    public static int resetBase(int number)
    {
        if(number>6){
            number-=7;
        }
        return number;
    }
    
    public static int resetBaseForAllNotes(int number)
    {
        if(number>11)
        {
            number-=12;
        }
        return number;
    }
}
