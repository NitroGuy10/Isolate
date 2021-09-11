package MidiReader;

import java.io.File;

class Tester
{
    public static void main (String[] args)
    {
        MIDIFile midiFile = new MIDIFile(new File("Resources/Midis/piano_etude.mid"));
    }
}
