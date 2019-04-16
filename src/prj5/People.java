/**
 * 
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
public class People {

    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private String[] feedback;


    /**
     * Constructor for People class
     * 
     * @param hobbyInput
     *            hobby of person
     * @param majorInput
     *            major of person
     * @param regionInput
     *            region of person
     * @param feedbackInput
     *            string array of feedback
     */
    public People(
        HobbyEnum hobbyInput,
        MajorEnum majorInput,
        RegionEnum regionInput,
        String[] feedbackInput) {

        this.hobby = hobbyInput;
        this.major = majorInput;
        this.region = regionInput;

        this.feedback = feedbackInput;
    }


    /**
     * gets hobby
     * 
     * @return hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * gets major
     * 
     * @return major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * gets region
     * 
     * @return region
     */
    public RegionEnum getRegion() {
        return region;
    }


    /**
     * gets feedback
     * 
     * @return feedback
     */
    public String[] getFeedback() {
        return feedback;
    }
}
