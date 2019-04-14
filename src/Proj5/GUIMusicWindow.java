package Proj5;

import java.util.ArrayList;
import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIMusicWindow {
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


    public GUIMusicWindow(LList<Song> songs, ArrayList<People> people) {

    }


    public GUIMusicWindow() {
        window = new Window();
        Button sortByArtistName = new Button("Sort by Artist");
        Button sortBySongTitle = new Button("Sort by Song Title");
        Button sortByReleaseYear = new Button("Sort by Release Date");
        Button sortByGenre = new Button("Sort by Genre");
        Button representHobby = new Button("Hobby");
        Button representMajor = new Button("Major");
        Button representRegion = new Button("Region");
        Button quit = new Button("Quit");
        Button previous = new Button("previous");
        Button next = new Button("next");

        sortByArtistName.onClick(this, "ClickedSortByArtistName");
        sortBySongTitle.onClick(this, "ClickedSortBySongTitle");
        sortByReleaseYear.onClick(this, "ClickedSortByReleaseYear");
        sortByGenre.onClick(this, "ClickedSortByGenre");
        representHobby.onClick(this, "ClickedRepresentHobby");
        representMajor.onClick(this, "ClickedRepresentMajor");
        representRegion.onClick(this, "ClickedRepresentRegion");
        quit.onClick(this, "ClickedQuit");
        previous.onClick(this, "ClickedPrevious");
        next.onClick(this, "ClickedNext");

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

    }


    public void clickedSortByArtistName(Button sortByArtistName) {

    }


    public void clickedSortBySongTitle(Button sortBySongTitle) {

    }


    public void clickedSortByReleaseTitle(Button sortByReleaseTitle) {

    }


    public void clickedSortByGenre(Button sortByGenre) {

    }


    public void clickedSortByNext(Button sortByNext) {

    }


    public void clickedRepresentHobby(Button representHobby) {

    }


    public void clickedRepresentMajor(Button representMajor) {

    }


    public void clickedRepresentRegion(Button representRegion) {

    }


    public void clickedQuit(Button quit) {

        System.exit(0);

    }


    public void clickedPrevious(Button previous) {

    }


    public void clickedNext(Button next) {

    }


    public void redraw() {

    }

}
