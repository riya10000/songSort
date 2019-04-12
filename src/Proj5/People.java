/**
 * 
 */
package Proj5;

/**
 * @author proba
 *
 */
public class People {

    private Hobby hobby;
    private Major major;
    private Region region;
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
        Hobby hobbyInput,
        Major majorInput,
        Region regionInput,
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
    public Hobby getHobby() {
        return hobby;
    }


    /**
     * gets major
     * 
     * @return major
     */
    public Major getMajor() {
        return major;
    }


    /**
     * gets region
     * 
     * @return region
     */
    public Region getRegion() {
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
