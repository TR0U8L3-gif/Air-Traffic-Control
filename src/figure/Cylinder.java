package figure;

public class Cylinder {
	private double r;
	private double h;
	
	public Cylinder()
	{
		this.r = 0;
		this.h = 0;
	}
	public Cylinder(double r, double h)
	{
		if(r < 0)
		{
			r*=-1;
		}
		if(h < 0)
		{
			h*=-1;
		}
		this.r = r;
		this.h = h;
	}
	public double getR()
	{
		return this.r;
	}
	public double getH()
	{
		return this.h;
	}
	public void setR(double r)
	{
		if(r < 0)
		{
			r*=-1;
		}
		this.r = r;
	}
	public void setH(double h)
	{
		if(h < 0)
		{
			h*=-1;
		}
		this.h = h;
	}
	public String toString()
	{
		return "r: " + this.r + " h: " + this.h;
	}
}
