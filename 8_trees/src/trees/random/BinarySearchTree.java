package trees.random;

public class BinarySearchTree<T extends Comparable<T>>
{
	protected Node root;
	protected int nodeCount = 0;

	public BinarySearchTree()
	{
		// do nothing
	}

	public boolean add(T element)
	{
		if (root == null)
		{
			root = new Node(element, null, null);
			nodeCount++;
			return true;
		}
		else
		{
			int savedNodeCount = nodeCount;
			// search for the spot, if it's not taken
			root = add(root, element);
			return savedNodeCount == nodeCount;
		}
	}

	private Node add(Node current, T element)
	{
		if (current == null)
		{
			nodeCount++;
			return new Node(element);
		}

		int compare = current.data.compareTo(element);
		if (current.data.equals(element))
		{
			return current; // already in the tree
		}
		else if (current.data.compareTo(element) < 0)
		{
			current.right = add(current.right, element);
			return current;
		}
		else
		{
			current.left = add(current.left, element);
			return current;
		}
	}

	public int treeHeight()
	{
		return calculateNodeHeight(root);
	}

    private int calculateNodeHeight(Node current)
    {
        if (current == null)
        {
            return -1;
        }
        else
        {
            int height = 1 + Math.max(calculateNodeHeight(current.left),
                                      calculateNodeHeight(current.right));
            current.height = height;
            return height;
        }
    }

	public int size()
	{
		return nodeCount;
	}

	public boolean contains(Object search)
	{
		return contains(root, (T) search);
	}

	private boolean contains(Node current, T element)
	{
		if (current == null)
		{
			return false;
		}
		else
		{
			int compare = current.data.compareTo(element);

			if (compare < 0) // new element is larger
			{
				return contains(current.right, element);
			}
			else if (compare > 0) // new element is smaller
			{
				return contains(current.left, element);
			}
			else // compare == 0
			{
				return true; // found it!
			}
		}
	}

	// nested classes
	public class Node
	{
		private T data;
		private Node left;
		private Node right;

		//scratch variables
		private int height;
		private int depth;

		public Node(T data)
		{
			this.data = data;
		}

		public Node(T data, Node left, Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString()
		{
			String leftString = (left == null) ? "null" : left.data.toString();
			String rightString = (right == null) ? "null" : right.data.toString();

			return leftString + " <-- " + data.toString() + " --> " + rightString;
		}
	}
}
