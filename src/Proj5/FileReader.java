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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import spacecolonies.ArrayQueue;
import spacecolonies.Person;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/12/2019
 * @param <E>
 */
public class FileReader<E> {
    private LList<E> songs;
    private ArrayList<People> peopleQueue;
    private SongSorter songSort;


    /**
     * 
     */
    public FileReader(String applicantFile, String songFile) {
        peopleQueue = this.readSurveyFile(applicantFile);
        songSort = this.readMusicFile(songFile);
        songSort = new SongSorter(peopleQueue, songs);
        new GUIMusicWindow(songSorter);
    }


    public LList<Song> readMusicFile(String fileName)
        throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));

        LList<Song> songs = new LList<Song>();
        int songIndex = 0;
        while (scan.hasNextLine()) {
            String stored = scan.nextLine();
            String[] splitter = stored.split(",");
            int year = Integer.parseInt(splitter[2]);

            Song extracted = new Song(splitter[0], splitter[1], year,
                splitter[3], peopleQueue, songIndex);
            songIndex++;
        }
        
        return songs;

    }


    public ArrayQueue<People> readSurveyFile(String names) {

        Scanner scan = new Scanner(new File(names));
        ArrayQueue<People> queue = new ArrayQueue<People>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(", *", -1);
            People p = new People((split[4]),(
                split[5]), (split[6]), ); //how to get the array of yes/no? 
            
        }
        scan.close();
        return queue;

    }

}
