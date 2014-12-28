import java.util.ArrayList;
/**
 * A class containing all data about a scale. It can be passed to other classes to make sure specific objects are in the same scale. 
 * 
 * @author (Laurens op t Zandt) 
 * @version (1)
 */
public class Scale
{
    // This array contains all notes represented as a String value.
    public static final String[] NOTES = new String[] {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    //The keyOfSongNumber contains a number which represents the key of the song as a number.
    private int keyOfSongNumber;
    //The key of the song represented as a string
    private String keyOfSong;
    //An array List of Integer containing the integer values which represent the notes in the key
    private ArrayList<Integer> notesInKey;
    /**
     * Constructor for objects of class Scale. 
     * It creates a new scale and sets the notes which are in that scale which can be gotten by getNotesInKey()
     */
    public Scale()
    {
        keyOfSongNumber = RandomFunctions.randomInt(0,11);
        keyOfSong = NOTES[keyOfSongNumber];
        notesInKey = new ArrayList<Integer>();
        setNotes();
    }

    /**
     * This method sets the notes which are in the selected key
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
    
    /**
     * This method prints all the notes which are in the selected key.
     */
    public void printNotes()
    {
        for(int note : notesInKey)
        {
            System.out.println(NOTES[note]);
        }
    }
    
    /**
     * This method returns an array from notes displayed as String values
     */
    public String[] getAllNotes()
    {
        return NOTES;
    }
    
    /**
     * This method returns an array list of the theoretical notes which are in the selected key.
     */
    public ArrayList<Integer> getNotesInKey()
    {
        return notesInKey;
    }
}
