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

import prj5.LList.Node;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/13/2019
 */
public class SongSorter<T> {

    private LList<T> songList;
    private Node<Song> head;
    private int comparatorMethod;
    Node<Song> previousNode;


    /**
     * Constructor for song sorting class
     * 
     * @param songs
     *            linked list of songs to sort
     * @param compareMethod
     *            int representing compare method to use
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs, int compareMethod) {
        this.songList = (LList<T>)songs;
        this.head = (Node<Song>)songList.getHead();
        this.comparatorMethod = compareMethod;
        this.previousNode = null;

    }


    /**
     * insertion sort
     */
    public void insertionSort() {
        if (songList.size() >= 1) {
            assert head != null;
        }
        Node<Song> unsortedPart = head.next();

        head.setNext(null);
        while (unsortedPart != null) {
            Node<Song> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next();
            insertInOrder(nodeToInsert);
        }
    }


    /**
     * insert in order
     * 
     * @param nodeToInsert
     *            node to insert
     */
    @SuppressWarnings("unchecked")
    private void insertInOrder(Node<Song> nodeToInsert) {
        Song item = nodeToInsert.getData();
        Node<Song> currentNode = (Node<Song>)songList.getHead();
        previousNode = null;

        while ((currentNode != null) && compare(currentNode, item)) {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;

        }
    }


    /**
     * compares values to sort
     * 
     * @param currentNode
     *            current place
     * @param item
     *            item to compare
     * @return true if there is still room to sort, false otherwise
     */
    private boolean compare(Node<Song> currentNode, Song item) {
        switch (comparatorMethod) {
            case 1:
                if (item.compareArtist(currentNode.getData()) > 0) {
                    return true;
                }
                return false;
            case 2:
                if (item.compareDate(currentNode.getData()) > 0) {
                    return true;
                }
                return false;
            case 3:
                if (item.compareTitle(currentNode.getData()) > 0) {
                    return true;
                }
                return false;
            case 4:
                if (item.compareGenre(currentNode.getData()) > 0) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }


    /**
     * gets songList
     * 
     * @return songList
     */
    public LList<T> getSongList() {
        return songList;

    }

}
