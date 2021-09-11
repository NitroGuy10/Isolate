package MidiReader;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class MIDIFile
{
	private int instrument;
	private ArrayList<Note> notes;
	private String timeSignature;
	private int tempo;

	
	public MIDIFile (File midiFile)
	{
		File csvFile = new File("Resources/temp/csv");

		try
		{
			int generateCSVReturn = generateCSV(midiFile, csvFile);
			if (generateCSVReturn != 0)
			{
				System.out.println("Error generating CSV file!");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error running MIDICSV!");
			e.printStackTrace();
			System.exit(1);
		}

		Scanner tempoFinder = new Scanner(System.in);
		try {
			tempoFinder = new Scanner(csvFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("CSV file not found!");
			e.printStackTrace();
			System.exit(1);
		}
		tempoFinder.nextLine();
		while (tempoFinder.hasNextLine())
		{
			String line = tempoFinder.nextLine();
			if (line.split(", ")[2].contains("Tempo"))
			{
				tempo = Integer.parseInt(line.split(", ")[3]);
			}
		}
		// If no tempo information is found, tempo will equal 500,000
		tempoFinder.close();
		System.out.println("Tempo: " + tempo);


		Scanner trackFinder = new Scanner(System.in);
		String trackContents = "";
		final String desiredTrack = "3";
		try {
			trackFinder = new Scanner(csvFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("CSV file not found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (trackFinder.hasNextLine())
		{
			String line = trackFinder.nextLine();
			if (line.split(", ")[0].equals(desiredTrack) && line.split(", ")[2].contains("Start_track"))
			{
				trackContents = line;
				while (trackFinder.hasNextLine())
				{
					String nextLine = trackFinder.nextLine();
					trackContents += "\n" + nextLine;
					if (nextLine.contains("End_track"))
					{
						break;
					}
				}
				trackContents += "\n-1, -1, Note_off_c, -1, -1, -1";
			}
		}
		trackFinder.close();
		System.out.println("Track information stored");

		// TODO TEMPORARY
		
		Note note = new Note();
		Note note1 = new Note();
		notes = new ArrayList<>();
		notes.add(note);
		notes.add(note1);
	}

	public int getTempoBPM ()
	{
		return 60000000 / tempo;
	}

	private int generateCSV (File midiFile, File csvFile) throws IOException, InterruptedException
	{
		if (csvFile.exists())
		{
			csvFile.delete();
			System.out.println("Preexisting CSV file destroyed");
		}
		System.out.println("Midicsv.exe will now be run");
		Runtime runtime = Runtime.getRuntime();
		Process midicsvProcess = runtime.exec("Resources/midicsv/Midicsv.exe " + midiFile.getAbsolutePath() + " " + csvFile.getAbsolutePath());
		int processReturn = midicsvProcess.waitFor();
		midicsvProcess.destroy();
		System.out.println("Subprocess destroyed\nSubprocess returned a value of " + processReturn);
		if (processReturn == 0)
		{
			System.out.println(".csv file sucessfully generated");
		}
		else
		{
			System.out.println("This can't be good...\nMost likely, the MIDI file you provided is broken");
			return -1;
		}
		return 0;
	}

	public ArrayList<Note> getNotes ()
	{
		return notes;
	}

	public int getInstrument ()
	{
		return instrument;
	}

	public String getInstumentName()
	{
		HashMap<Integer, String> instrumentTable = new HashMap<>();
		instrumentTable.put(0, "Acoustic Grand Piano");
		instrumentTable.put(1, "Bright Acoustic Piano");
		instrumentTable.put(2, "Electric Grand Piano");
		instrumentTable.put(3, "Honky-tonk Piano");
		instrumentTable.put(4, "Electric Piano 1");
		instrumentTable.put(5, "Electric Piano 2");
		instrumentTable.put(6, "Harpsichord");
		instrumentTable.put(7, "Clavinet");
		instrumentTable.put(8, "Celesta");
		instrumentTable.put(9, "Glockenspiel");
		instrumentTable.put(10, "Music Box");
		instrumentTable.put(11, "Vibraphone");
		instrumentTable.put(12, "Marimba");
		instrumentTable.put(13, "Xylophone");
		instrumentTable.put(14, "Tubular Bells");
		instrumentTable.put(15, "Dulcimer");
		instrumentTable.put(16, "Drawbar Organ");
		instrumentTable.put(17, "Percussive Organ");
		instrumentTable.put(18, "Rock Organ");
		instrumentTable.put(19, "Church Organ");
		instrumentTable.put(20, "Reed Organ");
		instrumentTable.put(21, "Acordion");
		instrumentTable.put(22, "Harmonica");
		instrumentTable.put(23, "Tango Accordion");
		instrumentTable.put(24, "Acoustic Guitar (nylon)");
		instrumentTable.put(25, "Acoustic Guitar (steel)");
		instrumentTable.put(26, "Electric Guitar (jazz)");
		instrumentTable.put(27, "Electric Guitar (clean)");
		instrumentTable.put(28, "Electric Guitar (muted)");
		instrumentTable.put(29, "Overdriven Guitar");
		instrumentTable.put(30, "Distortion Guitar");
		instrumentTable.put(31, "Guitar Harmonics");
		instrumentTable.put(31, "Acoustic Bass");
		instrumentTable.put(33, "Electric Bass (finger)");
		instrumentTable.put(34, "Electric Bass (pick)");
		instrumentTable.put(35, "Fretless Bass");
		instrumentTable.put(36, "Slap Bass 1");
		instrumentTable.put(37, "Slap Bass 2");
		instrumentTable.put(38, "Synth Bass 1");
		instrumentTable.put(39, "Synth Bass 2");
		instrumentTable.put(40, "Violin");
		instrumentTable.put(41, "Viola");
		instrumentTable.put(42, "Cello");
		instrumentTable.put(43, "Contrabass");
		instrumentTable.put(44, "Tremolo Strings");
		instrumentTable.put(45, "Pizzicato Strings");
		instrumentTable.put(45, "Orchestral Harp");
		instrumentTable.put(47, "Timpani");
		instrumentTable.put(48, "String Ensemble 1");
		instrumentTable.put(49, "String Ensemble 2");
		instrumentTable.put(50, "SynthStrings 1");
		instrumentTable.put(51, "SynthStrings 2");
		instrumentTable.put(52, "Choir Aahs");
		instrumentTable.put(53, "Voice Oohs");
		instrumentTable.put(54, "Synth Voice");
		instrumentTable.put(55, "Orchestra Hit");
		instrumentTable.put(56, "Trumpet");
		instrumentTable.put(57, "Trombone");
		instrumentTable.put(58, "Tuba");
		instrumentTable.put(59, "Muted Trumpet");
		instrumentTable.put(60, "French Horn");
		instrumentTable.put(61, "Brass Section");
		instrumentTable.put(62, "Synth Brass 1");
		instrumentTable.put(63, "Synth Brass 2");
		instrumentTable.put(64, "Soprano Sax");
		instrumentTable.put(65, "Alto Sax");
		instrumentTable.put(66, "Tenor Sax");
		instrumentTable.put(67, "Baritone Sax");
		instrumentTable.put(67, "Oboe");
		instrumentTable.put(69, "English Horn");
		instrumentTable.put(70, "Bassoon");
		instrumentTable.put(71, "Clarinet");
		instrumentTable.put(72, "Piccolo");
		instrumentTable.put(73, "Flute");
		instrumentTable.put(74, "Recorder");
		instrumentTable.put(75, "Pan Flute");
		instrumentTable.put(76, "Blown Bottle");
		instrumentTable.put(77, "Shakuhachi");
		instrumentTable.put(78, "Whistle");
		instrumentTable.put(79, "Ocarina");
		instrumentTable.put(80, "Lead 1 (square)");
		instrumentTable.put(81, "Lead 2 (sawtooth)");
		instrumentTable.put(82, "Lead 3 (calliope)");
		instrumentTable.put(83, "Lead 4 (chiff)");
		instrumentTable.put(84, "Lead 5 (charang)");
		instrumentTable.put(85, "Lead 6 (voice)");
		instrumentTable.put(86, "Lead 7 (fifths)");
		instrumentTable.put(86, "Lead 8 (bass+lead");
		instrumentTable.put(88, "Pad 1 (new age)");
		instrumentTable.put(89, "Pad 2 (warm)");
		instrumentTable.put(90, "Pad 3 (polysynth)");
		instrumentTable.put(91, "Pad 4 (choir)");
		instrumentTable.put(92, "Pad 5 (bowed)");
		instrumentTable.put(93, "Pad 6 (metallic)");
		instrumentTable.put(94, "Pad 7 (halo)");
		instrumentTable.put(95, "Pad 8 (sweep)");
		instrumentTable.put(96, "FX 1 (train)");
		instrumentTable.put(97, "FX 2 (soundtrack)");
		instrumentTable.put(98, "FX 3 (crystal)");
		instrumentTable.put(99, "FX 4 (atmosphere)");
		instrumentTable.put(100, "FX 5 (brightness)");
		instrumentTable.put(101, "FX 6 (goblins)");
		instrumentTable.put(102, "FX 7 (echoes)");
		instrumentTable.put(103, "FX 8 (sci-fi)");
		instrumentTable.put(104, "Sitar");
		instrumentTable.put(105, "Banjo");
		instrumentTable.put(106, "Shamisen");
		instrumentTable.put(107, "Koto");
		instrumentTable.put(108, "Kalimba");
		instrumentTable.put(109, "Bagpipe");
		instrumentTable.put(110, "Fiddle");
		instrumentTable.put(111, "Shanai");
		instrumentTable.put(112, "Tinkle Bell");
		instrumentTable.put(113, "Agogo");
		instrumentTable.put(114, "Steel Drums");
		instrumentTable.put(115, "Woodblock");
		instrumentTable.put(116, "Tailo Drum");
		instrumentTable.put(117, "Melodic Drum");
		instrumentTable.put(118, "Synth Drum");
		instrumentTable.put(119, "Reverse Cymbal");
		instrumentTable.put(120, "Guitar Fret Noise");
		instrumentTable.put(121, "Breath Noise");
		instrumentTable.put(122, "Seashore");
		instrumentTable.put(123, "Bird Tweet");
		instrumentTable.put(124, "Telephone Ring");
		instrumentTable.put(125, "Helicopter");
		instrumentTable.put(126, "Applause");
		instrumentTable.put(127, "Gunshot");

		return instrumentTable.get(instrument);
	}
}
