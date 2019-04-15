/**
 * 
 */
package prj5;

import java.util.ArrayList;

/**
 * @author proba
 *
 */
public class SongTest extends student.TestCase {

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


    /**
     * sets up for tests
     */
    public void setUp() {
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
    }


    /**
     * tests getTitle()
     */
    public void testgetTitle() {
        assertEquals("Boy With Luv", song.getTitle());
    }


    /**
     * tests getArtist()
     */
    public void testgetArtist() {
        assertEquals("BTS", song.getArtist());
    }


    /**
     * tests getGenre()
     */
    public void testgetGenre() {
        assertEquals("Pop", song.getGenre());
    }


    /**
     * tests getYear
     */
    public void testgetYear() {
        assertEquals(2019, song.getYear());
    }


    /**
     * tests getHeardOf
     */
    public void testgetHeardOf() {
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song.getHeardOf()[i][j]);
            }
        }

    }


    /**
     * tests getLikes()
     */
    public void testgetLikes() {
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song.getLikes()[i][j]);
            }
        }
    }


    /**
     * tests getFeedback()
     */
    public void testgetFeedback() {
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song.getFeedback()[i][j]);
            }
        }
    }


    /**
     * tests getIndex()
     */
    public void testgetIndex() {
        assertEquals(0, song.getSongIndex());
    }


    /**
     * tests toString()
     */
    public void testtoString() {
        assertEquals("Boy With Luv by BTS, 2019, Pop", song.toString());
    }


    /**
     * tests comapreTitle
     */
    public void testcompareTitle() {
        assertTrue(song4.compareTitle(song) > 1);
        assertTrue(song.compareTitle(song3) < -1);
        assertTrue(song.compareTitle(song) == 0);
    }


    /**
     * tests compareArtist
     */
    public void testcompareArtist() {
        assertTrue(song3.compareArtist(song) > 1);
        assertTrue(song.compareArtist(song3) < -1);
        assertTrue(song4.compareArtist(song2) == 0);
    }


    /**
     * tests compareGenre()
     */
    public void testcompareGenre() {
        assertTrue(song2.compareGenre(song) > 1);
        assertTrue(song.compareGenre(song3) < -1);
        assertTrue(song.compareGenre(song) == 0);
    }


    /**
     * test compareDate()
     */
    public void testCompareDate() {
        assertTrue(song.compareDate(song2) == 1);
        assertTrue(song4.compareDate(song) == -1);
        assertTrue(song2.compareDate(song3) == 0);
    }
    
    
    /**
     * tests heardPercent
     */
    public void testheardPercent() {
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 100;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song.heardPercent()[i][j]);
            }
        }
    }
    
    /**
     * tests likes percent
     */
    public void testlikesPercent() {
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 100;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song.likesPercent()[i][j]);
            }
        }
    }
}
