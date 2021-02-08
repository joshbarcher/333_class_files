package comparables.people;

public class Person
{
	private String name;
	private String hair;
	private int height;

	public Person(String fullName, String hair,
				  int height)
	{
		this.name = fullName;
		this.hair = hair;
		this.height = height;
	}

	public String getName()
	{
		return name;
	}

	public String getHair()
	{
		return hair;
	}

	public int getHeight()
	{
		return height;
	}

	public String toString()
	{
		return "(" + name + ", " + hair + ", " + height + ")";
	}
}



