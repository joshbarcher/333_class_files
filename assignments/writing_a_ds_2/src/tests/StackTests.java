package tests;

import adts.IReversibleStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackTests
{
    private IReversableStack<Integer> stack;

    private IReversableStack<Integer> createStack()
    {
        //instantiate your class here!
        return null;
    }

    @Before
    public void setup()
    {
        stack = createStack();
    }

    @Test
    public void addingElementsTest()
    {
        int[] elemsToAdd = {1, 2, 3};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }

        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Elements added to stack not discoverable with contains()",
                    true, stack.contains(elemsToAdd[i]));
        }
    }

    @Test
    public void sizeTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }

        //stack should be empty to start with
        Assert.assertEquals("Stack should have size 3 after three calls to add()", 3, stack.size());
        Assert.assertEquals("Stack should not be empty after calling add()", false, stack.isEmpty());
    }

    @Test
    public void containsExistsTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //make sure elements are discoverable
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Added element not discoverable by contains()",
                    true, stack.contains(elemsToAdd[i]));
        }
    }

    @Test
    public void containsMissingTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //make sure elements are discoverable
        int[] notAdded = {1, 3, 5};
        for (int i = 0; i < notAdded.length; i++)
        {
            Assert.assertEquals("Missing element is discoverable by contains()",
                    false, stack.contains(notAdded[i]));
        }
    }

    @Test
    public void containsOnEmptyStackTest()
    {
        //contains should always return false on empty stack
        Assert.assertEquals("Missing element is discoverable by contains()",
                false, stack.contains(2));

        //add an element and confirm contains() can discover it
        stack.add(2);
        Assert.assertEquals("Element added to stack is not discoverable by contains()",
                true, stack.contains(2));
    }

    @Test
    public void removeTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }

        for (int i = 1; i <= 3; i++)
        {
            stack.remove();
        }

        Assert.assertEquals("Stack size should be 0 after removing all elements", 0, stack.size());
        Assert.assertEquals("Stack should be empty after removing all elements", true, stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeOnEmptyStackTest()
    {
        //no elements are present, this should give an exception
        stack.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeNotImplementedTest()
    {
        //this method should not be implemented
        stack.remove(2);
    }

    @Test
    public void filoTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }

        //remove them in order
        for (int i = 1; i <= 3; i++)
        {
            int removed = stack.remove();
            Assert.assertEquals("Elements removed are not in FILO order",
                    elemsToAdd[elemsToAdd.length - i], removed);
        }
    }

    @Test
    public void stackFluctuationsTest()
    {
        //add a few
        stack.add(1);
        stack.add(2);
        stack.add(3);

        //remove some, not all
        Assert.assertEquals("Elements removed are not in FILO order",
                3, stack.remove().intValue());
        Assert.assertEquals("Elements removed are not in FILO order",
                2, stack.remove().intValue());

        //add a few more
        stack.add(4);
        stack.add(5);

        //remove the remaining and verify
        Assert.assertEquals("Elements removed are not in FILO order",
                5, stack.remove().intValue());
        Assert.assertEquals("Elements removed are not in FILO order",
                4, stack.remove().intValue());
        Assert.assertEquals("Elements removed are not in FILO order",
                1, stack.remove().intValue());

        Assert.assertEquals("Stack size should be 0 after removing all elements", 0, stack.size());
        Assert.assertEquals("Stack should be empty after removing all elements", true, stack.isEmpty());
    }

    @Test
    public void clearEmptyTest()
    {
        //make sure no errors are encountered
        stack.clear();

        Assert.assertEquals("Stack size should be 0 after calling clear()", 0, stack.size());
        Assert.assertEquals("Stack should be empty after calling clear", true, stack.isEmpty());
    }

    @Test
    public void clearNotEmptyTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //make sure no errors are encountered
        stack.clear();

        Assert.assertEquals("Stack size should be 0 after calling clear()", 0, stack.size());
        Assert.assertEquals("Stack should be empty after calling clear", true, stack.isEmpty());
    }

    @Test
    public void largeStackTest()
    {
        //add enough elements for force a resize
        for (int i = 1; i <= 1000; i++)
        {
            stack.add(i);
        }

        //verify elements are in order
        for (int i = 0; i < 1000; i++)
        {
            int removed = stack.remove();
            Assert.assertEquals("Elements are not returned in FILO order",
                    1000 - i, removed);
        }
    }

    @Test
    public void addAfterEmptyingStackTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //remove all elements
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.remove();
        }

        //adding should still be successful
        stack.add(2);
        Assert.assertEquals("The size of your stack should be 1 after calling add() on an empty stack",
                1, stack.size());
    }

    @Test
    public void reverseEmptyStackTest()
    {
        //reversing an empty stack should still be empty
        stack.reverse();

        Assert.assertEquals("Stack size should be 0 after calling clear()", 0, stack.size());
        Assert.assertEquals("Stack should be empty after calling clear", true, stack.isEmpty());
    }

    @Test
    public void reverseOddLengthTest()
    {
        testLengths(new int[] {2, 4, 6, 8, 10, 12, 14});
    }

    @Test
    public void reverseEvenLengthTest()
    {
        testLengths(new int[] {2, 4, 6, 8, 10, 12, 14, 16});
    }

    private void testLengths(int[] elemsToAdd)
    {
        //add a few elements
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be " + elemsToAdd.length +
                            " after calling add() " + elemsToAdd.length + " times",
                            elemsToAdd.length, stack.size());

        stack.reverse();

        //make sure elements are returned in reverse order
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            int removed = stack.remove().intValue();
            Assert.assertEquals("Elements in stack are not returned in reverse order",
                    elemsToAdd[i], removed);
        }

        Assert.assertEquals("Stack size should be 0 after removing all elements", 0, stack.size());
        Assert.assertEquals("Stack should be empty after removing all elements", true, stack.isEmpty());
    }

    @Test
    public void reverseLargeStackTest()
    {
        //add a few elements
        for (int i = 1; i <= 1000; i++)
        {
            stack.add(i);
        }
        Assert.assertEquals("The size of your stack should be 1000 after calling add() 1000 times",
                1000, stack.size());

        stack.reverse();

        //make sure elements are returned in reverse order
        for (int i = 1; i <= 1000; i++)
        {
            Assert.assertEquals("Elements in stack are not returned in reverse order",
                    i, stack.remove().intValue());
        }
    }

    @Test
    public void doubleReverseTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6, 8, 10, 12};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 6 after calling add() 6 times",
                6, stack.size());

        stack.reverse(); //reverse order
        stack.reverse(); //original order

        //make sure elements are returned in reverse order
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Elements in stack are not returned in reverse order",
                    elemsToAdd[elemsToAdd.length - i - 1], stack.remove().intValue());
        }
    }

    @Test
    public void iteratorWithEmptyStackTest()
    {
        Iterator<Integer> iter = stack.iterator();
        Assert.assertEquals("Iterator should not report elements for an empty stack",
                            false, iter.hasNext());
    }

    @Test
    public void iteratorTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //verify elements returned in FILO order
        Iterator<Integer> iter = stack.iterator();
        for (int i = elemsToAdd.length - 1; i >= 0; i--)
        {
            Assert.assertEquals("hasNext() should return true for existing elements in the stack",
                    true, iter.hasNext());
            Assert.assertEquals("next() should return elements in FILO order",
                    elemsToAdd[i], iter.next().intValue());
        }

        Assert.assertEquals("Iterator should not report elements for an empty stack",
                false, iter.hasNext());
    }

    @Test
    public void forEachTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        //a for-each loop should run without error
        int count = 0;
        for (int element : stack)
        {
            Assert.assertEquals("next() should return elements in FILO order",
                    elemsToAdd[elemsToAdd.length - 1 - count], element);
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
            stack.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your stack should be 3 after calling add() 3 times",
                3, stack.size());

        for (int element : stack)
        {
            stack.remove(); //alter elements while iterating
        }
    }
}
