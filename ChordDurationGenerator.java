import java.util.*;
/**
 * Write a description of class ChordDurationGenerator here.
 * This class takes as input 
 */
public class ChordDurationGenerator
{
    // instance variables - replace the example below with your own
    private int numberOfChords;
    private Chords chords;
    private int[] possibleDurations;
    private int[] chanceOfDurations;
    /**
     * Constructor for objects of class ChordDurationGenerator
     */
    public ChordDurationGenerator(Chords chords)
    {
        numberOfChords = chords.getChordProgression().size();
        this.chords = chords;
        possibleDurations = new int[] {96,192,384};
        chanceOfDurations = new int[] {0,0,100};
    }
    
    public ArrayList<ChordDuration> generateDuration()
    {
        ArrayList<ChordDuration> finalChordsWithDuration = new ArrayList<>();
        for(SingleChordData chord : chords.getChordProgression())
        {
            int lengthOfThisChordIndex = RandomFunctions.odds(chanceOfDurations);
            ChordDuration chordWithDuration = new ChordDuration(chord, possibleDurations[lengthOfThisChordIndex]);
            finalChordsWithDuration.add(chordWithDuration);
        }
        return finalChordsWithDuration;
    }
}
