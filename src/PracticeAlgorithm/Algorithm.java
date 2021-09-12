package PracticeAlgorithm;

import MidiReader.*;

import java.io.File;
import java.util.ArrayList;

public class Algorithm {

    MIDIFile audio;
    ArrayList<Note> notes;

    public Algorithm(String path) {
        audio = new MIDIFile(new File(path));
        notes = audio.getNotes();
    }

    public Algorithm(ArrayList<Note> n) {
        notes = n;
    }

    public ArrayList<Measure> getMeasures() {
        ArrayList<Measure> measures = new ArrayList<>();
        int measureLength = notes.stream().mapToInt(Note::getLength).min().orElse(-1) * 16;
        int current = measureLength;
        ArrayList<Note> measureNotes = new ArrayList<>();
        for (Note n : notes) {
            measureNotes.add(n);
            if (n.getEndTime() >= current) {
                current += measureLength;
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
        Algorithm a = new Algorithm("Resources/Midis/piano_etude.mid");
        ArrayList<Measure> measures = a.getMeasures();
        System.out.println(measures.toString());
    }
}
