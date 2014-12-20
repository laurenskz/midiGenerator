
/**
 * Write a description of class ChordDuration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChordDuration
{
    // instance variables - replace the example below with your own
    private SingleChordData chord;
    private int duration;

    /**
     * Constructor for objects of class ChordDuration
     */
    public ChordDuration(SingleChordData chord, int duration)
    {
        this.chord = chord;
        this.duration = duration;
    }
    
    public int getDuration()
    {
        return duration;
    }
    
    public SingleChordData getChord()
    {
        return chord;
    }
}
