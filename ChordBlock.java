import java.util.*;
/**
 * Write a description of class ChordBlock here.
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChordBlock extends Block
{
    private Chords chords;
    private int times;
    private ChordDurationGenerator durationGenerator;
    //This hashmap serves more for other classes to ask at what pulse what chord is playing.
    private TreeMap<Integer, ChordDuration> data;
    //This one contains all information nessacary to play the music.
    private TreeMap<Integer, ArrayList<RawHardNotes>> rawHardData;
    
    /**
     * Constructor for objects of class ChordBlock
     * 
     * The integer times will not be processed in this class but has to be passed to here. It will be given later to classes that actually place all the notes
     */
    public ChordBlock(int startTime, Chords chords, int times)
    {
        super(startTime);
        this.times = times;
        durationGenerator = new ChordDurationGenerator(chords);
        this.chords = chords;
        data = new TreeMap<>();
        rawHardData = new TreeMap<>();
        setGlobalLayout();
    }
    
    public ChordBlock(Scale scale)
    {
        super(0);
        times = 1;
        Chords chords = new Chords(scale);
        this.chords = chords;
        durationGenerator = new ChordDurationGenerator(chords);
        data = new TreeMap<>();
        rawHardData = new TreeMap<>();
        setGlobalLayout();
    }
    
    private void setGlobalLayout()
    {
        //This(startTime) will always be 0
        int time = getStartTime();
        for(ChordDuration chord : durationGenerator.generateDuration())
        {
            data.put(time,chord);
            time += chord.getDuration();
        }
        setEndTime(time);
    }
    
    public void printData()
    {
        for(Map.Entry<Integer, ChordDuration> set: data.entrySet())
        {
            ChordDuration chord = set.getValue();
            int time = set.getKey();
            
            System.out.println(time +": " + chord.getChord());
        }
    }
    
    public void printCompleteData()
    {
        for(Map.Entry<Integer, ArrayList<RawHardNotes>> set: rawHardData.entrySet())
        {
            int time = set.getKey();
            ArrayList<RawHardNotes> notesTemp = set.getValue();
            String tempNoteString = "";
            for(RawHardNotes tempNote1 : notesTemp)
            {
                tempNoteString += "(" + tempNote1.getActualNote() + " " + tempNote1.getNoteVelocity() + ")" + " ";
            }
            System.out.println(time +": " + tempNoteString);
        }
        System.out.println(rawHardData.size());
    }
    
    public Chords getChords()
    {
        return chords;
    }
    
    public void getRollingPiano()
    {
        PianoModesGenerator pianoModesGenerator = new PianoModesGenerator(data, chords);
        rawHardData = pianoModesGenerator.getRollingPiano();
    }
    
    public TreeMap<Integer, ArrayList<RawHardNotes>> getAllDataNotes()
    {
        return rawHardData;
    }
    
    public TreeMap<Integer, ChordDuration> getTheoreticalData()
    {
        return data;
    }
}
