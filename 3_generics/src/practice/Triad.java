package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//elements of type T can be compared with
//other T elements
public class Triad<T extends Comparable<T>>
{
    private T first;
    private T second;
    private T third;

    public Triad(T first, T second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public List<T> sort()
    {
        //List.of() returns an unmodifiable List, make sure
        //to add all elements to a new ArrayList instead
        List<T> sorted = new ArrayList<>(
                List.of(first, second, third));
        Collections.sort(sorted);
        return sorted;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    public T getThird()
    {
        return third;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
