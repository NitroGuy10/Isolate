package PracticeAlgorithm;
import MidiReader.MIDIFile;
import MidiReader.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;


public class Measure
{
    private final ArrayList<Note> notes;
    private double rating = 0.0;

    public Measure(ArrayList<Note> measure)
    {
        notes = measure;
        rate();
    }

    public ArrayList<Note> getMeasure() { return notes; }

    public double getRating() { return rating; }

    private void rate()
    {
        rating = notes.size();

        List<Integer> pitches = notes.stream().map(Note::getPitch).collect(Collectors.toList());
        double pitch_num = 0.0;

        for(int i = 0; i < pitches.size() - 1; i++)
        {
            pitch_num += pitches.get(i) - pitches.get(i + 1);
        }

        pitch_num /= pitches.size();
        rating += pitch_num;

        for (Integer pitch : pitches)
        {
            if ((pitch + 30) % 60 == 0)
            {
                rating += 1;
            }
        }
    }

    @Override
    public String toString()
    {
        return "Measure Notes: " + notes + "\n Measure rating: " + rating;
    }

    public static void main(String[] args)
    {
    }
}

