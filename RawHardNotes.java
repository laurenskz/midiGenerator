
/**
 * Write a description of class RawHardNotes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RawHardNotes
{
    private int actualNote;
    private int velocity;
    private int noteStartTime;
    private int noteEndTime;
    private SingleChordData motherChord;
    
    public RawHardNotes(int actualNote, int noteEndTime)
    {
        this.actualNote = actualNote;
        this.noteEndTime = noteEndTime;
    }
    
    //Nonsense variable to define second constructor
    public RawHardNotes(int noteStartTime, int noteEndTime, SingleChordData motherChord)
    {
        this.noteEndTime = noteEndTime;
        this.noteStartTime = noteStartTime;
        this.motherChord = motherChord;
    }
    
    public void setActualNote(int actualNote)
    {
        this.actualNote = actualNote;
    }
    
    public int getActualNote()
    {
        return actualNote;
    }
    
    public void setNoteEndTime(int noteEndTime)
    {
        this.noteEndTime = noteEndTime;
    }
    
    public int getNoteEndTime()
    {
        return noteEndTime;
    }
    
    public int getNoteVelocity()
    {
        return velocity;
    }
    
    public void setNoteVelocity(int velocity)
    {
        this.velocity = velocity;
    }
    
    public SingleChordData getMotherChord()
    {
        return motherChord;
    }
    
    public void setMotherChord(SingleChordData motherChord)
    {
        this.motherChord = motherChord;
    }
    
    public int getNoteStartTime()
    {
        return noteStartTime;
    }
}
