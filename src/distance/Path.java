package distance;

import java.util.*;

public class Path {
	public List<Section> flightPath = new ArrayList<Section>();
	public Path() { }
	public Path(Path pat)
	{
		flightPath.addAll(pat.flightPath);
	}
	public void addSection(Section s) {
		if(flightPath.isEmpty()) {
			flightPath.add(new Section(s));
		} else {
			Point end = flightPath.get(flightPath.size()-1).getEndPoint();
			Point start = s.getStartPoint();
			
			if(end.equals(start)) {
				flightPath.add(new Section(s));
			} else {
				Section change = new Section(end, start);
				flightPath.add(change);
				flightPath.add(new Section(s));
			}
		}
	}
	public void removeSection(int x) {
		if (flightPath.size() > 0 && x <= flightPath.size()-1) {
			if (x == 0 || x == flightPath.size()-1) {
				flightPath.remove(x);
			} else {
				flightPath.get(x - 1).to = new Point(flightPath.get(x + 1).to);
				flightPath.remove(x);
				flightPath.remove(x);
			}
		}
	}
	public String addPoint(Point p) {
		if(flightPath.isEmpty()) {
			return "base flight path dont exist";
		} else {
			Point end = flightPath.get(flightPath.size()-1).getEndPoint();
			Section trip = new Section(end, p);
			flightPath.add(trip);
			return null;
		}
	}
	public String removePoint(Point p)
	{
		if (flightPath.size() > 1) {
			for (int i = 0; i < flightPath.size(); i++) {
				if (flightPath.get(i).from.equals(p)) {
					if (i == 0) {
						flightPath.remove(i);
					} else {
						flightPath.get(i - 1).to = new Point(flightPath.get(i).to);
						flightPath.remove(i);
					}
					return "removed";
				}
				if (flightPath.get(i).to.equals(p)) {
					if (i == flightPath.size()-1) {
						flightPath.remove(i);
					} else {
						flightPath.get(i + 1).from = new Point(flightPath.get(i).from);
						flightPath.remove(i);
					}
					return "removed";
				}
			}
			return "there is no such point";
		}
		return "not enough points to create path";
	}
	public String toString() {
		String msg = "flight path:\n";
		for(int i = 0; i < flightPath.size(); i++) {
			msg += flightPath.get(i).toString();
		}
		msg += "\n";
		return msg;
	}
}
