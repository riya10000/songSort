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


    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs) {
        this.head = (Node<T>)songList.get(0);

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
            if (((Song)item).compareArtist(currentNode).data() > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }

            else if (((Song)item).compareDate(currentNode).data() > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
            else if (((Song)item).compareTitle(currentNode).data() > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next();
            }
            else if (((Song)item).compareGenre(currentNode).data() > 0) {
                previousNode = currentNode;
                currentNode = currentNode.next();
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
