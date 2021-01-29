package examples;

public class Constant
{
    public static void main(String[] args)
    {
        Character[] letters = {'a', 'b', 'c', 'd'};

        swap(letters, 0, 2);

        for (int i = 0; i < letters.length; i++)
        {
            System.out.println(letters[i]);
        }
    }

    public static void swap(Object[] array, int first, int second)
    {
        Object temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
