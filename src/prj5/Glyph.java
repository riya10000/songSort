package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class Glyph {
    private Song song;
    private int sortBy;
    private int num;
    private double[][] standin;

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

    private int width;
    private int height;
<<<<<<< HEAD

=======
    private int buffer;
    
>>>>>>> 5a9faa0b988a1a6f5f8e5878cce8f926a8d99e58
    private Color one;
    private Color two;
    private Color three;
    private Color four;


    public Glyph(Song song, int sort, int num) {
        this.song = song;
        this.sortBy = sort;
        this.num = num;
        width = 0;
        height = 0;
<<<<<<< HEAD

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

=======
        buffer = 0;
        
        
        
        heard1 = new Shape(0,0,0);
        heard2 = new Shape(0,0,0);
        heard3 = new Shape(0,0,0);
        heard4 = new Shape(0,0,0);
        
        likes1 = new Shape(0,0,0);
        likes2 = new Shape(0,0,0);
        likes3 = new Shape(0,0,0);
        likes4 = new Shape(0,0,0);
        
        middle = new Shape(0,0,0);
        
        songText = new TextShape(0,0,"");
        
>>>>>>> 5a9faa0b988a1a6f5f8e5878cce8f926a8d99e58
        one = new Color(255, 80, 80);
        two = new Color(0, 153, 255);
        three = new Color(77, 255, 195);
        four = new Color(255, 195, 77);

    }


    public Glyph(double[][] thing, int sort, int num) {
        // this.song = song;
        standin = thing;
        this.sortBy = sort;
        this.num = num;
        width = 0;
        height = 0;
<<<<<<< HEAD

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

=======
        buffer = 0;
        
        
        
        heard1 = new Shape(0,0,0);
        heard2 = new Shape(0,0,0);
        heard3 = new Shape(0,0,0);
        heard4 = new Shape(0,0,0);
        
        likes1 = new Shape(0,0,0);
        likes2 = new Shape(0,0,0);
        likes3 = new Shape(0,0,0);
        likes4 = new Shape(0,0,0);
        
        middle = new Shape(0,0,0);
        
        songText = new TextShape(0,0,"");
        
>>>>>>> 5a9faa0b988a1a6f5f8e5878cce8f926a8d99e58
        one = new Color(255, 80, 80);
        two = new Color(0, 153, 255);
        three = new Color(77, 255, 195);
        four = new Color(255, 195, 77);

    }


    private void calculate() {
<<<<<<< HEAD
        middle = new Shape(width * 3 / 4 + width * (num % 3), height, width
            / 20, height, Color.BLACK);

        heard1 = new Shape(width * 3 / 4 + width * (num % 3) - song
            .heardPercent()[sortBy][0] * width / 200, height * (num / 3)
                + height, song.heardPercent()[sortBy][0] * width / 200, height
                    / 4, one);
        heard2 = new Shape(width * 3 / 4 + width * (num % 3) - song
            .heardPercent()[sortBy][1] * width / 200, height * (num / 3)
                + height + height / 4, song.heardPercent()[sortBy][1] * width
                    / 200, height / 4, two);
        heard3 = new Shape(width * 3 / 4 + width * (num % 3) - song
            .heardPercent()[sortBy][2] * width / 200, height * (num / 3)
                + height + height / 2, song.heardPercent()[sortBy][2] * width
                    / 200, height / 4, three);
        heard4 = new Shape(width * 3 / 4 + width * (num % 3) - song
            .heardPercent()[sortBy][3] * width / 200, height * (num / 3)
                + height + height * 3 / 4, song.heardPercent()[sortBy][3]
                    * width / 200, height / 4, four);

        likes1 = new Shape(width * 3 / 4 + width * (num % 3) + width / 20,
            height * (num / 3) + height, song.likesPercent()[sortBy][0] * width
                / 200, height / 4, one);
        likes2 = new Shape(width * 3 / 4 + width * (num % 3) + width / 20,
            height * (num / 3) + height + height / 4, song
                .likesPercent()[sortBy][1] * width / 200, height / 4, two);
        likes3 = new Shape(width * 3 / 4 + width * (num % 3) + width / 20,
            height * (num / 3) + height + height / 2, song
                .likesPercent()[sortBy][2] * width / 200, height / 4, three);
        likes4 = new Shape(width * 3 / 4 + width * (num % 3) + width / 20,
            height * (num / 3) + height + height * 3 / 4, song
                .likesPercent()[sortBy][3] * width / 200, height / 4, four);

        // songText = new TextShape();
=======
        middle = new Shape(width*3/4 + width*(num%4) + buffer*(num%4), height*(num/4)*2 + height  , width/20, height, Color.BLACK );
        
        heard1 = new Shape(width*3/4 + width*(num%4) - song.heardPercent()[sortBy][0]*width/200 + buffer*(num%4),
                            height*(num/4)*2 + height, 
                            song.heardPercent()[sortBy][0]*width/200, 
                            height/4, 
                            one);
        
        heard2 = new Shape(width*3/4 + width*(num%4) - song.heardPercent()[sortBy][1]*width/200  + buffer*(num%4),
                            height*(num/4)*2 + height + height/4, 
                            song.heardPercent()[sortBy][1]*width/200, 
                            height/4, 
                            two);
        
        heard3 = new Shape(width*3/4 + width*(num%4) - song.heardPercent()[sortBy][2]*width/200  + buffer*(num%4),
                            height*(num/4)*2 + height + height/2, 
                            song.heardPercent()[sortBy][2]*width/200, 
                            height/4, 
                            three);
        
        heard4 = new Shape(width*3/4 + width*(num%4) - song.heardPercent()[sortBy][3]*width/200  + buffer*(num%4), 
                            height*(num/4)*2 + height + height*3/4, 
                            song.heardPercent()[sortBy][3]*width/200, 
                            height/4, 
                            four);
        
        
        
        
        likes1 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4),
                            height*(num/4)*2 + height, 
                            song.likesPercent()[sortBy][0]*width/200, 
                            height/4, 
                            one);
        
        likes2 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4),
                            height*(num/4)*2 + height + height/4, 
                            song.likesPercent()[sortBy][1]*width/200, 
                            height/4, 
                            two);
        
        likes3 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4), 
                            height*(num/4)*2 + height + height/2, 
                            song.likesPercent()[sortBy][2]*width/200, 
                            height/4, 
                            three);
        
        likes4 = new Shape(width*3/4 + width*(num%4) + width/20  + buffer*(num%4),
                            height*(num/4)*2 + height + height*3/4, 
                            song.likesPercent()[sortBy][3]*width/200, 
                            height/4, 
                            four);
        
        songText = new TextShape(width*1/4 + width*(num%4) + buffer*(num%4), height*(num/4)*2 + height - buffer, song.getTitle() + " by " + song.getArtist());
>>>>>>> 5a9faa0b988a1a6f5f8e5878cce8f926a8d99e58
    }


    private void remove(Window window) {
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

    }


    private void add(Window window) {
        window.addShape(middle);
        window.addShape(songText);
        window.addShape(heard1);
        window.addShape(heard2);
        window.addShape(heard3);
        window.addShape(heard4);
        window.addShape(likes1);
        window.addShape(likes2);
        window.addShape(likes3);
        window.addShape(likes4);

    }


    public void render(Window window) {
<<<<<<< HEAD
        width = window.getGraphPanelWidth() / 4;
        height = window.getGraphPanelHeight() / 5;
=======
        width = window.getGraphPanelWidth()/5;
        height = window.getGraphPanelHeight()/5;
        buffer = window.getGraphPanelWidth()/20;
>>>>>>> 5a9faa0b988a1a6f5f8e5878cce8f926a8d99e58
        remove(window);
        calculate();
        add(window);

    }
}