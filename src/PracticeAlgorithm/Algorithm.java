package PracticeAlgorithm;

import MidiReader.*;
import java.io.File;
import java.util.ArrayList;

public class Algorithm {

    MIDIFile audio = new MIDIFile(new File("Midis/imsickofquintuplets.mid"));
    ArrayList<Track> measures;

    private void getMeasures() {

    }

    private double getDifficulty() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
