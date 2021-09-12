package MidiReader;

import java.io.File;

class Tester
{
    public static void main (String[] args)
    {
        MIDIFile midiFile = new MIDIFile(new File("Resources/Midis/imsickofquintuplets.mid"));

        for (Note n : midiFile.getNotes())
        {
            System.out.print(n.toMinString());
        }

        NoteDisplay.DisplayNotes(midiFile.getNotes());
    }
}
