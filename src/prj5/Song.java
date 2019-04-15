/**
 * 
 */
package prj5;

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
    private int[][] heardFeedback;
    private int[][] likeFeedback;
    private int songIndex;


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
        ArrayList<People> people,
        int index) {

        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.songIndex = index;

        this.heardOf = calculateHeardOf(people, index);
        this.likes = calculateLikes(people, index);
        this.heardFeedback = calculateHFeedback(people, index);
        this.likeFeedback = calculateLFeedback(people, index);
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
     * gets headOf
     * 
     * @return heardOf
     */
    public int[][] getHeardOf() {
        return heardOf;
    }


    /**
     * gets likes
     * 
     * @return likes
     */
    public int[][] getLikes() {
        return likes;
    }


    /**
     * gets heard feedback
     * 
     * @return heardFeedback
     */
    public int[][] getHFeedback() {
        return heardFeedback;
    }

    /**
     * gets like feedback
     * 
     * @return likeFeedback
     */
    public int[][] getLFeedback() {
        return likeFeedback;
    }

    /**
     * gets index of song
     * 
     * @return song index
     */
    public int getSongIndex() {
        return songIndex;
    }


    /**
     * returns matrix of percentage of heard
     * 
     * @return matrix of heard
     */
    public int[][] heardPercent() {
        int[][] tempMatrix = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (heardFeedback[i][j] == 0) {
                    tempMatrix[i][j] = 0;
                }
                else {
                    tempMatrix[i][j] = heardOf[i][j] * 100
                        / heardFeedback[i][j];
                }
            }
        }
        return tempMatrix;
    }


    /**
     * returns a matrix of the percentage of likes
     * 
     * @return int matrix
     */
    public int[][] likesPercent() {
        int[][] tempMatrix = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (likeFeedback[i][j] == 0) {
                    tempMatrix[i][j] = 0;
                }
                else {
                    tempMatrix[i][j] = likes[i][j] * 100 / likeFeedback[i][j];
                }
            }
        }
        return tempMatrix;
    }


    /**
     * calculates the total feedback for the people
     * 
     * @param people
     *            person ArrayList
     * @param index
     *            index of song
     */
    public int[][] calculateHFeedback(ArrayList<People> people, int index) {
        int[][] tempMatrix = new int[3][4];

        for (int i = 0; i < people.size(); i++) {
            if (!people.get(i).getFeedback()[index].equals("")) {
                if (people.get(i).getHobby() == HobbyEnum.READ) {
                    tempMatrix[0][0] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.ART) {
                    tempMatrix[0][1] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.SPORTS) {
                    tempMatrix[0][2] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.MUSIC) {
                    tempMatrix[0][3] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.COMPSCI) {
                    tempMatrix[1][0] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHERENG) {
                    tempMatrix[1][1] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.MATHCMDA) {
                    tempMatrix[1][2] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHER) {
                    tempMatrix[1][3] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.NE_US) {
                    tempMatrix[2][0] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.SE_US) {
                    tempMatrix[2][1] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OTHER_US) {
                    tempMatrix[2][2] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OUTSIDE_US) {
                    tempMatrix[2][3] += 1;
                }
            }
        }
        return tempMatrix;
    }
    
    /**
     * calculates the total feedback for the people
     * 
     * @param people
     *            person ArrayList
     * @param index
     *            index of song
     */
    public int[][] calculateLFeedback(ArrayList<People> people, int index) {
        int[][] tempMatrix = new int[3][4];

        for (int i = 0; i < people.size(); i++) {
            if (!people.get(i).getFeedback()[index + 1].equals("")) {
                if (people.get(i).getHobby() == HobbyEnum.READ) {
                    tempMatrix[0][0] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.ART) {
                    tempMatrix[0][1] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.SPORTS) {
                    tempMatrix[0][2] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.MUSIC) {
                    tempMatrix[0][3] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.COMPSCI) {
                    tempMatrix[1][0] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHERENG) {
                    tempMatrix[1][1] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.MATHCMDA) {
                    tempMatrix[1][2] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHER) {
                    tempMatrix[1][3] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.NE_US) {
                    tempMatrix[2][0] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.SE_US) {
                    tempMatrix[2][1] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OTHER_US) {
                    tempMatrix[2][2] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OUTSIDE_US) {
                    tempMatrix[2][3] += 1;
                }
            }
        }
        return tempMatrix;
    }


    /**
     * calculates matrix of heard of responses for each characteristic of people
     * 
     * @param people
     *            ArrayList of people
     * @param index
     *            index of song
     * @return array of values of people that have heard of song based on
     *         hobbies
     */
    private int[][] calculateHeardOf(ArrayList<People> people, int index) {
        int[][] tempMatrix = new int[3][4];

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getFeedback()[index].equals("Yes")) {
                if (people.get(i).getHobby() == HobbyEnum.READ) {
                    tempMatrix[0][0] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.ART) {
                    tempMatrix[0][1] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.SPORTS) {
                    tempMatrix[0][2] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.MUSIC) {
                    tempMatrix[0][3] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.COMPSCI) {
                    tempMatrix[1][0] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHERENG) {
                    tempMatrix[1][1] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.MATHCMDA) {
                    tempMatrix[1][2] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHER) {
                    tempMatrix[1][3] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.NE_US) {
                    tempMatrix[2][0] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.SE_US) {
                    tempMatrix[2][1] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OTHER_US) {
                    tempMatrix[2][2] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OUTSIDE_US) {
                    tempMatrix[2][3] += 1;
                }
            }
        }
        return tempMatrix;
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

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getFeedback()[index + 1].equals("Yes")) {
                if (people.get(i).getHobby() == HobbyEnum.READ) {
                    tempMatrix[0][0] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.ART) {
                    tempMatrix[0][1] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.SPORTS) {
                    tempMatrix[0][2] += 1;
                }
                if (people.get(i).getHobby() == HobbyEnum.MUSIC) {
                    tempMatrix[0][3] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.COMPSCI) {
                    tempMatrix[1][0] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHERENG) {
                    tempMatrix[1][1] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.MATHCMDA) {
                    tempMatrix[1][2] += 1;
                }
                if (people.get(i).getMajor() == MajorEnum.OTHER) {
                    tempMatrix[1][3] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.NE_US) {
                    tempMatrix[2][0] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.SE_US) {
                    tempMatrix[2][1] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OTHER_US) {
                    tempMatrix[2][2] += 1;
                }
                if (people.get(i).getRegion() == RegionEnum.OUTSIDE_US) {
                    tempMatrix[2][3] += 1;
                }
            }
        }

        return tempMatrix;
    }


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
        return this.getArtist().compareToIgnoreCase(song.getArtist());
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
        return this.year - song.year;
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


    /**
     * toString method
     * 
     * @return string of song
     *         "Title by Artist, Year, Genre"
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(this.getTitle() + " by " + this.getArtist());
        string.append(", " + this.getYear() + ", " + this.getGenre());

        return string.toString();
    }
}
