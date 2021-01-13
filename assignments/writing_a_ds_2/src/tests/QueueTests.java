package tests;

import adts.IBoundedQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueTests
{
    private IBoundedQueue<Integer> queue;

    private IBoundedQueue<Integer> createQueue(int capacity)
    {
        //instantiate your class here! You should pass in the
        //input parameter capacity to your constructor.
        return null;
    }

    @Before
    public void setup()
    {
        queue = createQueue(5);
    }

    @Test(expected = IllegalStateException.class)
    public void zeroCapacityTest()
    {
        queue = createQueue(0);
    }

    @Test(expected = IllegalStateException.class)
    public void negativeCapacityTest()
    {
        queue = createQueue(-4);
    }

    @Test
    public void capacityAccurateTest()
    {
        queue = createQueue(3);
        Assert.assertEquals("Capacity inaccurate when creating a queue with capacity 3",
                            3, queue.getCapacity());

        queue = createQueue(5);
        Assert.assertEquals("Capacity inaccurate when creating a queue with capacity 5",
                            5, queue.getCapacity());
    }

    @Test(expected = IllegalStateException.class)
    public void fullQueueTest()
    {
        //fill the queue
        queue.add(2);
        queue.add(4);
        queue.add(6);
        queue.add(8);
        queue.add(10);

        //one too many for a queue of size 5
        queue.add(12);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyQueueTest()
    {
        //remove a missing element
        queue.remove();
    }

    @Test
    public void removeTest()
    {
        //add an element
        queue.add(22);

        //remove the element
        int removed = queue.remove().intValue();
        Assert.assertEquals("Added a single element, but didn't receive the " +
                            "element with remove()", 22, removed);
    }

    @Test
    public void fifoTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }

        //make sure elements removed are in FIFO order
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Removed element does not match FIFO order",
                                elemsToAdd[i], queue.remove().intValue());
        }
    }

    @Test
    public void containsExistsTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                            3, queue.size());

        //make sure elements are discoverable
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Added element not discoverable by contains()",
                                true, queue.contains(elemsToAdd[i]));
        }
    }

    @Test
    public void containsMissingTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                            3, queue.size());

        //make sure elements are discoverable
        int[] notAdded = {1, 3, 5};
        for (int i = 0; i < notAdded.length; i++)
        {
            Assert.assertEquals("Missing element is discoverable by contains()",
                                false, queue.contains(notAdded[i]));
        }
    }

    @Test
    public void containsOnEmptyQueueTest()
    {
        //contains should always return false on empty queue
        Assert.assertEquals("Missing element is discoverable by contains()",
                            false, queue.contains(2));

        //add an element and confirm contains() can discover it
        queue.add(2);
        Assert.assertEquals("Element added to queue is not discoverable by contains()",
                            true, queue.contains(2));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeElementTest()
    {
        //this should always result in an exception
        queue.remove(2);
    }

    @Test
    public void initialStateTest()
    {
        //queue should be empty to start with
        Assert.assertEquals("Queue should have size 0 when created", 0, queue.size());
        Assert.assertEquals("Queue should be empty when created", true, queue.isEmpty());
    }

    @Test
    public void sizeTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }

        //queue should be empty to start with
        Assert.assertEquals("Queue should have size 3 after three calls to add()", 3, queue.size());
        Assert.assertEquals("Queue should not be empty after calling add()", false, queue.isEmpty());
    }

    @Test
    public void sizeShouldNotExceedCapacityTest()
    {
        //add a few elements
        try
        {
            int[] elemsToAdd = {2, 4, 6, 8, 10, 12};
            for (int i = 0; i < elemsToAdd.length; i++)
            {
                queue.add(elemsToAdd[i]);
            }
        }
        catch (IllegalStateException ex)
        {
            //swallow the exception (if it occurs) and check the results
        }

        //queue should be empty to start with
        Assert.assertEquals("The size of your queue is exceeding the capacity", 5, queue.size());
        Assert.assertEquals("Queue should not be empty after calling add()", false, queue.isEmpty());
    }

    @Test
    public void notFullTest()
    {
        Assert.assertEquals("Empty queue should be empty", true, queue.isEmpty());
        Assert.assertEquals("An empty queue should not be full", false, queue.isFull());
    }

    @Test
    public void semiFullTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }

        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times", 3, queue.size());
        Assert.assertEquals("A partially filled queue should not be full", false, queue.isFull());
    }

    @Test
    public void fullTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6, 8, 10};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }

        Assert.assertEquals("Queue should be full once size is the same as capacity", true, queue.isFull());
    }

    @Test
    public void clearEmptyTest()
    {
        //make sure no errors are encountered
        queue.clear();

        Assert.assertEquals("Queue size should be 0 after calling clear()", 0, queue.size());
        Assert.assertEquals("Queue should be empty after calling clear", true, queue.isEmpty());
    }

    @Test
    public void clearNotEmptyTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                            3, queue.size());

        //make sure no errors are encountered
        queue.clear();

        Assert.assertEquals("Queue size should be 0 after calling clear()", 0, queue.size());
        Assert.assertEquals("Queue should be empty after calling clear", true, queue.isEmpty());
    }

    @Test
    public void largeQueueTest()
    {
        //create a large queue
        queue = createQueue(1000);

        //add a few elements
        for (int i = 1; i <= 1000; i++)
        {
            queue.add(i);
        }

        Assert.assertEquals("Queue should have a size of 1000 after 1000 additions", 1000, queue.size());
        Assert.assertEquals("Queue should not be empty after 1000 additions", false, queue.isEmpty());
        Assert.assertEquals("Queue should be full once size is the same as capacity", true, queue.isFull());
    }

    @Test
    public void regularModificationsTest()
    {
        //repeatedly add/remove elements
        for (int i = 1; i <= 4; i++)
        {
            //add 2
            int[] elemsToAdd = {2, 4};
            for (int j = 0; j < elemsToAdd.length; j++)
            {
                queue.add(elemsToAdd[j]);
            }

            //remove 1
            for (int j = 0; j < elemsToAdd.length - 1; j++)
            {
                queue.remove();
            }
        }

        //There should be four net elements in the end
        Assert.assertEquals("The number of elements left in the queue after repeatedly " +
                            "calling add() and remove() is incorrect", 4, queue.size());
        Assert.assertEquals("The queue should not be empty after repeatedly calling add() and remove()",
                            false, queue.isEmpty());
    }

    @Test
    public void addAfterEmptyingQueueTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }

        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.remove();
        }

        //add a single element after emptying the queue
        queue.add(8);
        Assert.assertEquals("Queue should have a size of 1 after adding a single " +
                            "element to a 'recently' emptied queue", 1, queue.size());
        Assert.assertEquals("Queue should detect a single element after emptying the queue",
                            true, queue.contains(8));
    }

    @Test
    public void iteratorWithEmptyStackTest()
    {
        Iterator<Integer> iter = queue.iterator();
        Assert.assertEquals("Iterator should not report elements for an empty queue",
                false, iter.hasNext());
    }

    @Test
    public void iteratorTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                3, queue.size());

        //verify elements returned in FILO order
        Iterator<Integer> iter = queue.iterator();
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("hasNext() should return true for existing elements in the queue",
                    true, iter.hasNext());
            Assert.assertEquals("next() should return elements in FIFO order",
                    elemsToAdd[i], iter.next().intValue());
        }

        Assert.assertEquals("Iterator should not report elements for an empty queue",
                false, iter.hasNext());
    }

    @Test
    public void forEachTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                3, queue.size());

        //a for-each loop should run without error
        int count = 0;
        for (int element : queue)
        {
            Assert.assertEquals("next() should return elements in FIFO order",
                    elemsToAdd[count], element);
            count++;
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void concurrentModificationTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            queue.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                3, queue.size());

        for (int element : queue)
        {
            queue.remove(); //alter elements while iterating
        }
    }
}










