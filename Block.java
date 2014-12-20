import java.util.*;
/**
 * A song is made out of blocks, more than 1 block can play at any time.
 * It is a part of the song that fits together (e.g a chordprogression that is repeated x times)
 * If you have for example a chord progression of 4 times and you want to create a melody 
 * You can pass along the block. It makes things easier and more structured
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block
{
    // instance variables - replace the example below with your own
    private int blockStartTime;
    //What time in pulses the block ends
    private int blockEndTime;

    
    /**
     * Constructor for objects of class Block
     */
    public Block(int blockStartTime)
    {
        this.blockStartTime = blockStartTime;
    }
    
    public int getEndTime()
    {
        return blockEndTime;
    }
    
    public int getStartTime()
    {
        return blockStartTime;
    }
    
    protected void setEndTime(int endTime)
    {
        blockEndTime = endTime;
    }
    
    
}
