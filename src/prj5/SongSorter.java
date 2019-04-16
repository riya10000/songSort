/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Riya Dani (riyadn99), Kara Probasco (karap17), Alisa Khuu (alisak22),
 * Marcus Tran (Tmarcus)
 */
package prj5;

import prj5.LList.Node;

/**
 * @author Kara Probasco (karap17)
 * @author Alisa Khuu (alisak22)
 * @author Riya Dani (riyadn99)
 * @author Marcus Tran (Tmarcus)
 * 
 * @version 4/16/2019
 * 
 * @param <T>
 *            generic type for sorter
 */
public class SongSorter<T> {

    private LList<T> songList;
    private Node<Song> previousNode;


    /**
     * Constructor for song sorting class
     * 
     * @param songs
     *            linked list of songs to sort
     * 
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs) {
        this.songList = (LList<T>)songs;
        this.previousNode = null;

    }


    /**
     * insertion sort
     * 
     * @param comparator
     *            which compare method to use
     */
    public void insertionSort(int comparator) {
        if (songList.size() > 1) {
            @SuppressWarnings("unchecked")
            Node<Song> head = (Node<Song>)songList.getHead();
            Node<Song> unsortedPart = head.next();

            head.setNext(null);
            while (unsortedPart != null) {
                Node<Song> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrder(nodeToInsert, comparator);
            }
        }
    }


    /**
     * insert in order method
     * 
     * @param nodeToInsert
     *            node to insert
     */
    @SuppressWarnings("unchecked")
    private void insertInOrder(Node<Song> nodeToInsert, int comparator) {
        Song item = nodeToInsert.getData();
        Node<Song> currentNode = (Node<Song>)songList.getHead();
        previousNode = null;

        while ((currentNode != null) && compare(currentNode, item,
            comparator)) {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext((Node<Song>)songList.getHead());
            songList.setHead((Node<T>)nodeToInsert);

        }
    }


    /**
     * compares values to sort, helper method
     * 
     * @param currentNode
     *            current place
     * @param item
     *            item to compare
     * @param comparator
     *            which compare method to use
     * @return true if there is still room to sort, false otherwise
     */
    private boolean compare(Node<Song> currentNode, Song item, int comparator) {
        switch (comparator) {
            case 1:
                return item.compareArtist(currentNode.getData()) > 0;
            case 2:
                return item.compareDate(currentNode.getData()) > 0;
            case 3:
                return item.compareTitle(currentNode.getData()) > 0;
            case 4:
                return item.compareGenre(currentNode.getData()) > 0;
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
