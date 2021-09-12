package PracticeAlgorithm;

import MidiReader.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {

    MIDIFile audio;
    static ArrayList<Note> notes;
    static ArrayList<Measure> measures;

    public Algorithm(String path) {
        audio = new MIDIFile(new File(path));
        notes = audio.getNotes();
        measures = getMeasures();
    }

    public static ArrayList<Measure> getMeasures() {
        ArrayList<Measure> measures = new ArrayList<>();
        int measureLength = notes.stream().mapToInt(Note::getLength).min().orElse(-1) * 16;
        int current = measureLength;
        ArrayList<Note> measureNotes = new ArrayList<>();
        for (Note n : notes) {
            measureNotes.add(n);
            if (n.getEndTime() >= current) {
                current += measureLength;
                measures.add(new Measure(new ArrayList<>(measureNotes)));
                measureNotes.clear();
            }
        }
        if (!measureNotes.isEmpty()) {
            measures.add(new Measure(measureNotes));
        }
        return measures;
    }

    public static List<String> getTimes() {
        return measures.stream().map(Measure::getTimes).collect(Collectors.toList());
    }

    public static List<double[]> getRatings() {
        return measures.stream().map(x -> new double[] {x.getFrequency(), x.getChanges(), x.getSyncopation(), x.getRating()}).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Algorithm a = new Algorithm("Resources/Midis/piano_etude.mid");
        System.out.println(a.notes.size());
        ArrayList<Measure> measures = a.getMeasures();
        System.out.println(measures.size());
        for (Measure m : measures) {
            System.out.println(m);

//            NoteDisplay.DisplayNotes(m.getMeasure());
        }
//        MIDIFile.playMeasure(measures.get(3).getMeasure());

    }
}
