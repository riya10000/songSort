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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/12/2019
 * @param <E>
 */
public class FileReader {
    private LList<Song> songs;
    private ArrayList<People> peopleQueue;
    private SongSorter<Song> songSort;


    /**
     * @throws FileNotFoundException 
     * 
     */
    public FileReader(String applicantFile, String songFile) throws FileNotFoundException {
        this.peopleQueue = readSurveyFile(applicantFile);
        this.songs = readMusicFile(songFile);
        this.songSort = new SongSorter<>(songs, 1);
        new GUIMusicWindow(songs, peopleQueue);
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


    public ArrayList<People> readSurveyFile(String names)
        throws FileNotFoundException {

        Scanner scan = new Scanner(new File(names));
        ArrayList<People> people = new ArrayList<People>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            String[] blockSplit = line.split(", *", -1);
            String[] resp = null;

            int count = 0;
            boolean make = false;
            MajorEnum majoring = null;
            RegionEnum reg = null;
            HobbyEnum hobby = null;

            switch (blockSplit[2]) {
                case "Math or CMDA":
                    majoring = MajorEnum.MATHCMDA;
                    break;
                case "Computer Science":
                    majoring = MajorEnum.COMPSCI;
                    break;
                case "Other Engineering":
                    majoring = MajorEnum.OTHERENG;
                    break;
                case "Other":
                    majoring = MajorEnum.OTHER;
                    break;
                default:
                    make = true;
                    break;
            }
            switch (blockSplit[3]) {
                case "Southeast":
                    reg = RegionEnum.SE_US;
                    break;
                case "Northeast":
                    reg = RegionEnum.NE_US;
                    break;
                case "United States (other than Southeast or Northwest)":
                    reg = RegionEnum.OTHER_US;
                    break;
                case "Outside of United States":
                    reg = RegionEnum.OUTSIDE_US;
                    break;
                default:
                    make = true;
                    break;
            }

            switch (blockSplit[4]) {
                case "sports":
                    hobby = HobbyEnum.SPORTS;
                    break;
                case "music":
                    hobby = HobbyEnum.MUSIC;
                    break;
                case "reading":
                    hobby = HobbyEnum.READ;
                    break;
                case "art":
                    hobby = HobbyEnum.ART;
                    break;
                default:
                    make = true;
                    break;
            }

            for (int i = 0; i < blockSplit.length; i++) {
                if (blockSplit[i].equals("yes") || blockSplit[i].equals("no")) {
                    resp[count] = blockSplit[i];
                    count++;

                }

            }
            People p = new People(hobby, majoring, reg, resp);
            people.add(p);

        }
        scan.close();

        return people;

    }

}
