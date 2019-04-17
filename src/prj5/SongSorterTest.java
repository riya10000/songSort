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

/**
 * @author Kara Probasco (karap17)
 * @author Alisa Khuu (alisak22)
 * @author Riya Dani (riyadn99)
 * @author Marcus Tran (Tmarcus)
 * 
 * @version 4/16/2019
 */
import java.util.ArrayList;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/15/2019
 */
public class SongSorterTest extends student.TestCase {
    private SongSorter<String> sort;

    private LList<Song> songs;


    /**
     * Constructor that initializes all of the variables needed for
     * the test cases.
     */
    public SongSorterTest() {
        String[] stringAr = new String[8];
        stringAr[0] = "Yes";
        stringAr[1] = "Yes";
        stringAr[2] = "Yes";
        stringAr[3] = "Yes";
        stringAr[4] = "Yes";
        stringAr[5] = "Yes";
        stringAr[6] = "Yes";
        stringAr[7] = "Yes";
        People person1 = new People(HobbyEnum.ART, MajorEnum.COMPSCI,
            RegionEnum.OTHER_US, stringAr);

        String[] stringAr2 = new String[8];
        stringAr2[0] = "Yes";
        stringAr2[1] = "Yes";
        stringAr2[2] = "Yes";
        stringAr2[3] = "Yes";
        stringAr2[4] = "Yes";
        stringAr2[5] = "Yes";
        stringAr2[6] = "Yes";
        stringAr2[7] = "Yes";
        People person2 = new People(HobbyEnum.READ, MajorEnum.OTHERENG,
            RegionEnum.SE_US, stringAr2);
        People person3 = new People(HobbyEnum.MUSIC, MajorEnum.OTHER,
            RegionEnum.NE_US, stringAr);
        People person4 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OUTSIDE_US, stringAr2);

        String[] stringAr3 = new String[8];
        stringAr3[0] = "";
        stringAr3[1] = "";
        stringAr3[2] = "no";
        stringAr3[3] = "no";
        stringAr3[4] = "";
        stringAr3[5] = "";
        stringAr3[6] = "no";
        stringAr3[7] = "no";

        People person5 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OUTSIDE_US, stringAr3);

        ArrayList<People> peopleArList = new ArrayList<>();
        peopleArList.add(person1);
        peopleArList.add(person2);
        peopleArList.add(person3);
        peopleArList.add(person4);
        peopleArList.add(person5);

        Song song = new Song("Boy With Luv", "BTS", 2019, "Pop", peopleArList,
            0);
        Song song2 = new Song("Idol", "bts", 2018, "pop", peopleArList, 1);
        Song song3 = new Song("Noir", "Sunmi", 2018, "kPop", peopleArList, 2);
        Song song4 = new Song("No More Dream", "BTS", 2013, "Hip-Hop",
            peopleArList, 3);

        songs = new LList<Song>();
        songs.add(song);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        sort = new SongSorter<String>(songs);

    }


    /**
     * Tests the insertion sort by doing different types of insertion
     * sort onto the songList inside the SongSorter object, and ensures
     * that the method is sorting correctly
     */
    public void testInsertionSort() {
        sort.insertionSort(1);
        sort.insertionSort(2);
        sort.insertionSort(4);
        sort.insertionSort(3);

        assertEquals(songs, sort.getSongList());

        LList<Song> song5 = new LList<Song>();

        SongSorter<String> sort3 = new SongSorter<String>(song5);
        sort3.insertionSort(1);

    }


    /**
     * Tests the compare method for different types of switch cases found
     * within the class itself
     */
    public void testCompare() {
        // Testing Case 1
        SongSorter<Song> sort3 = new SongSorter<Song>(songs);
        sort3.insertionSort(1);

        assertEquals(songs, sort.getSongList());

        // Testing Default Case
        SongSorter<Song> sortDefault = new SongSorter<Song>(songs);
        sortDefault.insertionSort(10);

        assertEquals(songs, sortDefault.getSongList());
    }


    /**
     * Tests the getter method to ensure it returns a file
     */
    public void testGetSongList() {
        assertNotNull(sort.getSongList());

    }

}
