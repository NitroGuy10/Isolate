package PracticeAlgorithm;
import MidiReader.Note;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Measure
{
    private final ArrayList<Note> notes;
    private double rating = 0.0;
    private double note_freq = 0.0;
    private double note_changes = 0.0;
    private double syncopation = 0.0;
    private double chords = 0.0;
    private String practice_time = "";

    public Measure(ArrayList<Note> measure)
    {
        notes = measure;
        rate();
        practice();
    }

    public ArrayList<Note> getMeasure() { return notes; }

    public double getRating() { return rating; }

    public String getTimes() { return practice_time; }

    private void rate()
    {
        note_freq = notes.size();
       /** int chord_count = 0;
        for(int i = 0; i < notes.size(); i++)
        {
            for(int j = 0; j < notes.size(); i++)
            {
                if(notes.get(i).equals(notes.get(j)))
                {
                    continue;
                }
                //if(notes.get(i).)
            }
        }
        */

        List<Integer> pitches = notes.stream().map(Note::getPitch).collect(Collectors.toList());
        double pitch_num = 0.0;

        for(int i = 0; i < pitches.size() - 1; i++)
        {
            pitch_num += pitches.get(i) - pitches.get(i + 1);
        }

        pitch_num /= pitches.size();
        note_changes = pitch_num;

        for (Integer pitch : pitches)
        {
            if ((pitch + 30) % 60 == 0)
            {
                syncopation += 1;
            }
        }

        rating = note_freq + note_changes + syncopation;
    }

    public void practice()
    {
        if(rating <= 5)
        {
            practice_time = "< 5 minutes";
        }
        else if(rating <= 10)
        {
            practice_time = "5-10 minutes";
        }
        else if(rating <= 20)
        {
            practice_time = "10-30 minutes";
        }
        else
        {
            practice_time = "30+ minutes";
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

