package trees.random;

import java.util.Random;

public class HeightExperiment
{
    public static void main(String[] args)
    {
        multipleTrials();
    }

    private static void trial(int size)
    {
        //create a tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //add random elements
        Random random = new Random();
        for (int i = 1; i <= size; i++)
        {
            tree.add(random.nextInt(size));
        }

        int height = tree.treeHeight();
        System.out.println("Height (" + size + "): " + height);
    }

    private static void multipleTrials()
    {
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000};

        for (int size : sizes)
        {
            trial(size);
        }
    }
}
