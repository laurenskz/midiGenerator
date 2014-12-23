import java.util.*;
/**
 * This class creates a strum pattern to be played by guitar chords. It creates a specific strum pattern for each duration of chord. A boolean can be set to use the same
 * starting pattern for shorter chords as was used for the longer chords.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuitarStrumGenerator
{
    private Random random; 
    //The data to be processed
    private TreeMap<Integer, ChordDuration> data;
    private TreeMap<Integer, ArrayList<RawHardNotes>> actualNotes;
    private Chords chords;
    private Scale scale;
    private boolean sameChordsForAll;
    private HashMap<Integer, ArrayList<Strum>> strumPatterns;
    private static final int MIN_VELOCITY_VALUE = 40;
    private static final int MAX_VELOCITY_VALUE = 90;
    //The downstroke is added via if else statement and so only at one of the chances will be looked.
    private static final double DOWN_STROKE_CHANCE = 0.50;
    private static final double UP_STROKE_CHANCE = 0.50;
    private static final int STARTING_OCTAVE = 48;
    private static final int[] POSSIBLE_STRUM_DURATIONS = new int[] {48,96};
    
    public GuitarStrumGenerator(TreeMap<Integer, ChordDuration> data, Chords chords)
    {
        this.data = data;
        this.chords = chords;
        scale = chords.getScale();
        actualNotes = new TreeMap<>();
        random = new Random();
        scale = chords.getScale();
        sameChordsForAll = false;
        strumPatterns = new HashMap<>();
    }
    
    private ArrayList<Integer> getTheoreticalGuitarChord(SingleChordData chord)
    {
        ArrayList<Integer> tempNoteArray = new ArrayList<>();
        int noteInChordNumber = chord.getTheoreticalNotes().get(0);
        tempNoteArray.add(noteInChordNumber);
        noteInChordNumber = MusicFunctions.resetBaseNormalNotes(noteInChordNumber + 4);
        tempNoteArray.add(noteInChordNumber);
        noteInChordNumber = MusicFunctions.resetBaseNormalNotes(noteInChordNumber + 3);
        tempNoteArray.add(noteInChordNumber);
        noteInChordNumber = MusicFunctions.resetBaseNormalNotes(noteInChordNumber + 2);
        tempNoteArray.add(noteInChordNumber);
        noteInChordNumber = MusicFunctions.resetBaseNormalNotes(noteInChordNumber + 2);
        tempNoteArray.add(noteInChordNumber);
        noteInChordNumber = MusicFunctions.resetBaseNormalNotes(noteInChordNumber + 3);
        tempNoteArray.add(noteInChordNumber);
        return tempNoteArray;
    }
    
    private ArrayList<Integer> getPracticalGuitarChord(ArrayList<Integer> theoreticalChord)
    {
        int lastNote = 0;
        ArrayList<Integer> notesToReturn = new ArrayList<Integer>();
        for(int theoreticalNote : theoreticalChord)
        {
            int noteToAdd = scale.getNotesInKey().get(theoreticalNote);
            noteToAdd += STARTING_OCTAVE;
            while(noteToAdd <= lastNote)
            {
                noteToAdd += 12;
            }
            lastNote = noteToAdd;
            notesToReturn.add(noteToAdd);
        }
        return notesToReturn;
    }
    
    private void generateStrumPattern()
    {
        for(ChordDuration chord : data.values())
        {
            if(strumPatterns.get(chord.getDuration())==null)
            {
                createNewStrumPattern(chord.getDuration());
            }
        }
    }
    
    private void createNewStrumPattern(int duration)
    {
        int currentTime = 0;
        ArrayList<Strum> strums = new ArrayList<>();
        strumPatterns.put(duration, strums);
        //a simple counter to provide the possibility to stretch the last note till the end so that it is covered nicely
        int counter = 0;
        while(currentTime<duration)
        {
            int currentStrumTime = POSSIBLE_STRUM_DURATIONS[random.nextInt(POSSIBLE_STRUM_DURATIONS.length)];
            if(currentStrumTime+currentTime>duration)
            {
                //The new strum time value must not be added
                break;
                //The last strum will be lenghtened
            }else
            {
                //Add it with a random up or down stroke
                StrumType strumType = null;
                if(random.nextDouble()<=DOWN_STROKE_CHANCE)
                {
                    strumType = StrumType.DOWNSTROKE;
                }
                else
                {
                    strumType = StrumType.UPSTROKE;
                }
                
                strums.add(new Strum(strumType, currentStrumTime));
                
            }
            counter++;
        }
    }
    
    private void makeAllData()
    {
            
    }
    
}
