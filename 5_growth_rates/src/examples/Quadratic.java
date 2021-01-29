package examples;

public class Quadratic
{
    public static void main(String[] args)
    {
        String[] words = {"and", "or", "if", "be", "or", "or", "to",
                          "and", "so", "to"};

        int dups = countDuplicates(words);
        System.out.println("Duplicates: " + dups);
    }

    public static int countDuplicates(String[] elements)
    {
        int count = 0;
        for (int i = 0; i < elements.length; i++)
        {
            for (int j = i + 1; j < elements.length; j++)
            {
                if (elements[i].equals(elements[j]))
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
