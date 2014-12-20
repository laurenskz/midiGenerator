import javax.sound.midi.*;
/**
 * Write a description of class TestLibrary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestLibrary
{
    public static void test() throws InvalidMidiDataException, MidiUnavailableException 
    {
        //You always start with a sequence, it stores tracks and contains the whole song.
        Sequence sequence = new Sequence(Sequence.PPQ,96);
        //Whith the sequencer you must create a track
        Track track1 = sequence.createTrack();
        //Shortmessages allow the actual midi data to be added, first the command, then the channel, then status byte 1 and 2
        ShortMessage m1 = new ShortMessage(ShortMessage.NOTE_ON,8,60,100);
        ShortMessage m2 = new ShortMessage(ShortMessage.NOTE_OFF,8,60,100);
        //These messages can be added to a track
        track1.add(new MidiEvent(new ShortMessage(192,8,22,0),0));
        track1.add(new MidiEvent(m1,0));
        int i = 0;
        for(i = 96; i<=5000 ; i+=96)
        {
            track1.add(new MidiEvent(m2,i));
            track1.add(new MidiEvent(m1,i));
        }
        i+=96;
        track1.add(new MidiEvent(m2,i));
        //A sequencer is capable of playing back a sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        //A sequence has to be assigned to a sequencer
        sequencer.setSequence(sequence);
        //It has to be opened
        sequencer.open();
        //And can than be played
        sequencer.start();
    }
}
