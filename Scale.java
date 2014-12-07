import java.util.ArrayList;
/**
 * Write a description of class Scale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scale
{
    // instance variables - replace the example below with your own
    private final String[] notes;
    private int keyOfSongNumber;
    private String keyOfSong;
    private ArrayList<Integer> notesInKey;
    /**
     * Constructor for objects of class Scale
     */
    public Scale()
    {
        notes = new String[] {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
        keyOfSongNumber = RandomFunctions.randomInt(0,11);
        keyOfSong = notes[keyOfSongNumber];
        notesInKey = new ArrayList<Integer>();
        setNotes();
    }

    /**
     * 
     */
    public void setNotes()
    {
        notesInKey.clear();
        notesInKey.add(keyOfSongNumber);
        int tempNoteStorer = keyOfSongNumber;
        for(int counter = 1; counter<=7; counter++)
        {
            if(counter==3||counter==7)
            {
                tempNoteStorer = MusicFunctions.resetBaseForAllNotes(tempNoteStorer+1);
            }else
            {
                tempNoteStorer = MusicFunctions.resetBaseForAllNotes(tempNoteStorer+2);
            }
            notesInKey.add(tempNoteStorer);
        }
    }
    
    public void printNotes()
    {
        for(int note : notesInKey)
        {
            System.out.println(notes[note]);
        }
    }
    
    public void setKey(int key)
    {
        keyOfSongNumber = key;
        setNotes();
    }
    
    public String[] getAllNotes()
    {
        return notes;
    }
    
    public ArrayList<Integer> getNotesInKey()
    {
        return notesInKey;
    }
}
