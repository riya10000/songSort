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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kara Probasco (karap17)
 * @author Alisa Khuu (alisak22)
 * @author Riya Dani (riyadn99)
 * @author Marcus Tran (Tmarcus)
 * 
 * Class that reads from two given files, a applicantFile
 * and a songFile. The class stores the data 
 * received in the file which contains the survey data of each
 * participant into a People object, and the data received from the songFile
 * class is stored into a Song object
 * 
 * @version 4/16/2019
 */
public class FileReader {
    private LList<Song> songs;
    private ArrayList<People> peopleList;
    private SongSorter<Song> songSort;


    /**
     * Constructor for file reader class
     * 
     * @throws FileNotFoundException
     *             if files are not found
     * @throws ParseException
     * 
     */
    public FileReader(String applicantFile, String songFile)
        throws FileNotFoundException {
        this.peopleList = readSurveyFile(applicantFile, songFile);
        this.songs = readMusicFile(songFile);
        this.songSort = new SongSorter<>(songs);
        songSort.insertionSort(4);
        songs = songSort.getSongList();
        printer();
        this.songSort = new SongSorter<>(songs);
        songSort.insertionSort(3);
        songs = songSort.getSongList();
        printer();
        new GUIMusicWindow(songSort);
    }


    /**
     * Reads in song file to create song objects for each song and creates
     * linked list of songs
     * 
     * @param fileName
     *            song file
     * @return linked list of songs
     * @throws FileNotFoundException
     *             if file is not found
     */
    public LList<Song> readMusicFile(String fileName)
        throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));

        LList<Song> songs = new LList<Song>();
        int songIndex = 0;
        scan.nextLine();
        while (scan.hasNextLine()) {
            String stored = scan.nextLine();
            String[] splitter = stored.split(", *", -1);
            int year = Integer.parseInt(splitter[2]);

            Song extracted = new Song(splitter[0], splitter[1], year,
                splitter[3], peopleList, songIndex);
            songs.add(extracted);
            songIndex++;
        }

        scan.close();
        return songs;

    }


    /**
     * reads in survey results to create people objects and creates arrayList of
     * people objectsF
     * 
     * @param names
     *            file name
     * @return ArrayList of people object
     * @throws FileNotFoundException
     *             if file is not found
     */
    public ArrayList<People> readSurveyFile(String names, String songFile)
        throws FileNotFoundException {

        Scanner scan = new Scanner(new File(names));
        ArrayList<People> people = new ArrayList<People>();
        scan.nextLine();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line != null && !line.equals("") && line.split(
                ",").length > 4) {
                String[] blockSplit = line.split(", *", -1);
                String[] resp = new String[songFileLength(songFile) * 2];

                int count = 0;
                boolean make = true;
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
                        make = false;
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
                        make = false;
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
                        make = false;
                        break;
                }
                if (make) {
                    for (int i = 5; i < blockSplit.length; i++) {
                        resp[count] = blockSplit[i];
                        count++;
                    }

                    People p = new People(hobby, majoring, reg, resp);
                    people.add(p);
                }
            }
        }
        scan.close();

        return people;

    }


    /**
     * calculates how many songs are in file
     * 
     * @param fileName
     *            name of song file
     * @return number of song
     * @throws FileNotFoundException
     *             if file not found
     */
    private int songFileLength(String fileName)
        throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        int songNum = 0;
        scan.nextLine();
        while (scan.hasNextLine()) {
            scan.nextLine();
            songNum++;
        }

        scan.close();
        return songNum;
    }


    /**
     * Prints out sorted data for testing and intermediate submission
     */
    private void printer() {
        for (int i = 0; i < songs.size(); i++) {
            Song currentSong = songs.get(i);
            System.out.println("song title " + currentSong.getTitle()
                .toString());
            System.out.println("song artist " + currentSong.getArtist()
                .toString());
            System.out.println("song genre " + currentSong.getGenre()
                .toString());
            System.out.println("song year " + currentSong.getYear());
            System.out.println("heard");
            System.out.println("reading" + currentSong.heardPercent()[0][0]
                + " art" + currentSong.heardPercent()[0][1] + " sports"
                + currentSong.heardPercent()[0][2] + " music" + currentSong
                    .heardPercent()[0][3]);
            System.out.println("likes");
            System.out.println("reading" + currentSong.likesPercent()[0][0]
                + " art" + currentSong.likesPercent()[0][1] + " sports"
                + currentSong.likesPercent()[0][2] + " music" + currentSong
                    .likesPercent()[0][3]);
            System.out.println();
        }
    }

}
