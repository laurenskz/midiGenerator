import java.util.ArrayList;
/**
 * Write a description of class AllChords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chords extends CreateChords
{
    // instance variables - replace the example below with your own
    private Scale scale;

    /**
     * Constructor for objects of class AllChords
     */
    public Chords()
    {
        super();
        scale = new Scale();
        createAllActualNotes();
        createAllTheoreticalNotes();
    }
    
    /**
     * Constructor for objects of class AllChords
     */
    public Chords(Scale scale)
    {
        super();
        this.scale = scale;
        createAllActualNotes();
        createAllTheoreticalNotes();
    }
    
    public Chords(Scale scale, int startChord, int lengthNumber, int endChord)
    {
        super(startChord, lengthNumber, endChord);
        this.scale = scale;
        createAllActualNotes();
        createAllTheoreticalNotes();
    }

    public void addChord(SingleChordData chord)
    {
        getChordProgression().add(chord);
    }
    
    private void createActualNotes(SingleChordData chord)
    {
        //Below an integer array is created in which the actual note values will be stored. It has 5 places to store a value because some chords have more 
        //than three notes, for example 7th chords, therefore it will be created having 5 storage spaces
        ArrayList<Integer> notesInKey = scale.getNotesInKey();
        int[] actualNotes = new int[7];
        int chordNumber = chord.getRelativeChordNumber();
        actualNotes[0] = notesInKey.get(chordNumber)+60;
        actualNotes[1] = notesInKey.get((MusicFunctions.resetBase(chordNumber+2)))+60;
        actualNotes[2] = notesInKey.get((MusicFunctions.resetBase(chordNumber+4)))+60;
        
        chord.setActualNotes(actualNotes);
    }
    
    private void createAllActualNotes()
    {
        for(SingleChordData chord : getChordProgression())
        {
            createActualNotes(chord);
        }
    }
    
    private void createTheoreticalNotes(SingleChordData chord)
    {
        ArrayList<Integer> theoreticalNotes = new ArrayList<>();
        int chordNumber = chord.getRelativeChordNumber();
        theoreticalNotes.add( MusicFunctions.resetBaseNormalNotes(chordNumber));
        theoreticalNotes.add(MusicFunctions.resetBaseNormalNotes(chordNumber + 2));
        theoreticalNotes.add(MusicFunctions.resetBaseNormalNotes(chordNumber + 4));
        chord.setTheoreticalNotes(theoreticalNotes);
    }
    
    private void createAllTheoreticalNotes()
    {
        for(SingleChordData chord : getChordProgression())
        {
            createTheoreticalNotes(chord);
        }
    }
    
    public void printChords()
    {
        for(SingleChordData fullChord : super.getChordProgression())
        {
            int chord = fullChord.getRelativeChordNumber();
            if(chord==1||chord==2||chord==5)
            {
                System.out.println(scale.getAllNotes()[scale.getNotesInKey().get(chord)]+"m");
            }else
            {
                System.out.println(scale.getAllNotes()[scale.getNotesInKey().get(chord)]);
            }
        }
    }
    
    public Scale getScale()
    {
        return scale;
    }
}
