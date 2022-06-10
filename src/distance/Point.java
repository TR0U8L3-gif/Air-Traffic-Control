package distance;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public void move(double x, double y) {
		this.x+=x;
		this.y+=y;
	}
//	the function checks if the points have the same x and y values
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
 
        if (!(o instanceof Point)) {
            return false;
        }
         
        Point p = (Point) o;
         
        return Double.compare(this.x, p.x) == 0
                && Double.compare(this.y, p.y) == 0;
    }
	public String toString()
	{
		return "x: " + this.x + " y: " + this.y;
	}
}
