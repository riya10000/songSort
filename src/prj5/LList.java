package prj5;
/**
 * changes from first UML: iterator has no remove(), singly linked list
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Kara Probasco (karap17)
 * @version 4/10/2019
 * @param <T>
 *            generic type for linked listed
 */
public class LList<T> implements Iterable<T> {

    private Node<T> head;

    // the size of the linked list
    private int size;


    /**
     * Creates a new LinkedList object
     */
    public LList() {
        head = null;
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * returns head
     * 
     * @return head of list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * returns head
     * 
     * @return head of list
     */
    public void setHead(Node<T> node) {
        head = node;
    }

    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        if (index == 0) {
            Node<T> newNode = new Node<T>(obj);
            newNode.setNext(head);
            head = newNode;
        }
        else {
            int currentIndex = 0;
            while (current != null) {
                if ((currentIndex + 1) == index) {
                    Node<T> nextNext = current.next;
                    Node<T> newNode = new Node<T>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);

                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;
        if (isEmpty()) {
            head = new Node<T>(obj);
        }

        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successfully removed, false otherwise
     */
    public boolean remove(T obj) {
        Node<T> current = head;

        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public T remove(int index) {
        T item = null;
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<T> current = head;
            int currentIndex = 0;

            // account for 1 size
            if ((index == 0)) {
                item = head.getData();
                head = head.next;
                size--;
                return item;
            }

            // account for 2+ size
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    if (currentIndex + 1 == this.size() - 1) {
                        item = this.get(index);
                        current.setNext(null);
                    }
                    else {
                        item = this.get(index);
                        Node<T> newNext = current.next.next;
                        current.setNext(newNext);
                    }
                    size--;
                    return item;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        if (data == null) {
            throw new IndexOutOfBoundsException();
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        Node<T> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T obj) {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LList<T> other = ((LList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = this.head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new LListIterator<T>();
    }


    private class LListIterator<P> implements Iterator<T> {
        private Node<T> next;
        private Node<T> previous;
        private Node<T> previous2;
        private boolean nextCalled;


        /**
         * Creates a new DLListIterator
         */
        public LListIterator() {
            next = head;
            previous = null;
            previous2 = null;
            nextCalled = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (hasNext()) {
                Node<T> tempNode = next;
                previous2 = previous;
                previous = next;
                next = next.next();
                nextCalled = true;
                return (T)tempNode.getData();
            }
            else {
                throw new NoSuchElementException(
                    "There are no more elements in the list");
            }
        }


        /**
         * removes next element from iterator
         */
        @Override
        public void remove() {
            if (previous == null || !nextCalled) {
                throw new IllegalStateException();
            }
            if (previous2 == null) {
                head = next;
            }
            else {
                previous2.setNext(next);
                previous = previous2;
            }
            nextCalled = false;
        }
    }


    /**
     * private node class for linked list
     * 
     * @author proba
     *
     * @param <A>
     *            generic
     */
    public static class Node<A> {
        private Node<A> next;
        private A data;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(A d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<A> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<A> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public A getData() {
            return data;
        }
    }
}
