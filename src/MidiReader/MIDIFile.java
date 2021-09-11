package MidiReader;

import java.io.*;
import java.util.ArrayList;

public class MIDIFile
{
	private ArrayList<Track> tracks;
	private String timeSignature;
	private int tempo;
	
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

	public int getTempoBPM ()
	{
		return 60000000 / tempo;
	}
	
	public ArrayList<Track> getTracks ()
	{
		return tracks;
	}
}
