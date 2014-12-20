import javax.sound.midi.*;
import java.util.*;
/**
 * Write a description of class SongGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SongGenerator
{
    private Song song;
    private Scale scale;
    private static final int INSTRUMENT = 0;
    /**
     * Constructor for objects of class SongGenerator
     */
    public SongGenerator() throws InvalidMidiDataException, MidiUnavailableException 
    {
        song = new Song();
        scale = new Scale();
        makeChords();
        song.playSong();
    }
    
    private void makeChords() throws InvalidMidiDataException, MidiUnavailableException 
    {
        ChordBlock chordBlock = new ChordBlock(scale);
        chordBlock.getRollingPiano();
        Track track1 = song.getNewTrack();
        track1.add(new MidiEvent(new ShortMessage(192,8,INSTRUMENT,0),0));
        for(ArrayList<RawHardNotes> notes : chordBlock.getAllDataNotes().values())
        {
            for(RawHardNotes note: notes)
            {
                ShortMessage noteOnMessage = new ShortMessage(ShortMessage.NOTE_ON,8,note.getActualNote(),note.getNoteVelocity());
                ShortMessage noteOffMessage = new ShortMessage(ShortMessage.NOTE_OFF,8,note.getActualNote(),note.getNoteVelocity());
                track1.add(new MidiEvent(noteOnMessage,note.getNoteStartTime()));
                track1.add(new MidiEvent(noteOffMessage,note.getNoteEndTime()));
            }
        }
        
    }
    
    public void playAgain() throws InvalidMidiDataException, MidiUnavailableException 
    {
        song.playSong();
    }
}
