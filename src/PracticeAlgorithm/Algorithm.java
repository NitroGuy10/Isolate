package PracticeAlgorithm;

import MidiReader.*;

import java.io.File;
import java.util.ArrayList;

public class Algorithm {

    MIDIFile audio = new MIDIFile(new File("Midis/piano_etude.mid"));
    ArrayList<Note> notes = audio.getNotes();

    private ArrayList<Measure> getMeasures() {
        ArrayList<Measure> measures = new ArrayList<>();
        @SuppressWarnings({})
        int measureLength = notes.stream().mapToInt(Note::getLength).min().orElse(-1) * 16;
        int current = measureLength;
        ArrayList<Note> measureNotes = new ArrayList<>();
        for (Note n : notes) {
            measureNotes.add(n);
            if (n.getEndTime() >= current) {
                current += current;
                measures.add(new Measure(measureNotes));
                measureNotes.clear();
            }
        }
        if (!measureNotes.isEmpty()) {
            measures.add(new Measure(measureNotes));
        }
        return measures;
    }
    public static void main(String[] args) {

    }
}
