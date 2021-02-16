package trees.balanced;

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
		}
		else
		{
			current.left = add(current.left, element);
		}

		//rebalance...

		//CASE #1 - right red link
		if (isRed(current.right) && !isRed(current.left))
		{
			current = rotateLeft(current);
			current.left.color = true; //red
			current.color = false; //black
		}
		//CASE #2 - consecutive left leaning links
		else if (isRed(current.left) && isRed(current.left.left))
		{
			current = rotateRight(current);
			current.left.color = false; //black
			current.color = true; //red
		}
		//CASE #3 - two red child nodes
		else if (isRed(current.left) && isRed(current.right))
		{
			current.color = true; //red

			current.left.color = false; //black
			current.right.color = false; //black
		}

		return current;
	}

	private Node rotateLeft(Node current)
	{
		Node child = current.right;
		Node childLeft = child.left;

		child.left = current;
		current.right = childLeft;

		return child;
	}

	private Node rotateRight(Node current)
	{
		Node child = current.left;
		Node childRight = child.right;

		child.right = current;
		current.left = childRight;

		return child;
	}

	private boolean isRed(Node current)
	{
		if (current == null)
		{
			return false;
		}
		return current.color;
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

		//red = true, black = false
		private boolean color;

		public Node(T data)
		{
			this.data = data;
			color = true; //reference to node is red initially
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
