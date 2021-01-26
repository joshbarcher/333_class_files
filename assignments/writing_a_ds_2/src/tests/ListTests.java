package tests;

import adts.IOrderedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structures.OrderedListAL;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ListTests
{
    private IOrderedList<Integer> list;

    private IOrderedList<Integer> createList()
    {
        //instantiate your class here!
        return null;
    }

    @Before
    public void setup()
    {
        list = createList();
    }

    @Test
    public void addingElementsTest()
    {
        int[] elemsToAdd = {1, 2, 3};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Elements added to list not discoverable with contains()",
                                true, list.contains(elemsToAdd[i]));
        }
    }

    @Test
    public void orderedElementsTest()
    {
        int[] elemsToAdd = {7, 3, 14, 0};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        int[] ordered = {0, 3, 7, 14};
        for (int i = 0; i < ordered.length; i++)
        {
            Assert.assertEquals("Elements added to list are not in ascending order",
                                ordered[i], list.get(i).intValue());
        }
    }

    @Test
    public void smallestElementTest()
    {
        //add a new element to the lowest index before an existing element
        list.add(11);
        list.add(4);

        Assert.assertEquals("A smaller element is not placed before a larger element in the list",
                            4, list.get(0).intValue());
        Assert.assertEquals("Larger elements are lost after being placed after a smaller element",
                            11, list.get(1).intValue());
    }

    @Test
    public void largestElementTest()
    {
        //add a new element to the lowest index before an existing element
        list.add(9);
        list.add(3);
        list.add(18);

        Assert.assertEquals("A larger element is not placed before a smaller element in the list",
                            18, list.get(2).intValue());
        Assert.assertEquals("Smaller elements are out of order after being placed before a smaller element",
                            9, list.get(1).intValue());
        Assert.assertEquals("Smaller elements are out of order after being placed before a smaller element",
                            3, list.get(0).intValue());
    }

    @Test
    public void sizeTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        //list should be empty to start with
        Assert.assertEquals("List should have size 3 after three calls to add()", 3, list.size());
        Assert.assertEquals("List should not be empty after calling add()", false, list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndexTest()
    {
        //should throw an exception
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getBadIndexTest()
    {
        //should throw an exception
        list.get(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexTooLargeTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        //should throw an exception
        list.get(3);
    }

    @Test
    public void containsExistsTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your list should be 3 after calling add() 3 times",
                            3, list.size());

        //make sure elements are discoverable
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("Added element not discoverable by contains()",
                                true, list.contains(elemsToAdd[i]));
        }
    }

    @Test
    public void containsMissingTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your list should be 3 after calling add() 3 times",
                            3, list.size());

        //make sure elements are discoverable
        int[] notAdded = {1, 3, 5};
        for (int i = 0; i < notAdded.length; i++)
        {
            Assert.assertEquals("Missing element is discoverable by contains()",
                                false, list.contains(notAdded[i]));
        }
    }

    @Test
    public void containsOnEmptyListTest()
    {
        //contains should always return false on empty list
        Assert.assertEquals("Missing element is discoverable by contains()",
                            false, list.contains(2));

        //add an element and confirm contains() can discover it
        list.add(2);
        Assert.assertEquals("Element added to list is not discoverable by contains()",
                            true, list.contains(2));
    }

    @Test
    public void removeExistsTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.remove(elemsToAdd[i]);
        }

        Assert.assertEquals("List size should be 0 after removing all elements", 0, list.size());
        Assert.assertEquals("List should be empty after removing all elements", true, list.isEmpty());
    }

    @Test
    public void removeMissingTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        //each of these removals should throw an exception
        int[] elemsToRemove = {1, 3, 5};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            try
            {
                list.remove(elemsToRemove[i]);

                //fail, an exception should have occurred...
                Assert.fail("No exception is thrown when removing a missing element");
            }
            catch (NoSuchElementException ex)
            {
                //do nothing, this is correct...
            }
        }
    }

    @Test
    public void removeFirstTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6, 4, 5, 4};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }

        Assert.assertEquals("The size of your list should be 6 after " +
                            "calling add() 6 times",
                6, list.size());

        //remove first duplicate
        list.remove(4);
        Assert.assertEquals("The size of your list should be one smaller after " +
                        "removing a duplicate element",
                5, list.size());
        Assert.assertTrue("remove() is removing all elements rather than " +
                "the first occurrence of an element", list.contains(4));

        //remove second duplicate
        list.remove(4);
        Assert.assertEquals("The size of your list should be one smaller after " +
                        "removing a duplicate element",
                4, list.size());
        Assert.assertTrue("remove() is removing all elements rather than " +
                "the first occurrence of an element", list.contains(4));

        //remove remaining element
        list.remove(4);
        Assert.assertFalse("List should not contain an element after all " +
                          "instances of the duplicated element are removed",
                          list.contains(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeOnEmptyListTest()
    {
        //no elements are present, this should give an exception
        list.remove(2);
    }

    @Test
    public void clearEmptyTest()
    {
        //make sure no errors are encountered
        list.clear();

        Assert.assertEquals("List size should be 0 after calling clear()", 0, list.size());
        Assert.assertEquals("List should be empty after calling clear", true, list.isEmpty());
    }

    @Test
    public void clearNotEmptyTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your list should be 3 after calling add() 3 times",
                            3, list.size());

        //make sure no errors are encountered
        list.clear();

        Assert.assertEquals("List size should be 0 after calling clear()", 0, list.size());
        Assert.assertEquals("List should be empty after calling clear", true, list.isEmpty());
    }

    @Test
    public void largeListTest()
    {
        //add enough elements for force a resize
        Random random = new Random();
        for (int i = 1; i <= 1000; i++)
        {
            list.add(random.nextInt(1000));
        }

        //verify elements are in order
        int current = list.get(0);
        int next = list.get(1);

        for (int i = 2; i < 1000; i++)
        {
            Assert.assertEquals("Elements are unordered for a large list",
                            true, current <= next);
            current = next;
            next = list.get(i);
        }
    }

    @Test
    public void addAfterEmptyingListTest()
    {
        //add a few elements
        int[] elemsToAdd = {2, 4, 6};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your list should be 3 after calling add() 3 times",
                            3, list.size());

        //remove all elements
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.remove(elemsToAdd[i]);
        }

        //adding should still be successful
        list.add(2);
        Assert.assertEquals("The size of your list should be 1 after calling add() on an empty list",
                            1, list.size());
    }

    @Test
    public void iteratorWithEmptyStackTest()
    {
        Iterator<Integer> iter = list.iterator();
        Assert.assertEquals("Iterator should not report elements for an empty list",
                false, iter.hasNext());
    }

    @Test
    public void iteratorTest()
    {
        //add a few elements
        int[] elemsToAdd = {6, 4, 2};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your list should be 3 after calling add() 3 times",
                3, list.size());

        //verify elements returned in FILO order
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            Assert.assertEquals("hasNext() should return true for existing elements in the list",
                    true, iter.hasNext());
            Assert.assertEquals("next() should return elements in order",
                    elemsToAdd[elemsToAdd.length - 1 - i], iter.next().intValue());
        }

        Assert.assertEquals("Iterator should not report elements for an empty list",
                false, iter.hasNext());
    }

    @Test
    public void forEachTest()
    {
        //add a few elements
        int[] elemsToAdd = {6, 4, 2};
        for (int i = 0; i < elemsToAdd.length; i++)
        {
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                3, list.size());

        //a for-each loop should run without error
        int count = 0;
        for (int element : list)
        {
            Assert.assertEquals("next() should return elements in order",
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
            list.add(elemsToAdd[i]);
        }
        Assert.assertEquals("The size of your queue should be 3 after calling add() 3 times",
                3, list.size());

        for (int element : list)
        {
            list.remove(2); //alter elements while iterating
        }
    }
}
