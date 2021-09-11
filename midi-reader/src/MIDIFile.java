import java.io.*;
import java.util.ArrayList;

public class MIDIFile
{
	private ArrayList<Track> tracks;
	
	public MIDIFile (File midiFile)
	{
		// TODO TEMPORARY
		
		Note note = new Note();
		ArrayList<Note> notes = new ArrayList<>();
		notes.add(note);
		notes.add(note);
		
		Track track = new Track(0, notes);
		
		tracks.add(track);
	}
	
	public ArrayList<Track> getTracks ()
	{
		return tracks;
	}
}
