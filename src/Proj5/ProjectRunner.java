/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Riya Dani (riyadn99)
 */
package Proj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Add the class description here.
 *
 * @author Riya Dani riyadn99
 * @version 04/13/2019
 */
public class ProjectRunner {

    /**
     * 
     */
    public ProjectRunner() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException {
        if (args.length == 2) {
            @SuppressWarnings("unused")
            FileReader files = new FileReader(args[0], args[1]);
        }
        else {
            @SuppressWarnings("unused")
            FileReader FileReader2 = new FileReader("MusicSurveyData2018.txt",
                "SongList.txt");
        }

    }
}
