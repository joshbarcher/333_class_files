package examples;

public class Linear
{
    public static void main(String[] args)
    {
        int[] sorted = {17, -3, 11, -1, 9, 0, 4, 7, -2, 15, -5, 21, 22};

        int firstPos = linearSearch(sorted, 11);
        int secondPos = linearSearch(sorted, -5);
        int thirdPos = linearSearch(sorted, 3);

        System.out.println("11 at index " + firstPos);
        System.out.println("-5 at index " + secondPos);
        System.out.println("3 at index " + thirdPos);
    }

    public static int linearSearch(int[] elements, int search)
    {
        for (int i = 0; i < elements.length; i++)
        {
            if (elements[i] == search)
            {
                return i;
            }
        }
        return -1; //not found!
    }
}
