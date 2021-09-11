package PracticeAlgorithm;

import MidiReader.*;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.ArrayList;

public class Algorithm {

    MIDIFile audio = new MIDIFile(new File("Midis/imsickofquintuplets.mid"));
    ArrayList<Note> notes = audio.getTracks().get(0).getNotes();

    private ArrayList<Track> getMeasures() {
        int measureLength = notes.stream().mapToInt(Note::getLength).min().orElse(-1);

        return null;
    }
    public static void main(String[] args) {

    }
}
