package examples;

public class Logarithmic
{
    public static void main(String[] args)
    {
        int[] sorted = {-5, -3, -2, -1, 0, 4, 7, 9, 11, 15, 17, 21, 22};

        int firstPos = binarySearch(sorted, 11);
        int secondPos = binarySearch(sorted, -5);
        int thirdPos = binarySearch(sorted, 3);

        System.out.println("11 at index " + firstPos);
        System.out.println("-5 at index " + secondPos);
        System.out.println("3 at index " + thirdPos);
    }

    public static int binarySearch(int[] elements, int search)
    {
        int low = 0;
        int high = elements.length;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (elements[mid] == search)
            {
                return mid;
            }
            else if (elements[mid] > search)
            {
                //search to the left
                high = mid - 1;
            }
            else
            {
                //search to the right
                low = mid + 1;
            }
        }
        return -1; //not found!
    }
}
