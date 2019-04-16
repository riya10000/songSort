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
    private ArrayList<People> peopleArList;
    private People person1;
    private People person2;
    private People person3;
    private People person4;
    private People person5;
    private String[] stringAr;
    private String[] stringAr2;
    private String[] stringAr3;
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;

    private SongSorter<String> sort;
    private SongSorter<String> sort2;

    private LList<Song> songs;
    private LList<Song> songs2;


    /**
     * 
     */
    public SongSorterTest() {

        stringAr = new String[8];
        stringAr[0] = "Yes";
        stringAr[1] = "Yes";
        stringAr[2] = "Yes";
        stringAr[3] = "Yes";
        stringAr[4] = "Yes";
        stringAr[5] = "Yes";
        stringAr[6] = "Yes";
        stringAr[7] = "Yes";
        person1 = new People(HobbyEnum.ART, MajorEnum.COMPSCI,
            RegionEnum.OTHER_US, stringAr);

        stringAr2 = new String[8];
        stringAr2[0] = "Yes";
        stringAr2[1] = "Yes";
        stringAr2[2] = "Yes";
        stringAr2[3] = "Yes";
        stringAr2[4] = "Yes";
        stringAr2[5] = "Yes";
        stringAr2[6] = "Yes";
        stringAr2[7] = "Yes";
        person2 = new People(HobbyEnum.READ, MajorEnum.OTHERENG,
            RegionEnum.SE_US, stringAr2);
        person3 = new People(HobbyEnum.MUSIC, MajorEnum.OTHER, RegionEnum.NE_US,
            stringAr);
        person4 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OUTSIDE_US, stringAr2);

        stringAr3 = new String[8];
        stringAr3[0] = "";
        stringAr3[1] = "";
        stringAr3[2] = "no";
        stringAr3[3] = "no";
        stringAr3[4] = "";
        stringAr3[5] = "";
        stringAr3[6] = "no";
        stringAr3[7] = "no";

        person5 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OUTSIDE_US, stringAr3);

        peopleArList = new ArrayList<>();
        peopleArList.add(person1);
        peopleArList.add(person2);
        peopleArList.add(person3);
        peopleArList.add(person4);
        peopleArList.add(person5);

        song = new Song("Boy With Luv", "BTS", 2019, "Pop", peopleArList, 0);
        song2 = new Song("Idol", "bts", 2018, "pop", peopleArList, 1);
        song3 = new Song("Noir", "Sunmi", 2018, "kPop", peopleArList, 2);
        song4 = new Song("No More Dream", "BTS", 2013, "Hip-Hop", peopleArList,
            3);

        songs = new LList<Song>();
        songs.add(song);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        sort = new SongSorter<String>(songs);

        songs2 = new LList<Song>();
        sort2 = new SongSorter<String>(songs);
        songs2.add(song);

    }


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


    public void testGetSongList() {
        assertNotNull(sort.getSongList());

    }

}
