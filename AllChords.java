import java.util.ArrayList;
/**
 * Write a description of class AllChords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllChords
{
    // instance variables - replace the example below with your own
    private CreateChords chordNumbers;
    private ArrayList<SingleChordData> chords;
    private Scale scale;

    /**
     * Constructor for objects of class AllChords
     */
    public AllChords()
    {
        chords = new ArrayList<>();
        scale = new Scale();
        chordNumbers = new CreateChords();
        createTimeLayout();
        createAllActualNotes();
    }

    public void addChord(SingleChordData chord)
    {
        chords.add(chord);
    }
    
    
    private void createTimeLayout()
    {
        int noteOnTime = 0;
        int noteOffTime = 0;
        int[] times = new int[] {192, 384};
        for(int i = 0; i< chordNumbers.getSize();i++)
        {
            int chance = RandomFunctions.odds(new int[] {50,50});
            noteOffTime += times[chance];
            addChord(new SingleChordData(chordNumbers.getChord(i),noteOnTime, noteOffTime));
            noteOnTime += times[chance];
        }
    }
    
    private void createActualNotes(SingleChordData chord)
    {
        //Below an integer array is created in which the actual note values will be stored. It has 5 places to store a value because some chords have more 
        //than three notes, for example 7th chords, therefore it will be created having 5 storage spaces
        ArrayList<Integer> notesInKey = scale.getNotesInKey();
        int[] actualNotes = new int[5];
        int chordNumber = chord.getRelativeChordNumber();
        actualNotes[0] = notesInKey.get(chordNumber)+60;
        actualNotes[1] = notesInKey.get((MusicFunctions.resetBase(chordNumber+2)))+60;
        actualNotes[2] = notesInKey.get((MusicFunctions.resetBase(chordNumber+4)))+60;
        
        chord.setActualNotes(actualNotes);
    }
    
    private void createAllActualNotes()
    {
        for(SingleChordData chord : chords)
        {
            createActualNotes(chord);
        }
    }
    
    public void printChords()
    {
        for(int chord : chordNumbers.getChordProgression())
        {
            if(chord==1||chord==2||chord==5)
            {
                System.out.println(scale.getAllNotes()[scale.getNotesInKey().get(chord)]+"m");
            }else
            {
                System.out.println(scale.getAllNotes()[scale.getNotesInKey().get(chord)]);
            }
        }
    }
}
