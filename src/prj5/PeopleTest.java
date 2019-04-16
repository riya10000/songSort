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
public class PeopleTest extends student.TestCase {

    private People person1;
    private People person2;
    private String[] stringAr;
    private String[] stringAr2;


    /**
     * sets up
     */
    public void setUp() {
        stringAr = new String[4];
        stringAr[0] = "yes";
        stringAr[1] = "no";
        stringAr[2] = "no";
        stringAr[3] = "no";
        person1 = new People(HobbyEnum.ART, MajorEnum.COMPSCI,
            RegionEnum.OTHER_US, stringAr);

        stringAr2 = new String[4];
        stringAr[0] = "no";
        stringAr[1] = "no";
        stringAr[2] = "yes";
        stringAr[3] = "no";
        person2 = new People(HobbyEnum.READ, MajorEnum.OTHERENG,
            RegionEnum.SE_US, stringAr2);
    }


    /**
     * tests getHobby()
     */
    public void testgetHobby() {
        assertEquals(HobbyEnum.ART, person1.getHobby());
        assertEquals(HobbyEnum.READ, person2.getHobby());
    }


    /**
     * tests getMajor()
     */
    public void testgetMajor() {
        assertEquals(MajorEnum.COMPSCI, person1.getMajor());
        assertEquals(MajorEnum.OTHERENG, person2.getMajor());
    }


    /**
     * tests getRegion()
     */
    public void testgetRegion() {
        assertEquals(RegionEnum.OTHER_US, person1.getRegion());
        assertEquals(RegionEnum.SE_US, person2.getRegion());
    }


    /**
     * tests getFeedback()
     */
    public void testgetFeedback() {
        assertEquals(stringAr, person1.getFeedback());
        assertEquals(stringAr2, person2.getFeedback());
    }
}
