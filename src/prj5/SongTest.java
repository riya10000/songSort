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

import java.util.ArrayList;

/**
 * @author Kara Probasco (karap17)
 * @author Alisa Khuu (alisak22)
 * @author Riya Dani (riyadn99)
 * @author Marcus Tran (Tmarcus)
 * 
 * @version 4/16/2019
 */
public class SongTest extends student.TestCase {

    private People person1;
    private People person2;
    private People person3;
    private People person4;
    private People person5;
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;


    /**
     * sets up for tests
     */
    public void setUp() {
        String[] stringAr = new String[8];
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

        String[] stringAr2 = new String[8];
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

        String[] stringAr3 = new String[8];
        stringAr3[0] = "";
        stringAr3[1] = "";
        stringAr3[2] = "No";
        stringAr3[3] = "No";
        stringAr3[4] = "";
        stringAr3[5] = "";
        stringAr3[6] = "No";
        stringAr3[7] = "No";

        person5 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OUTSIDE_US, stringAr3);

        ArrayList<People> peopleArList = new ArrayList<>();
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
        ArrayList<People> ar = new ArrayList<>();
        ar.add(person1);
        ar.add(person2);
        ar.add(person3);
        ar.add(person4);
        Song song5 = new Song("No More Dream", "BTS", 2013, "Hip-Hop", ar, 3);
        int[][] matrix1 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix1[i][j], song5.getLFeedback()[i][j]);
                assertEquals(matrix1[i][j], song5.getHFeedback()[i][j]);
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
        assertEquals(0, song.compareTitle(song));
    }


    /**
     * tests compareArtist
     */
    public void testcompareArtist() {
        assertTrue(song3.compareArtist(song) > 1);
        assertTrue(song.compareArtist(song3) < -1);
        assertEquals(0, song4.compareArtist(song2));
    }


    /**
     * tests compareGenre()
     */
    public void testcompareGenre() {
        assertTrue(song2.compareGenre(song) > 1);
        assertTrue(song.compareGenre(song3) < -1);
        assertEquals(0, song.compareGenre(song));
    }


    /**
     * test compareDate()
     */
    public void testCompareDate() {
        assertTrue(song.compareDate(song2) > 0);
        assertTrue(song4.compareDate(song) < 0);
        assertEquals(0, song2.compareDate(song3));
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

        ArrayList<People> ar = new ArrayList<>();
        ar.add(person5);
        Song song5 = new Song("No More Dream", "BTS", 2013, "Hip-Hop", ar, 3);
        int[][] matrix2 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix2[i][j] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix2[i][j], song5.heardPercent()[i][j]);
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

        ArrayList<People> ar = new ArrayList<>();
        ar.add(person5);
        Song song5 = new Song("No More Dream", "BTS", 2013, "Hip-Hop", ar, 3);
        int[][] matrix2 = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix2[i][j] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(matrix2[i][j], song5.likesPercent()[i][j]);
            }
        }
    }
}
