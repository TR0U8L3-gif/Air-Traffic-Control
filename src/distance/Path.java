package distance;

import java.util.*;

public class Path {
	
	private List<Section> flightPath = new ArrayList<Section>();
	
	public Path()
	{
		flightPath.clear();
	}
	public Path(Path pat)
	{
		flightPath.addAll(pat.flightPath);
	}
	public void addSection(Section s)
	{
		if(flightPath.isEmpty())
		{
			flightPath.add(new Section(s));
		}
		else
		{
			Point end = flightPath.get(flightPath.size()-1).getEndPoint();
			Point start = s.getStartPoint();
			
			if(end.equals(start))
			{
				flightPath.add(new Section(s));
			}
			else
			{
				Section change = new Section(end, start);
				flightPath.add(change);
				flightPath.add(new Section(s));
			}
		}
	}
	public void removeSection(int x)
	{
		//to do
	}
	public String addPoint(Point p)
	{
		if(flightPath.isEmpty())
		{
			return "base flight path dont exist";
		}
		else
		{
			Point end = flightPath.get(flightPath.size()-1).getEndPoint();
			Section trip = new Section(end, p);
			flightPath.add(trip);
			return null;
		}
	}
	public String removePoint(Point p)
	{
		//to do
		return null;
	}
	public String toString()
	{
		String msg = "flight path:\n";
		for(int i = 0; i < flightPath.size(); i++)
		{
			msg += flightPath.get(i).toString();
		}
		msg += "\n";
		return msg;
	}
}
