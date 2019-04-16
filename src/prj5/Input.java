/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Riya Dani (riyadn99)
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author Kara Probasco (karap17)
 * @author Alisa Khuu (alisak22)
 * @author Riya Dani (riyadn99)
 * @author Marcus Tran (Tmarcus)
 * 
 * @version 4/16/2019
 */
public class Input {

    /**
     * constructor for input
     */
    public Input() {
        // left blank purposefully
    }


    /**
     * Main method to initialize program and send files to file reader
     * 
     * @param args
     *            file names as strings
     * @throws ParseException
     *             if files are not parsed correctly
     * @throws FileNotFoundException
     *             if files are not found
     */
    public static void main(String[] args)
        throws FileNotFoundException {
        if (args.length == 2) { 
            @SuppressWarnings("unused")
            FileReader files = new FileReader(args[0], args[1]);
        }
        else {
            @SuppressWarnings("unused")
            FileReader FileReader2 = new FileReader("MusicSurveyData2018.txt",
                "SongList.txt");
       }
       //GUIMusicWindow window = new GUIMusicWindow();

    }
}
