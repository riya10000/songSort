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
import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Responsible for graphical representation of data
 * creates windows and renders buttons and graphics
 * 
 * @author Alisa Khuu alisak22
 * @author Kara Probasco karap17
 * @author Riya Dani riyadn99
 * @author Marcus Tran Tmarcus
 * 
 * @version 04/16/2019
 *
 */
public class GUIMusicWindow {

    /**
     * private variables that are added to window
     */
    private Window window;
    private Button sortByArtistName;
    private Button sortBySongTitle;
    private Button sortByReleaseYear;
    private Button sortByGenre;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button quit;
    private Button previous;
    private Button next;

    private GUIGlyph[] glyphs;
    private GUILegend legend;

    private SongSorter<Song> sorter;
    private int index;


    /**
     * Constructor for GUIMusicWindow
     * 
     * @param sorter
     */
    public GUIMusicWindow(SongSorter<Song> sorter) {
        this.sorter = sorter;
        window = new Window();
        window.setSize(window.getGraphPanelWidth() * 3 / 2, window
            .getGraphPanelHeight() * 7 / 4);
        glyphs = new GUIGlyph[9];

        window.setSize(window.getGraphPanelWidth() * 4 / 3, window
            .getGraphPanelHeight() * 4 / 3);
        sortByArtistName = new Button("Sort by Artist");
        sortBySongTitle = new Button("Sort by Song Title");
        sortByReleaseYear = new Button("Sort by Release Date");
        sortByGenre = new Button("Sort by Genre");
        representHobby = new Button("Hobby");
        representMajor = new Button("Major");
        representRegion = new Button("Region");
        quit = new Button("Quit");
        previous = new Button("Previous");
        next = new Button("Next");

        sortByArtistName.onClick(this, "clickedSortByArtistName");
        sortBySongTitle.onClick(this, "clickedSortBySongTitle");
        sortByReleaseYear.onClick(this, "clickedSortByReleaseYear");
        sortByGenre.onClick(this, "clickedSortByGenre");
        representHobby.onClick(this, "clickedRepresentHobby");
        representMajor.onClick(this, "clickedRepresentMajor");
        representRegion.onClick(this, "clickedRepresentRegion");
        quit.onClick(this, "clickedQuit");
        previous.onClick(this, "clickedPrevious");
        next.onClick(this, "clickedNext");

        window.addButton(sortByArtistName, WindowSide.NORTH);
        window.addButton(sortBySongTitle, WindowSide.NORTH);
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        window.addButton(sortByGenre, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);

        window.addButton(previous, WindowSide.SOUTH);
        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(next, WindowSide.SOUTH);

        for (int i = 0; i < 3; i++) {
            if (index + i >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i] = new GUIGlyph(sorter.getSongList().get(i), 0, i);
            glyphs[i].render(window);

        }
        for (int i = 4; i <= 6; i++) {
            if (index + i - 1 >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i - 1] = new GUIGlyph(sorter.getSongList().get(i - 1), 0, i);
            glyphs[i - 1].render(window);
        }
        for (int i = 8; i <= 10; i++) {
            if (index + i - 2 >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i - 2] = new GUIGlyph(sorter.getSongList().get(i - 2), 0, i);
            glyphs[i - 2].render(window);
        }

        legend = new GUILegend(0, window);
        legend.render(window);
    }


    /**
     * button function to sort by artist
     * 
     * @param sortByArtistName
     *            button clicked to initialize sort
     */
    public void clickedSortByArtistName(Button sortByArtistName) {
        index = 0;
        sorter.insertionSort(1);
        for (int i = 0; i < 9; i++) {
            glyphs[i].setSong((Song)sorter.getSongList().get(i));
            glyphs[i].render(window);
        }

    }


    /**
     * function to sort by title
     * 
     * @param sortBySongTitle
     *            button pushed
     */
    public void clickedSortBySongTitle(Button sortBySongTitle) {
        index = 0;
        sorter.insertionSort(3);
        for (int i = 0; i < 9; i++) {
            glyphs[i].setSong((Song)sorter.getSongList().get(i));
            glyphs[i].render(window);
        }
    }


    /**
     * function to sort by date
     * 
     * @param sortByReleaseTitle
     *            button pushed
     */
    public void clickedSortByReleaseYear(Button sortByReleaseTitle) {
        index = 0;
        sorter.insertionSort(2);
        for (int i = 0; i < 9; i++) {
            glyphs[i].setSong((Song)sorter.getSongList().get(i));
            glyphs[i].render(window);
        }
    }


    /**
     * function to sort by genre
     * 
     * @param sortByGenre
     *            button pushed
     */
    public void clickedSortByGenre(Button sortByGenre) {
        index = 0;
        sorter.insertionSort(4);
        for (int i = 0; i < 9; i++) {
            glyphs[i].setSong((Song)sorter.getSongList().get(i));
            glyphs[i].render(window);
        }
    }


    /**
     * function to represent data by hobby
     * 
     * @param representHobby
     *            button pushed
     */
    public void clickedRepresentHobby(Button representHobby) {
        for (int i = 0; i < 9; i++) {
            glyphs[i].remove(window);
        }
        for (int i = 0; i < 9; i++) {
            if (index + i >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i].setSort(0);
            glyphs[i].render(window);
        }
        legend.setLegend(0);
        legend.render(window);
    }


    /**
     * function to represent data by major
     * 
     * @param representMajor
     *            button pushed
     */
    public void clickedRepresentMajor(Button representMajor) {
        for (int i = 0; i < 9; i++) {
            glyphs[i].remove(window);
        }
        for (int i = 0; i < 9; i++) {
            if (index + i >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i].setSort(1);
            glyphs[i].render(window);
        }
        legend.setLegend(1);
        legend.render(window);
    }


    /**
     * function to represent data by region
     * 
     * @param representRegion
     *            button pushed
     */
    public void clickedRepresentRegion(Button representRegion) {

        for (int i = 0; i < 9; i++) {
            glyphs[i].remove(window);
        }
        for (int i = 0; i < 9; i++) {
            if (index + i >= sorter.getSongList().size()) {
                break;
            }
            glyphs[i].setSort(2);
            glyphs[i].render(window);
        }

        legend.setLegend(2);
        legend.render(window);
    }


    /**
     * function to quit screen
     * 
     * @param quit
     *            button pushed
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }


    /**
     * function to page to previous screen
     * 
     * @param previous
     *            button pushed
     */
    public void clickedPrevious(Button previous) {
        if (index > 8) {
            index = index - 9;
            for (int i = 0; i < 9; i++) {
                glyphs[i].setSong((Song)sorter.getSongList().get(index + i));
                glyphs[i].render(window);
            }
        }

    }


    /**
     * function to page to next screen
     * 
     * @param next
     *            button pushed
     */
    public void clickedNext(Button next) {
        if (index + 9 < sorter.getSongList().size()) {
            for (int i = 0; i < 9; i++) {
                glyphs[i].remove(window);
            }
            index = index + 9;
            for (int i = 0; i < 9; i++) {
                if (index + i >= sorter.getSongList().size()) {
                    break;
                }
                glyphs[i].setSong((Song)sorter.getSongList().get(index + i));
                glyphs[i].render(window);
            }
        }
    }

}
