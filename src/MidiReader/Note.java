package MidiReader;

public class Note implements Comparable
{
	private int pitch;
	private int startTime;
	private int endTime;
	
	public Note(int pitch, int startTime)
	{
		this.pitch = pitch;
		this.startTime = startTime;
	}

	public void setEndTime (int endTime)
	{
		this.endTime = endTime;
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
		// TODO
		return "A#4";
	}

	@Override
	public String toString ()
	{
		return "<Pitch: " + pitch + ", Start: " + startTime + ", End: " + endTime + ">";
	}

	@Override
	public int compareTo (Object o)
	{
		return startTime - ((Note) o).startTime;
	}
}
