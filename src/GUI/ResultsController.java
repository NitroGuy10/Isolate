package GUI;

import MidiReader.MIDIFile;
import javafx.event.ActionEvent;
import PracticeAlgorithm.*;
import javafx.scene.control.Label;

import java.io.File;
import java.util.ArrayList;


public class ResultsController {

    private Algorithm algorithm = new Algorithm(Main.URL);
    private ArrayList<Measure> measures = algorithm.getMeasures();
    private ArrayList<String> getTimes = (ArrayList<String>)algorithm.getTimes();
    private ArrayList<double[]> ratings = (ArrayList<double[]>) algorithm.getRatings();


    public Label label1;

    public void initialize(){
        String firstBox = "First Measure\n\n" + toStrings(getTimes, ratings.get(0));
        label1.setText(firstBox);
    }

    public String toStrings(ArrayList<String> times, double[] rating){
        String string = "";

        string += "Practice for" + times + " minutes";
        string += "Fingering Difficulty Rating of " + rating[0] + "\n";
        string += "Pitch / Intonation Difficulty Rating of " + rating[1] + "\n";
        string += "Rhythm Difficulty Rating of " + rating[2] + "\n";
        string += "Overall Difficulty Rating of " + rating[3] + "\n";

        return string;
    }

    public void buttonOne(ActionEvent actionEvent) {

        MIDIFile mf = new MIDIFile(new File(Main.URL));
        MIDIFile.playMeasure(measures.get(0).getMeasure());
    }
}
