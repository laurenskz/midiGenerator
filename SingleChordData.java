import java.util.ArrayList;
/**
 * 
 * This class includes all data about one induvidual chord. 
 * It is used quite a lot in the rest of the program, theoretical notes are the number of the note in the scale. 
 * In a scale of C major the C note would have theoretical note number 0, 
 * later it can be gotten with getNotesInkey()
 * 
 * @author (Laurens op t Zandt)
 */
public class SingleChordData
{
    //The relativeChordNumber of the chord, in a scale of C major, the C chord would have chord number 0 and Em would have chord Number 2. E major wont be possible
    private int relativeChordNumber;
    //The actual notes are the theoretical notes gotten from getNotesInKey()
    private int[] actualNotes;
    //theoretical notes are the number of the note in the scale
    private ArrayList<Integer> theoreticalNotes;
    
    /**
     * Constructor for objects of class SingleChordData
     * It is iniatalised with just the relative chord number
     */
    public SingleChordData(int relativeChordNumber)
    {
        this.relativeChordNumber = relativeChordNumber;
        actualNotes = null;
        theoreticalNotes = null;
    }
    
    /**
     * returns the relative chord number of this chord
     */
    public int getRelativeChordNumber()
    {
        return relativeChordNumber;
    }
    
    /**
     * Allows the actual notes to be set
     */
    public void setActualNotes(int[] actualNotes)
    {
        this.actualNotes = actualNotes;
    }
    
    /**
     * Allows the theoretical notes to be set
     */
    public void setTheoreticalNotes(ArrayList<Integer> theoreticalNotes)
    {
        this.theoreticalNotes = theoreticalNotes;
    }
    
    /**
     * Returns an arrayList of theoretical notes
     */
    public ArrayList<Integer> getTheoreticalNotes()
    {
        return theoreticalNotes;
    }
}
