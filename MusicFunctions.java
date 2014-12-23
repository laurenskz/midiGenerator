
/**
 * This class is abstract and contains only static functions. It provides methods used for musical implementations. 
 * Something about the reset base functions: 
 * Notes go from A to G(#), this can be represented by numbers. When adding a number to a note and it is higher than tbe value represented by G(#)
 * it has to be reseted. This is done by the functions of this class.
 * 
 * 
 * @author (Laurens op t Zandt) 
 * @version (3)
 */
public abstract class MusicFunctions
{
    /**
     * This methods resets base for chords. Chord Numbers that is. It goes back from G to A in chords.
     */
    public static int resetBase(int number)
    {
        if(number>6){
            number-=7;
        }
        return number;
    }
    
    /**
     * This method resets base for normal notes, It goes back from G# to A.
     */
    public static int resetBaseNormalNotes(int number)
    {
        if(number>7){
            number-=8;
        }
        return number;
    }
    
    /**
     * This method returns base for all notes, when no scale is selected yet, it is used to get the notes in the scale.
     */
    public static int resetBaseForAllNotes(int number)
    {
        if(number>11)
        {
            number-=12;
        }
        return number;
    }
}
