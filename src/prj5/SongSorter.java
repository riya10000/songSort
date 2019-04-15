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

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/13/2019
 */
public class SongSorter<T> {

    private LList<T> songList;
    private int comparatorMethod;


    /**
     * 
     */
    @SuppressWarnings("unchecked")
    public SongSorter(LList<Song> songs, int compareMethod) {
        this.songList = (LList<T>)songs;
        this.comparatorMethod = compareMethod;

    }


    public LList<T> insertionSort() {
        LList<T> newList = new LList<>();
        assert songList.get(0) != null;
        newList.add(songList.remove(0));
        
        while (!songList.isEmpty()) {
            int size = newList.size();
            T song = songList.remove(0);
            int i = 0;
            for(T compared : newList) {
                switch (comparatorMethod) {
                    case 1:
                        if (((Song)song).compareArtist((Song)compared) > 0) {
                            newList.add(i, song);
                        }
                        break;
                    case 2:
                        if (((Song)song).compareDate((Song)compared) > 0) {
                            newList.add(i, song);
                        }
                        break;
                    case 3:
                        if (((Song)song).compareTitle((Song)compared) > 0) {
                            newList.add(i, song);
                        }
                        break;
                    case 4:
                        if (((Song)song).compareGenre((Song)compared) > 0) {
                            newList.add(i, song);
                        }
                        break;
                    default:
                        break;
                }
            }
            
            i++;
            if(i == size) {
                newList.add(song);
                break;
            }
        }
        songList = newList;
        return newList;
    }

    /*
    @SuppressWarnings("unchecked")
    private void insertInOrder(T compared) {
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
    */

    public LList<T> getSongList() {
        return songList;

    }

}
