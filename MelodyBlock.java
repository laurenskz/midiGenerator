import java.util.*;
public class MelodyBlock extends Block
{
    private ChordBlock chordBlock;
    private TreeMap<Integer, ArrayList<RawHardNotes>> rawHardData;
    public MelodyBlock(ChordBlock chordBlock)
    {
        super(0);
        this.chordBlock = chordBlock;
    }
    
    private void setMelody()
    {
        MelodyGenerator melodyGenerator = new MelodyGenerator(chordBlock.getTheoreticalData());
    }
}