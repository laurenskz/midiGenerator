
/**
 * Write a description of class SingleChordData here.
 * 
 * This class includes all data about one induvidual chord
 */
public class SingleChordData
{
    // instance variables - replace the example below with your own
    private int relativeChordNumber;
    private int noteOnTime;
    private int noteOffTime;
    private int[] actualNotes;
    private int[] theoreticalNotes;
    
    /**
     * Constructor for objects of class SingleChordData
     */
    public SingleChordData(int relativeChordNumber, int noteOnTime, int noteOffTime)
    {
        this.relativeChordNumber = relativeChordNumber;
        this.noteOnTime = noteOnTime;
        this.noteOffTime = noteOffTime;
        actualNotes = null;
        theoreticalNotes = null;
    }
    
    public int getRelativeChordNumber()
    {
        return relativeChordNumber;
    }
    
    public void setActualNotes(int[] actualNotes)
    {
        this.actualNotes = actualNotes;
    }
    
    public void setTheoreticalNotes(int[] theoreticalNotes)
    {
        this.theoreticalNotes = theoreticalNotes;
    }
}
