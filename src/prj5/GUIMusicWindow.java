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

    private GUIGlyph test;
    private GUILegend legend;

    private SongSorter sorter;

    private ArrayList<People> peopleArList;
    private People person1;
    private People person2;
    private People person3;
    private People person4;
    private People person5;
    private People person6;
    private People person7;
    private People person8;
    private String[] stringAr;
    private String[] stringAr2;
    private String[] stringAr3;
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;


    public GUIMusicWindow(SongSorter sorter) {
        this.sorter = sorter;
    }


    public GUIMusicWindow() {
        window = new Window();
        window.setSize(window.getGraphPanelWidth() * 4 / 3, window
            .getGraphPanelHeight() * 4 / 3);
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

        stringAr = new String[2];
        stringAr[0] = "Yes";
        stringAr[1] = "Yes";

        stringAr2 = new String[2];
        stringAr2[0] = "Yes";
        stringAr2[1] = "No";

        person1 = new People(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.NE_US,
            stringAr);
        person2 = new People(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.NE_US,
            stringAr2);

        person3 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OTHER_US, new String[] { "no", "Yes" });
        person4 = new People(HobbyEnum.SPORTS, MajorEnum.MATHCMDA,
            RegionEnum.OTHER_US, stringAr);

        person5 = new People(HobbyEnum.READ, MajorEnum.OTHER,
            RegionEnum.OUTSIDE_US, stringAr2);
        person6 = new People(HobbyEnum.READ, MajorEnum.OTHER,
            RegionEnum.OUTSIDE_US, stringAr);

        person7 = new People(HobbyEnum.MUSIC, MajorEnum.OTHERENG,
            RegionEnum.SE_US, stringAr);
        person8 = new People(HobbyEnum.MUSIC, MajorEnum.OTHERENG,
            RegionEnum.SE_US, stringAr2);

        peopleArList = new ArrayList<>();
        peopleArList.add(person1);
        peopleArList.add(person2);
        peopleArList.add(person3);
        peopleArList.add(person4);
        peopleArList.add(person5);
        peopleArList.add(person6);
        peopleArList.add(person7);
        peopleArList.add(person8);

        song = new Song("Boy With Luv", "BTS", 2019, "Pop", peopleArList, 0);

        test = new GUIGlyph(song, 1, 0);
        GUIGlyph test2 = new GUIGlyph(song, 1, 1);
        GUIGlyph test3 = new GUIGlyph(song, 1, 2);
        GUIGlyph test4 = new GUIGlyph(song, 1, 5);
        GUIGlyph test5 = new GUIGlyph(song, 1, 4);

        GUIGlyph test6 = new GUIGlyph(song, 1, 6);
        // Glyph test4 = new Glyph(song, 1, 5);
        test2.render(window);
        test3.render(window);
        // test4.render(window);
        test.render(window);
        test4.render(window);
        test5.render(window);
        test6.render(window);

        legend = new GUILegend(2, window);
        legend.render(window);

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
