/**
 * 
 */
package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import prj5.LList.Node;

/**
 * @author Kara Probasco (karap17)
 *
 */
public class LListTest extends student.TestCase {
    private LList<String> list1;
    private LList<String> list2;
    private LList<String> list3;
    private LList<String> list4;
    private LList<String> list5;
    private LList<String> list6;
    private String sup;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        list1 = new LList<String>();
        list2 = new LList<String>();
        list3 = new LList<String>();
        list4 = new LList<String>();

        list3.add("sup");
        list3.add("hi");
        list3.add("yo");

        list4.add("sup");
        list4.add("hi");
        list4.add("yo");

        list5 = new LList<String>();

        for (int i = 0; i < 100; i++) {
            list5.add("sport" + i);
        }

        list6 = new LList<String>();
        for (int i = 0; i < 100; i++) {
            list6.add("sport" + i);
        }

        sup = null;
    }


    /**
     * tests setHead()
     */
    public void testsetHead() {
        Node<String> newNode = new Node<>("peanut");
        list6.setHead(newNode);
        assertEquals("peanut", list6.get(0));
    }


    /**
     * tests add() method without given index
     */
    public void testadd() {
        Exception exception = null;
        try {
            list3.add(null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

        list1.add("peanut");
        assertEquals(1, list1.size());
        assertEquals("peanut", list1.get(0));
        list1.add("cake");
        assertEquals(2, list1.size());
        assertEquals("cake", list1.get(1));

        list5.add("pie");
        assertEquals(101, list5.size());
        assertEquals("pie", list5.get(100));
    }


    /**
     * tests add() method with given index
     */
    public void testaddIndex() {
        Exception exception = null;
        try {
            list3.add(0, null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            list3.add(-1, "sup");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list3.add(list3.size() + 1, "sup");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        list1.add(0, "peanut");
        assertEquals(1, list1.size());
        assertEquals("peanut", list1.get(0));
        list1.add(0, "cake");
        assertEquals(2, list1.size());
        assertEquals("cake", list1.get(0));
        list1.add(2, "hip");
        assertEquals(3, list1.size());
        assertEquals("hip", list1.get(2));

        list5.add(15, "pie");
        assertEquals(101, list5.size());
        assertEquals("pie", list5.get(15));

        list5.add(101, "cake");
        assertEquals(102, list5.size());
        assertEquals("cake", list5.get(101));
    }


    /**
     * tests isEmpty()
     */
    public void testisEmpty() {
        assertTrue(list1.isEmpty());
        assertEquals(false, list3.isEmpty());
    }


    /**
     * test remove() for a specified object
     */
    public void testremoveObject() {
        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("hello");

        assertEquals(false, list2.remove("peanut"));

        assertEquals(true, list2.remove("cake"));
        assertEquals(false, list2.contains("cake"));
        assertEquals(4, list2.size());
        assertEquals("pie", list2.get(0));

        assertEquals(true, list2.remove("hello"));
        assertEquals(false, list2.contains("hello"));
        assertEquals(3, list2.size());
        assertEquals("pizza", list2.get(2));

        assertEquals(true, list2.remove("cookie"));
        assertEquals(false, list2.contains("cookie"));
        assertEquals(2, list2.size());
        assertEquals("pizza", list2.get(1));

        assertEquals(true, list2.remove("pizza"));
        assertEquals(false, list2.contains("pizza"));
        assertEquals(1, list2.size());
        assertEquals("pie", list2.get(0));

        assertEquals(true, list2.remove("pie"));
        assertEquals(false, list2.contains("pie"));
        assertEquals(0, list2.size());
        assertTrue(list2.isEmpty());

        assertEquals(false, list1.remove("hello"));
    }


    /**
     * test remove() for a specified index
     */
    public void testremoveIndex() {
        Exception exception = null;
        try {
            list3.remove(-1);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            list2.remove(0);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("hello");

        exception = null;
        try {
            list3.remove(8);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        assertEquals("cake", list2.remove(0));
        assertEquals(4, list2.size());
        assertEquals("pie", list2.get(0));

        assertEquals("hello", list2.remove(3));
        assertEquals(3, list2.size());
        assertEquals("pizza", list2.get(2));

        assertEquals("cookie", list2.remove(1));
        assertEquals(2, list2.size());
        assertEquals("pizza", list2.get(1));

        assertEquals("pizza", list2.remove(1));
        assertEquals(1, list2.size());
        assertEquals("pie", list2.get(0));

        assertEquals("pie", list2.remove(0));
        assertEquals(0, list2.size());
        assertTrue(list2.isEmpty());

        assertEquals("sport99", list5.remove(99));
        assertEquals(99, list5.size());
        assertEquals("sport98", list5.get(98));

    }


    /**
     * tests get()
     */
    public void testget() {
        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("hello");

        Exception exception = null;
        try {
            list2.get(10);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list2.get(-1);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        assertEquals("cake", list2.get(0));
        assertEquals("hello", list2.get(4));
        assertEquals("cookie", list2.get(2));

        assertEquals("sport99", list5.get(99));

    }


    /**
     * tests contains()
     */
    public void testcontains() {
        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("hello");

        assertTrue(list2.contains("cake"));
        assertTrue(list2.contains("cookie"));
        assertTrue(list2.contains("hello"));
        assertEquals(false, list2.contains("yoyo"));

        assertEquals(false, list5.contains("sport100"));
        assertTrue(list5.contains("sport77"));

        assertEquals(false, list1.contains("sport100"));
    }


    /**
     * tests clear()
     */
    public void testclear() {
        list3.clear();
        list4.clear();
        list5.clear();
        list1.clear();

        assertTrue(list3.equals(list4));
        assertTrue(list5.equals(list1));
        assertEquals(0, list3.size());
        assertEquals(0, list4.size());
        assertEquals(0, list5.size());
    }


    /**
     * tests lastIndexOf()
     */
    public void testlastIndexOf() {
        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("hello");
        list2.add("cookie");
        list2.add("pizza");
        list2.add("cookie");

        assertEquals(7, list2.lastIndexOf("cookie"));

        list5.add("sport0");
        assertEquals(100, list5.lastIndexOf("sport0"));

        assertEquals(-1, list5.lastIndexOf("cookie"));
    }


    /**
     * tests toString()
     */
    public void testtoString() {
        list2.add("cake");
        list2.add("pie");
        list2.add("cookie");

        String string = "{cake, pie, cookie}";

        assertEquals(string, list2.toString());

        assertEquals("{}", list1.toString());
    }


    /**
     * Tests the equals method on an empty list
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertEquals(list3, list3);
        assertEquals(list3, list4);
        assertFalse(list3.equals(sup));
        assertFalse(list3.equals("cake"));
        assertFalse(list3.equals(list5));
        assertFalse(list3.equals(list1));
        list4.add("pizzas");
        assertFalse(list3.equals(list4));

        list3.add("pie");
        assertFalse(list3.equals(list4));

        list3.remove("pie");
        list3.add("pizzas");
        assertEquals(list3, list4);

        assertEquals(list5, list5);
        assertEquals(list5, list6);
        assertFalse(list5.equals(sup));
        assertFalse(list5.equals("pie"));
        assertFalse(list5.equals(list3));
        assertFalse(list5.equals(list1));
        list6.add("juice");
        assertFalse(list5.equals(list6));

        list6.clear();
        assertFalse(list5.equals(list6));
        for (int i = 100; i > 0; i--) {
            list6.add("sport" + i);
        }
        assertFalse(list5.equals(list6));

        list6.clear();
        assertFalse(list5.equals(list6));
        for (int i = 0; i < 50; i++) {
            list6.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            list6.add("sport" + i);
        }
        assertFalse(list5.equals(list6));

        list6.clear();
        assertFalse(list5.equals(list6));
        for (int i = 0; i < 100; i++) {
            list6.add("sport" + i);
        }
        assertEquals(list5, list6);

        assertEquals(list1, list1);
        assertEquals(list1, list2);
        assertFalse(list1.equals(sup));
        assertFalse(list1.equals("cake"));
        assertFalse(list1.equals(list3));
        assertFalse(list3.equals(list1));
        list2.add("cake");
        assertFalse(list1.equals(list2));
        list3.clear();
        assertEquals(list1, list3);
    }


    /**
     * Tests toArray()
     */
    public void testToArray() {

        Object[] emptyArr = {};
        assertTrue(Arrays.equals(list1.toArray(), emptyArr));
        assertTrue(Arrays.equals(list1.toArray(), list2.toArray()));
        assertFalse(Arrays.equals(list1.toArray(), list3.toArray()));
        Object[] singleArr = { "one thing" };
        list1.add("one thing");
        assertTrue(Arrays.equals(list1.toArray(), singleArr));

        Object[] arr = { "sup", "hi", "yo" };
        assertTrue(Arrays.equals(list3.toArray(), arr));
        assertFalse(Arrays.equals(list3.toArray(), list6.toArray()));

    }


    /**
     * tests iterator()
     */
    public void testiterator() {
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        Iterator<String> iter = list1.iterator();

        Exception exception = null;
        try {
            iter.remove();
        }
        catch (IllegalStateException e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);

        assertEquals(true, iter.hasNext());
        assertEquals("A", iter.next());
        iter.remove();
        assertEquals("B", iter.next());
        iter.remove();
        assertEquals("C", iter.next());
        iter.remove();
        assertEquals("D", iter.next());
        iter.remove();

        assertEquals(false, iter.hasNext());

        exception = null;
        try {
            iter.remove();
        }
        catch (IllegalStateException e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);

        exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }

        assertTrue(exception instanceof NoSuchElementException);
    }
}
