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
    private ArrayQueue<People> peopleQueue;
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


    public LList<Songs> readMusicFile(String fileName){
        Scanner scan = new Scanner(new File(fileName);
        
        
        
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
