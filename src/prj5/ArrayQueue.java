/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Riya Dani (riyadn99)
 */
package prj5;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Creates a queue of people that need to be accepted or rejected
 *
 * @author Riya Dani riyadn99
 * @version 04/02/2019
 * @param <T>
 *            The type of object the queue will hold
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * Sets indices to 0 and size to 0 after creating empty queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * Retrieves the length of the queue
     * 
     * @return queue.length The length of the queue
     */
    public int getLength() {
        return queue.length;

    }


    /**
     * Retrieves the size of the queue
     * 
     * @return size The size of the queue
     */
    public int getSize() {
        return size;

    }


    /**
     * States if the queue has no people
     * 
     * @return size == 0;
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * States if the queue has people filled to capacity
     * 
     * @return dequeueIndex == ((enqueueIndex + 1) % queue.length) Gap between
     *         first index and last index is only 1;
     */
    private boolean isFull() {
        return dequeueIndex == ((enqueueIndex + 1) % queue.length);

    }


    /**
     * A person wants to be added to the queue in the back
     * 
     * @param newEntry
     *            A new person that wants to be added to the queue
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public void enqueue(Object newEntry) {
        ensureCapacity();
        queue[enqueueIndex] = (T)newEntry;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    /**
     * Used to upgrade the length of the queue when the queue is full
     * 
     */
    private void ensureCapacity() {

        if (isFull()) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length - 1;
            int newSize = 2 * oldSize + 1;

            if (newSize - 1 >= MAX_CAPACITY) {
                throw new IllegalStateException();
            }

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            queue = tempQueue;

            for (int index = 0; index < oldSize; index++) {
                queue[index] = oldQueue[dequeueIndex];
                dequeueIndex = incrementIndex(dequeueIndex);
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize;

        }

    }


    /**
     * The first person in the queue is getting out of line
     * 
     * @return front
     *         The first person in the queue
     * 
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();

        }
        else {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = incrementIndex(dequeueIndex);
            size--;
            return front;
        }

    }


    /**
     * retrieves the first person in line
     * 
     * @return queue[dequeueIndex] The first person in line
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return queue[dequeueIndex];
        }

    }


    /**
     * Empties and resets the queue to 0
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = temp;
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = 0;
    }


    /**
     * Allows the queue to be circular
     * 
     * @return ((index + 1) % queue.length) Wraps the queue
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);

    }


    /**
     * Presents the queue in an array
     * 
     * @return current The Array of the queue
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        @SuppressWarnings("unchecked")
        T[] current = (T[])new Object[size];
        int dequecurrentIndex = dequeueIndex;
        for (int i = 0; i < size; i++) {
            current[i] = queue[dequecurrentIndex];
            dequecurrentIndex = incrementIndex(dequecurrentIndex);
            // }
        }
        return current;

    }


    /**
     * Presents the queue as a string with brackets
     * 
     * @return string.toString() The queue transposed to a string
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if (isEmpty()) {
            return "[]";
        }

        Object[] tempArray = toArray();
        for (int i = 0; i < tempArray.length; i++) {
            if (i != tempArray.length - 1) {
                string.append(tempArray[i].toString() + ", ");
            }
            else {
                string.append(tempArray[i].toString());

            }
        }
        string.append("]");
        return string.toString();

    }


    /**
     * 
     * Checks if any queue equals another queue based on size and
     * elements
     * 
     * @param obj
     *            The object that its being compared to
     * @return false The queue does not equal the obj
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass().equals(obj.getClass())) {

            @SuppressWarnings("unchecked")

            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            {
                if (this.getSize() == other.getSize()) {
                    for (int i = 0; i < getSize(); i++) {

                        T myElement = queue[(dequeueIndex + i) % getLength()];

                        T otherElement = other.queue[(other.dequeueIndex + i)
                            % other.getLength()];

                        if (!myElement.equals(otherElement)) {

                            return false;

                        }

                    }
                    return true;

                }
            }
        }

        return false;

    }

}
