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

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;


/**
 * class for physical representations of Glyphs
 * collection of shapes for song data representation
 * 
 * @author Alisa Khuu alisak22
 * @author Kara Probasco karap17
 * @author Riya Dani riyadn99
 * @author Marcus Tran Tmarcus
 * 
 * @version 04/16/2019
 *

 */
public class GUIGlyph {
    private Song song;
    private int sortBy;
    private int num;

    private Shape heard1;
    private Shape heard2;
    private Shape heard3;
    private Shape heard4;

    private Shape likes1;
    private Shape likes2;
    private Shape likes3;
    private Shape likes4;

    private Shape middle;

    private TextShape songText;
    private TextShape artistText;

    private int width;
    private int height;

    private int buffer;

    private Color one;
    private Color two;
    private Color three;
    private Color four;

    
    /**
     * Constructor for GUIGlyph class 
     * Initializes shapes and variables
     * 
     * @param song
     *          song that Glyph represents
     * @param sort
     *          int that designates the index for sort
     * @param num
     *         int that decides placement of glyph on screen
     */
    public GUIGlyph(Song song, int sort, int num) {
        this.song = song;
        this.sortBy = sort;
        this.num = num;
        width = 0;
        height = 0;

        heard1 = new Shape(0, 0, 0);
        heard2 = new Shape(0, 0, 0);
        heard3 = new Shape(0, 0, 0);
        heard4 = new Shape(0, 0, 0);

        likes1 = new Shape(0, 0, 0);
        likes2 = new Shape(0, 0, 0);
        likes3 = new Shape(0, 0, 0);
        likes4 = new Shape(0, 0, 0);

        middle = new Shape(0, 0, 0);

        songText = new TextShape(0, 0, "");
        artistText = new TextShape(0, 0, "");

        buffer = 0;

        heard1 = new Shape(0, 0, 0);
        heard2 = new Shape(0, 0, 0);
        heard3 = new Shape(0, 0, 0);
        heard4 = new Shape(0, 0, 0);

        likes1 = new Shape(0, 0, 0);
        likes2 = new Shape(0, 0, 0);
        likes3 = new Shape(0, 0, 0);
        likes4 = new Shape(0, 0, 0);

        middle = new Shape(0, 0, 0);

        songText = new TextShape(0, 0, "");

        one = new Color(255, 80, 80);
        two = new Color(0, 153, 255);
        three = new Color(77, 255, 195);
        four = new Color(255, 195, 77);

    }
    
    /**
     * sets GUIGlyph song variable
     * 
     * @param song
     *      new song to be set to
     */
    public void setSong(Song song) {
        this.song = song;
    }
    
    public void setSort(int sort) {
        this.sortBy = sort;
    }
    

    /**
     * helper method
     * calculates changes in bar length based off 
     * window size and song data
     */
    private void calculate() {
        int[][] heardPercent = song.heardPercent();
        int[][] likesPercent = song.likesPercent();
        
        middle = new Shape(width*3/4 + width*(num%4) + buffer*(num%4),
                            height*(num/4)*2 + height  , 
                            width/20, height, 
                            Color.BLACK );
        
        heard1 = new Shape(width*3/4 + width*(num%4) - heardPercent
                            [sortBy][0]*width/200 + buffer*(num%4),
                            height*(num/4)*2 + height, 
                            heardPercent[sortBy][0]*width/200, 
                            height/4, 
                            one);
        
        heard2 = new Shape(width*3/4 + width*(num%4) - heardPercent
                            [sortBy][1]*width/200  + buffer*(num%4),
                            height*(num/4)*2 + height + height/4, 
                            heardPercent[sortBy][1]*width/200, 
                            height/4, 
                            two);
        
        heard3 = new Shape(width*3/4 + width*(num%4) - heardPercent
                            [sortBy][2]*width/200  + buffer*(num%4),
                            height*(num/4)*2 + height + height/2, 
                            heardPercent[sortBy][2]*width/200, 
                            height/4, 
                            three);
        
        heard4 = new Shape(width*3/4 + width*(num%4) - heardPercent
                            [sortBy][3]*width/200  + buffer*(num%4), 
                            height*(num/4)*2 + height + height*3/4, 
                            heardPercent[sortBy][3]*width/200, 
                            height/4, 
                            four);
        
        likes1 = new Shape(width*3/4 + width*(num%4) + width/20 + buffer*(num%4),
                            height*(num/4)*2 + height, 
                            likesPercent[sortBy][0]*width/200, 
                            height/4, 
                            one);
        
        likes2 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4),
                            height*(num/4)*2 + height + height/4, 
                            likesPercent[sortBy][1]*width/200, 
                            height/4, 
                            two);
        
        likes3 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4), 
                            height*(num/4)*2 + height + height/2, 
                            likesPercent[sortBy][2]*width/200, 
                            height/4, 
                            three);
        
        likes4 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4),
                            height*(num/4)*2 + height + height*3/4, 
                            likesPercent[sortBy][3]*width/200, 
                            height/4, 
                            four);
        
        songText = new TextShape(width*1/3 + width*(num%4) + buffer*(num%4), 
                                height*(num/4)*2 + height - buffer/2, 
                                song.getTitle());

        songText.setBackgroundColor(Color.WHITE);
        
        artistText = new TextShape(width*1/3 + width*(num%4) + buffer*(num%4), 
            height*(num/4)*2 + height - buffer/4, 
            " by " + song.getArtist());

        artistText.setBackgroundColor(Color.WHITE);

    }

    /**
     * removes all objects from window
     * 
     * @param window
     *          window objects are removed from
     */
    public void remove(Window window) {
        window.removeShape(heard1);
        window.removeShape(heard2);
        window.removeShape(heard3);
        window.removeShape(heard4);
        window.removeShape(likes1);
        window.removeShape(likes2);
        window.removeShape(likes3);
        window.removeShape(likes4);
        window.removeShape(middle);
        window.removeShape(songText);
        window.removeShape(artistText);

    }

    /**
     * helper method
     * adds all shapes to window
     * 
     * @param window
     *          window shapes are added to
     */
    private void add(Window window) {
        window.addShape(middle);
        window.addShape(songText);
        window.addShape(artistText);
        window.addShape(heard1);
        window.addShape(heard2);
        window.addShape(heard3);
        window.addShape(heard4);
        window.addShape(likes1);
        window.addShape(likes2);
        window.addShape(likes3);
        window.addShape(likes4);

    }

    /**
     * renders GUIGlyph object
     * 
     * @param window
     *         window objects are rendered to
     */
    public void render(Window window) {
        width = window.getGraphPanelWidth() / 5;
        height = window.getGraphPanelHeight() / 7;
        buffer = window.getGraphPanelWidth() / 15;
        remove(window);
        calculate();
        add(window);

    }
}
