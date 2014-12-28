import java.util.*;
/**
 * Write a description of class PianoModesGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PianoModesGenerator
{
    private Random random; 
    //The data to be processed
    private TreeMap<Integer, ChordDuration> data;
    private TreeMap<Integer, ArrayList<RawHardNotes>> actualNotes;
    private Chords chords;
    private static final int LOW_BOUNDARY_FOR_MID_CHORD =  45;
    private static final int HIGH_BOUNDARY_FOR_MID_CHORD =  100;
    private static final int MIN_VELOCITY_VALUE = 50;
    private static final int MAX_VELOCITY_VALUE = 90;
    private static final int[] possibleNoteDurations = new int[] {24,48,96,192};
    private static final int MIN_NUMBER_OF_NOTES = 1;
    private static final int MAX_NUMBER_OF_NOTES = 3;
    
    public PianoModesGenerator(TreeMap<Integer, ChordDuration> data, Chords chords)
    {
        this.data = data;
        this.chords = chords;
        actualNotes = new TreeMap<>();
        random = new Random();
        createSpecificChordDuration();
        fillDurationWithNotes();
    }
    
    public TreeMap<Integer, ArrayList<RawHardNotes>> getRollingPiano()
    {
        return actualNotes;
    }
    
    private void createSpecificChordDuration()
    {
        //iterate throught the objects for 1 chord progression (the block may consist of the same chord progression played more than 1 time)
        for(Map.Entry<Integer, ChordDuration>  entry : data.entrySet())
        {
            createOneChordDuration(entry);
        }
    }
    
    private int createOneChordDuration(Map.Entry<Integer, ChordDuration>  entry)
    {
        int currentTime = entry.getKey();
        int endTime = currentTime+ entry.getValue().getDuration();
        SingleChordData chord = entry.getValue().getChord();entry.getValue();
        while(currentTime<endTime)
        {
            int testIndexForLength = getWhatDurationsArePossible(currentTime, endTime);
            //No note duration will be good so the method has to stop, do so by returning 0
            if(testIndexForLength == -1)
            {
                return 0;
            }
            //Get how many notes should be playing starting at this point, the notes will all be given a random duration.
            //Then the virtual 'place' where this 'cursor' is will be continued by a random amount which will not be bigger than the longest note.
            int numberOfNotes = random.nextInt(MAX_NUMBER_OF_NOTES-MIN_NUMBER_OF_NOTES+1)+MIN_NUMBER_OF_NOTES;
            int[] temporaryNoteArray = new int[numberOfNotes];
            //Create a TreeMap entry to store the notes
            actualNotes.put(currentTime, new ArrayList<>());
            for(int x = 0 ; x<numberOfNotes; x++)
            {
                int noteLength = possibleNoteDurations[random.nextInt(testIndexForLength+1)];
                temporaryNoteArray[x] = noteLength;
                actualNotes.get(currentTime).add(new RawHardNotes(currentTime, currentTime + noteLength, chord));
            }
            currentTime+=temporaryNoteArray[random.nextInt(temporaryNoteArray.length)];
        }
        return 0;
    }
    
    /**
     * Get what value wouldnt be longer than the time for the chord
     */
    private int getWhatDurationsArePossible(int currentTime, int endTime)
    {
        int testIndexForLength = possibleNoteDurations.length-1;
        while(currentTime + possibleNoteDurations[testIndexForLength]>endTime)
        {
            testIndexForLength--;
            if(testIndexForLength==-1)
            {
                return -1;
            }
        }
        return testIndexForLength;
    }
    
    /**
     * A nice feature about this method is that it takes in account note velocity. That makes the song a lot better.
     */
    private void fillDurationWithNotes()
    {
        //Make a loop to fill the empty objects with raw hard notes
        for(Map.Entry<Integer, ArrayList<RawHardNotes>> entry : actualNotes.entrySet())
        {
            defaultAction(entry);
        }
    }
    
    private SpecialPoint getNoteType(int noteTime)
    {
        if(data.get(noteTime)!=null)
        {
            return SpecialPoint.START_OF_CHORD;
        }
        
        return SpecialPoint.NO_SPECIAL_POINT;
    }
    
    private void doActionBasedOnNoteType(SpecialPoint TYPE, Map.Entry<Integer, ArrayList<RawHardNotes>> entry)
    {
        switch(TYPE)
        {
            case START_OF_CHORD :
                defaultAction(entry);
            break;
            
            case NO_SPECIAL_POINT:
                defaultAction(entry);            
            break;
        }
    }
    
    private void doActionStartOfChord(Map.Entry<Integer, ArrayList<RawHardNotes>> entry)
    {
        
    }
    
    /**
     * This method rests on a principal, notes are sorted into categories, there is a max and min note value, and the piece in between these to is divided into
     * multiple pieces equal to the number of notes there are.
     */
    private void defaultAction(Map.Entry<Integer, ArrayList<RawHardNotes>> entry)
    {
        int numberOfNotes = entry.getValue().size();
        int rangeAllNotes = HIGH_BOUNDARY_FOR_MID_CHORD - LOW_BOUNDARY_FOR_MID_CHORD;
        double rangePerNote = rangeAllNotes/numberOfNotes;
        int[][] rangesIndividualNotes = new int[numberOfNotes][2];
        int cumulativeRange = LOW_BOUNDARY_FOR_MID_CHORD;
        for(int j = 0 ; j<rangesIndividualNotes.length;j++)
        {
            rangesIndividualNotes[j][0] = cumulativeRange;
            cumulativeRange += rangePerNote;
            rangesIndividualNotes[j][1] = cumulativeRange;
        }
        
        for(int i = 0 ; i<numberOfNotes; i++)
        {
            RawHardNotes note = entry.getValue().get(i);
            note.setNoteVelocity(RandomFunctions.randomInt(MIN_VELOCITY_VALUE,MAX_VELOCITY_VALUE));
            ArrayList<Integer> notes = note.getMotherChord().getTheoreticalNotes();
            ArrayList<Integer> notesInKey = chords.getScale().getNotesInKey();
            int theoreticalSelectedNote = notes.get(random.nextInt(notes.size()));
            int actualSelectedNote = notesInKey.get(theoreticalSelectedNote);
            
            while(actualSelectedNote<rangesIndividualNotes[i][0])
            {
                actualSelectedNote += 12;
            }
            note.setActualNote(actualSelectedNote);
            
        }
    }
    
    private void createMultipleTimes()
    {
        
    }
}