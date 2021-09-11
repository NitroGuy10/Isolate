package MidiReader;

public class Note
{
	private int pitch;
	private int startTime;
	private int endTime;
	
	public Note()
	{
		// TODO TEMPORARY
		pitch = 100;
		startTime = 5;
		endTime = 15;
	}
	
	public int getStartTime ()
	{
		return startTime;
	}
	
	public int getEndTime ()
	{
		return endTime;
	}

	public int getLength ()
	{
		return endTime - startTime;
	}
	
	public int getPitch ()
	{
		return pitch;
	}
	
	public String getPitchName ()
	{
		return "A#4";
	}
}
