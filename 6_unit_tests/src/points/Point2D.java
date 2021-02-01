package points;

public class Point2D
{
    private double x, y;

    public Point2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Point2D()
    {
        //set point at origin...
    }

    public boolean isAtOrigin()
    {
        return x == 0 && y == 0;
    }

    public double distance(Point2D other)
    {
        return Math.sqrt(Math.pow(x - other.x, 2) +
                         Math.pow(y - other.y, 2));
    }

    public boolean inQuadrant(int quadrant)
    {
        switch (quadrant)
        {
            case 1: return x > 0 && y > 0;
            case 2: return x < 0 && y > 0;
            case 3: return x < 0 && y < 0;
            case 4: return x > 0 && y < 0;
            default: throw new IllegalArgumentException(
                        "Invalid quadrant");
        }
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
