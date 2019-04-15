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

import java.util.Iterator;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/13/2019
 */
public class SongSorter<T> {

    private LList<T> songList;
    private Iterator<T> iter;
    private int comparatorMethod;


    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs, int compareMethod) {
        this.songList = (LList<T>)songs;
        iter = songList.iterator();
        this.comparatorMethod = compareMethod;

    }


    public void insertionSort() {
        T song;
        assert iter.hasNext();
        song = iter.next();
        assert iter.hasNext();

        songList.clear();

        songList.add(song);
        iter.remove();
        
        while (iter.hasNext()) {
            Iterator<T> newIter = songList.iterator();
            song = iter.next();
            while(newIter.hasNext()) {
                insertInOrder(song, newIter);
            }
        }
    }


    @SuppressWarnings("unchecked")
    private void insertInOrder(T song, Iterator<T> newIter) {
        T songCheck = newIter.next();

        /*
        switch (comparatorMethod) {
            case 1:
                if (((Song)songCheck).compareArtist((Song) song) > 0) {
                    newIter.previous();
                    break;
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
        newIter.add(song);
        */
    }


    public LList<T> getSongList() {
        return songList;

    }

}
