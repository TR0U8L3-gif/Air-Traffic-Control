package distance;

public class Section {
	
	private double height = 0;
	private double speed = 0;
	private boolean direction = true; 
	// direction: true->up,  false->down
	protected Point from;
	protected Point to;
	
	public Section(Point p1, Point p2){
		this.from = new Point(p1);
		this.to = new Point(p2);
		this.setDirection();
	}
	
	public Section(Section s){
		this.from = new Point(s.from);
		this.to = new Point(s.to);
		this.setDirection();
	}
	
	public void setHeight(double h)
	{
		this.height = h;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public void setSpeed(double s)
	{
		this.speed = s;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	protected void setDirection() {
		if(this.from.getX() == this.to.getX()) {
			if(this.from.getY() < this.to.getY()) {
				this.direction = true;
			}
			else {
				this.direction = false;
			}
		}
		else if(this.from.getX() < this.to.getX()) {
			this.direction = true;
		}
		else {
			this.direction = false;
		}
	}
	
	public boolean getDirection()
	{
		return this.direction;
	}
	
	public Point getStartPoint()
	{
		return this.from;
	}
	
	public Point getEndPoint()
	{
		return this.to;
	}
	
	public String toString() {
		return " Section:\n " + this.from.toString() +  "\t" + this.to.toString() +
				"\t height: " + this.height + " speed: " + this.speed + " direction: " + this.direction + "\n";
	}
}
