import java.util.ArrayList;
/**
 * This class creates an arrayList of chordNumbers, they are pseudo randomly generated and should in theory sound good.
 * 
 * I-VII is represented as 0-6 (Integer)
 * The VII is never used because it doesnt sound very good
 * Note, for this class an ArrayList is
 * endChord can be set to -15 if the ending chord desired does not matter.
 * @author (Laurens op t Zandt) 
 * @version (1)
 */
public class CreateChords
{
    //The start chord is the first chord in the chord progression, it is important to note that this is relative e.g I-VI. it is not a note, this can be done later.
    private int startChord;
    //The actual list of chord numbers.
    protected ArrayList<SingleChordData> chordProgression;
    //How many chords long the progression has to be.
    private int lengthNumber;
    //What relative end chord number (I-VII)
    private int endChord;
    
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 12;

    /**
     * Constructor for objects of class CreateChordProgression
     * It creates an arrayList with chordNumbers
     */
    public CreateChords()
    {
        startChord = RandomFunctions.randomInt(0,0);
        lengthNumber = RandomFunctions.randomInt(MIN_LENGTH, MAX_LENGTH);
        endChord = 0;
        chordProgression = new ArrayList<SingleChordData>();
        create();
    }
    
    /**
     * Creates the chord number progression.
     */
    public void create()
    {
        //This loop rests on the principal of strong and weak chord progressions.
        //It adds a number to the previous chord and thus the next chord is determined.
        do
        {
            chordProgression.clear();
            chordProgression.add(new SingleChordData(startChord));
            //A simple counter below, just in case something has to be measured
            int counter = 0;
            int keyFinalArray = 0;
            while(chordProgression.size()!=lengthNumber)
            {
                int lastNote = chordProgression.get(chordProgression.size()-1).getRelativeChordNumber();
                if(lastNote == 0 && counter < lengthNumber-2)
                {
                    chordProgression.add(new SingleChordData(RandomFunctions.randomInt(1,5)));
                }else{
                    if(lastNote==1)
                    {
                        keyFinalArray = RandomFunctions.odds(new int[] {50,50});
                    }else if(lastNote==3)
                    {
                        keyFinalArray = RandomFunctions.odds(new int[] {33,0,34,33});
                    }else if(lastNote==5)
                    {
                        keyFinalArray = RandomFunctions.odds(new int[] {0,50,50});
                    }else
                    {
                        keyFinalArray = RandomFunctions.odds(new int[] {33,33,34});
                    }
                    int[] addToChord = new int[] {1,3,5,0};
                    chordProgression.add(new SingleChordData(MusicFunctions.resetBase(lastNote+addToChord[keyFinalArray])));
                }
                counter++;
            }
            if(endChord == -15)
            {
                endChord = chordProgression.get(lengthNumber-1).getRelativeChordNumber();
            }
        }while(chordProgression.size()!=lengthNumber||chordProgression.get(lengthNumber-1).getRelativeChordNumber()!=endChord);
    }
    
    /**
     * Determines how long the chord progression has to be
     */
    public void setLength(int length)
    {
        lengthNumber = length;
        create();
    }
    
    /**
     * Returns the size of the chord progression
     */
    public int getSize()
    {
        return chordProgression.size();
    }
    
    /**
     * Returns the chord at the specified index, if the specified index is valid.
     */
    public int getChord(int index)
    {
        if(index>=0&&index<chordProgression.size())
        {
            return chordProgression.get(index).getRelativeChordNumber();
        }else
        {
            return -15;
        }
    }
    
    /**
     * Returns the arrayList of chordnumbers
     */
    public ArrayList<SingleChordData> getChordProgression()
    {
        return chordProgression;
    }
}
