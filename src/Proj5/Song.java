/**
 * 
 */
package Proj5;

import java.util.ArrayList;

/**
 * @author proba
 *
 */
public class Song {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private int[][] heardOf;
    private int[][] likes;
    private int totalFeedback;
    private int songIndex;
    // public subject; ???
    // public String[] feedback; ???


    /**
     * Constructor for song class
     * 
     * @param title
     *            title of song
     * @param artist
     *            artist of song
     * @param year
     *            year of song
     * @param genre
     *            genre of song
     * @param people
     *            ArrayList of people
     * @param index
     *            index of song
     */
    public Song(
        String title,
        String artist,
        int year,
        String genre,
        int totalFeedback,
        ArrayList<People> people,
        int index) {

        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.songIndex = index;

        this.heardOf = calculateHeardOf(people, index);
        this.likes = calculateLikes(people, index);
        this.totalFeedback = calculateFeedback(people, index);
    }


    /**
     * gets song title
     * 
     * @return song title
     */
    public String getTitle() {
        return title;
    }


    /**
     * gets artist
     * 
     * @return artist of song
     */
    public String getArtist() {
        return artist;
    }


    /**
     * gets year
     * 
     * @return year of song
     */
    public int getYear() {
        return year;
    }


    /**
     * gets genre of song
     * 
     * @return genre of song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * calculates the total feedback for the people
     * 
     * @param people
     *            person ArrayList
     * @param index
     *            index of song
     */
    public int calculateFeedback(ArrayList<People> people, int index) {
        int feedbackInt = 0;

        for (int i = 0; i < people.size(); i++) {
            if (!people.get(i).getFeedback()[index].equals("")) {
                feedbackInt += 1;
            }
        }

        return feedbackInt;
    }


    /**
     * calculates matrix of heard of responses for each characteristic of people
     * 
     * @param people
     *            ArrayList of people
     * @param index
     *            index of song
     * @return array of values of people that have heard of song based on hobbies
     */
    private int[][] calculateHeardOf(ArrayList<People> people, int index) {
        int[][] tempMatrix = new int[3][4];
        
        for(int i = 0; i < people.size(); i++) {
            if (people.get(i).getHobby() == HobbyEnum.READ && people.get(i).getFeedback()[index].equals("yes")) {
                tempMatrix[0][0] += 1;
            }
            if (people.get(i).getHobby() == HobbyEnum.ART && people.get(i).getFeedback()[index].equals("yes")) {
                tempMatrix[0][0] += 1;
            }
        }
    }


    /**
     * calculates matrix of like responses for each characteristic of people
     * 
     * @param people
     *            ArrayList of people
     * @param index
     *            index of song
     * @return matrix of people that like the song
     */
    private int[][] calculateLikes(ArrayList<People> people, int index) {
        int[][] tempMatrix = new int[3][4];
        
        for(int i = 0; i < people.size(); i++) {
            if (people.get(i).getHobby() == HobbyEnum.READ && people.get(i).getFeedback()[index + 1] != "") {
                tempMatrix[0][0] += 1;
            }
        }
    }


    // public int compareTo(Object)

    /**
     * Compares this song to other song based on artist
     * 
     * @param song
     *            other song
     * @return 0 if the two artists are alphabetically equivalent, negative
     *         value
     *         if this is after other song, positive if this is before other
     */
    public int compareArtist(Song song) {
        return this.getArtist().toLowerCase().compareTo(song.getArtist()
            .toLowerCase());
    }


    /**
     * Compares this song to other song based on year
     * 
     * @param song
     *            other song
     * @return 0 if the years are equivalent, -1 if this is less than other son,
     *         1 if this is greater than other song
     */
    public int compareDate(Song song) {
        if (this.getYear() > song.getYear()) {
            return 1;
        }
        else if (this.getYear() == song.getYear()) {
            return 0;
        }
        else {
            return -1;
        }
    }


    /**
     * Compares this song to other song based on title
     * 
     * @param song
     *            other song
     * @return 0 if the two titles are alphabetically equivalent, negative value
     *         if this is after other song, positive if this is before other
     */
    public int compareTitle(Song song) {
        return this.getTitle().compareTo(song.getTitle());
    }


    /**
     * Compares this song to other song based on genre (capitalization matters)
     * 
     * @param song
     *            other song
     * @return 0 if the two genres are alphabetically equivalent, negative value
     *         if this is after other song, positive if this is before other
     */
    public int compareGenre(Song song) {
        return this.getGenre().compareTo(song.getGenre());
    }
}
