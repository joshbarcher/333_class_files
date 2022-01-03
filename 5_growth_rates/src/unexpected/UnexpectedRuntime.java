package unexpected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnexpectedRuntime
{
    public static void main(String[] args)
    {
        //add 10,000,000 elements and access them individually
        List<Integer> list = new LinkedList<>();

        System.out.println("Adding elements...");
        for (int i = 1; i <= 10000000; i++)
        {
            list.add(i);
        }

        System.out.println("Started accessing elements...");
        /*for (int i = 0; i < list.size(); i++)
        {
            //1 + 2 + 3 + 4 + ... + n = n * n = n^2 (n times)
            int element = list.get(i);

            //do something with it...
        }*/

        for (int element : list)
        {

        }
        System.out.println("Done accessing elements...");
    }
}
