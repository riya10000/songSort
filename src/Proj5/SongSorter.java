/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Riya Dani (riyadn99)
 */
package Proj5;

import bag.Node;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/13/2019
 */
public class SongSorter<T> {

    private LList<T> songList;
    private Node<T> head;
    private int comparatorMethod;


    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs, int compareMethod) {
        this.songList = (LList<T>)songs;
        this.head = (Node<T>)songList.get(0);
        this.comparatorMethod = compareMethod;

    }


    public void insertionSort() {
        if (songList.size() > 1) {
            assert head != null;
        }
        Node<T> unsortedPart = head.next();
        assert unsortedPart != null;

        head.setNext(null);
        while (unsortedPart != null) {
            Node<T> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next();
            insertInOrder(nodeToInsert);
        }
    }


    @SuppressWarnings("unchecked")
    private void insertInOrder(Node<T> nodeToInsert) {
        @SuppressWarnings("unchecked")
        T item = (T)nodeToInsert.data();
        @SuppressWarnings("unchecked")
        Node<T> currentNode = (Node<T>)songList.get(0);
        Node<T> previousNode = null;

        while ((currentNode != null)) {
            switch (comparatorMethod) {
                case 1:
                    if (((Song)item).compareArtist((Song)currentNode
                        .data()) > 0) {
                        previousNode = currentNode;
                        currentNode = currentNode.next();
                    }
                    break;
                case 2:
                    if (((Song)item).compareDate((Song)currentNode
                        .data()) > 0) {
                        previousNode = currentNode;
                        currentNode = currentNode.next();
                    }
                    break;
                case 3:
                    if (((Song)item).compareTitle((Song)currentNode
                        .data()) > 0) {
                        previousNode = currentNode;
                        currentNode = currentNode.next();
                    }
                case 4:
                    if (((Song)item).compareGenre((Song)currentNode
                        .data()) > 0) {
                        previousNode = currentNode;
                        currentNode = currentNode.next();
                    }
                    break;
                default:
                    break;
            }
        }
        if (previousNode != null) {
            (previousNode).setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;

        }
    }


    public LList<T> getSongList() {
        return songList;

    }

}
