package structures;

public class OrderedList
{

    private class Node
    {
        //the Object type should be changed to your
        //generic type
        private Object data;
        private Node prev;
        private Node next;

        public Node(Object data)
        {
            this.data = data;
        }

        public Node(Object data, Node prev, Node next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString()
        {
            String prev = this.prev != null ? this.prev.data.toString() : "null";
            String next = this.prev != null ? this.prev.data.toString() : "null";
            return prev + " <-- " + data.toString() + " --> " + next;
        }
    }
}
