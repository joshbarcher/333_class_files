package trees.balanced;

public class TestBalancedTree
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> balancedTree = new BinarySearchTree<>();

        for (int i = 0; i < 10000000; i++)
        {
            balancedTree.add(i);
        }
        System.out.println("Tree height: " + balancedTree.treeHeight());
    }
}
