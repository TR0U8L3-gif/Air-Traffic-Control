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
	public String addPoint(Point p, double height, double speed) {
		if(flightPath.isEmpty()) {
			return "base flight path dont exist";
		} else {
			Point end = flightPath.get(flightPath.size()-1).getEndPoint();
			Section trip = new Section(end, p);
			trip.setHeight(height);
			trip.setSpeed(speed);
			flightPath.add(trip);
			return null;
		}
	}
	public String removePoint(int index) {
		index -= 1;
		if (index == 0) {
			removeSection(0);
		} else if (index == flightPath.size()) {
			removeSection(flightPath.size()-1);
		}
		else if(index>flightPath.size()){
			return "unable to remove B)";
		}
		else {
			flightPath.get(index - 1).to = new Point(flightPath.get(index).to);
			flightPath.remove(index);
		}
		return "removed";
	}
	public String toString() {
		String msg = "flight path:\n";
		for(int i = 0; i < flightPath.size(); i++) {
			msg += flightPath.get(i).toString();
		}
		msg += "\n";
		return msg;
	}
	public String showPath() {
		String msg = "flight path:\n";
		for(int i = 0; i < flightPath.size(); i++) {
			msg += (i+1) + ") " + flightPath.get(i).getStartPoint().toString() + "\n";
			if(i == flightPath.size()-1)
			{
				msg += (i+2) + ") " + flightPath.get(i).getEndPoint().toString();
			}
		}
		msg += "\n";
		return msg;
	}
}
