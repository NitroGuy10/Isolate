package PracticeAlgorithm;
import MidiReader.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.DoubleSummaryStatistics;


public class Measure
{
    private ArrayList<Note> notes;
    private double rating = 0.0;

    public Measure(ArrayList<Note> measure)
    {
        notes = measure;
        getRating();
    }

    public ArrayList<Note> getMeasure() { return notes; }

    private void getRating()
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

        for(int i = 0; i < pitches.size(); i++)
        {
            if((pitches.get(i) + 30) % 60 == 0)
            {
                rating += 1;
            }
        }
    }
    public static void main(String[] args)
    {

    }
}

