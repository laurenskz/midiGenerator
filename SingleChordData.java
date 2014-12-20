import java.util.ArrayList;
/**
 * Write a description of class SingleChordData here.
 * Note on time and off time removed because of it not belonging in this class
 * 
 * This class includes all data about one induvidual chord
 */
public class SingleChordData
{
    // instance variables - replace the example below with your own
    private int relativeChordNumber;
    private int[] actualNotes;
    private ArrayList<Integer> theoreticalNotes;
    
    /**
     * Constructor for objects of class SingleChordData
     */
    public SingleChordData(int relativeChordNumber)
    {
        this.relativeChordNumber = relativeChordNumber;
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
    
    public void setTheoreticalNotes(ArrayList<Integer> theoreticalNotes)
    {
        this.theoreticalNotes = theoreticalNotes;
    }
    
    public ArrayList<Integer> getTheoreticalNotes()
    {
        return theoreticalNotes;
    }
}
