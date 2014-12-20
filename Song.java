import javax.sound.midi.*;
/**
 * Write a description of class Song here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Song
{
    // instance variables - replace the example below with your own
    private Sequence sequence;
    private Sequencer sequencer;

    /**
     * Constructor for objects of class Song
     */
    public Song() throws InvalidMidiDataException, MidiUnavailableException 
    {
        sequence = new Sequence(Sequence.PPQ,96);
        sequencer = MidiSystem.getSequencer();
    }
    
    public Track getNewTrack()
    {
        return sequence.createTrack();
    }
    
    public void playSong() throws InvalidMidiDataException, MidiUnavailableException
    {
        sequencer.setSequence(sequence);
        sequencer.open();
        sequencer.start();
    }
    
    public void resetPlay()
    {
        sequencer.setTickPosition(0);
        sequencer.close();
    }
}
