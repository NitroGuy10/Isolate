package PracticeAlgorithm;
import MidiReader.Note;
import java.util.ArrayList;


public class Measure
{
    public ArrayList<Note> notes;
    public double rating = 0.0;

    public Measure(ArrayList<Note> measure)
    {
        notes = measure;
        getRating();
    }

    public ArrayList<Note> getMeasure() { return notes; }

    private void getRating()
    {
        rating = 0.0;
    }
    public static void main(String[] args)
    {
    }
}

