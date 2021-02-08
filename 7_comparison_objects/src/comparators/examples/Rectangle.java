package comparators.examples;

public class Rectangle
{
	private double width;
	private double height;

	public Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	public double getWidth()
	{
		return width;
	}
	public double getHeight()
	{
		return height;
	}
	public String toString()
	{
		return "w: " + width + ", h: " + height + ", area: " +
				(width * height);
	}
}

