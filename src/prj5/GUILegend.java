package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class GUILegend {
    private int num;
    private Window window;

    private TextShape legend;
    private TextShape permSong;
    private TextShape permHeard;
    private TextShape permLikes;

    private Shape bar;

    private TextShape word1;
    private TextShape word2;
    private TextShape word3;
    private TextShape word4;

    private int windowWidth;
    private int windowHeight;
    private int width;
    private int height;

    private Color one;
    private Color two;
    private Color three;
    private Color four;


    public GUILegend(int num, Window window) {
        one = new Color(255, 80, 80);
        two = new Color(0, 153, 255);
        three = new Color(77, 255, 195);
        four = new Color(255, 195, 77);

        width = window.getGraphPanelWidth() / 5;
        height = window.getGraphPanelHeight() / 3;
        windowWidth = window.getGraphPanelWidth();
        windowHeight = window.getGraphPanelHeight();
        
        this.num = num;

        legend = new TextShape(windowWidth - width*3/4, height, "");
        legend.setBackgroundColor(Color.WHITE);
        permSong = new TextShape(windowWidth - width*3/5, height + height/6, "Song Title");
        permSong.setBackgroundColor(Color.WHITE);
        bar = new Shape(windowWidth - width*2/5,
                        height + height/3, 
                        width/20, height/2, 
                        Color.BLACK );
        permHeard = new TextShape(windowWidth - width*3/4, height+ height/2, "Heard");
        permLikes = new TextShape(windowWidth - width/4 - width/20, height+ height/2, "Likes");
        
        permHeard.setBackgroundColor(Color.WHITE);
        permLikes.setBackgroundColor(Color.WHITE);
    
        word1 = new TextShape(windowWidth - width/2, height*2,"", one);
        word2 = new TextShape(windowWidth - width/2, height*2 + height/9,"", two);
        word3 = new TextShape(windowWidth - width/2, height*2+ height*2/9,"", three);
        word4 = new TextShape(windowWidth - width/2, height*2 + height*3/9,"", four);
        
        
        word1.setBackgroundColor(Color.WHITE);
        word2.setBackgroundColor(Color.WHITE);
        word3.setBackgroundColor(Color.WHITE);
        word4.setBackgroundColor(Color.WHITE);
        
        window.addShape(permSong);
        window.addShape(bar);
        window.addShape(permHeard);
        window.addShape(permLikes);
        
        
    }


    public void setLegend(int num) {
        this.num = num;
    }


    private void setText() {
        if (num == 1) {
            legend.setText("Hobby Legend");
            word1.setText("Read");
            word2.setText("Art");
            word3.setText("Sports");
            word4.setText("Music");
        }
        else if (num == 2) {
            legend.setText("Major Legend");
            word1.setText("Comp Sci");
            word2.setText("Other Eng");
            word3.setText("Math/CMDA");
            word4.setText("Other");
        }
        else if (num == 3) {
            legend.setText("Region Legend");
            word1.setText("Northeast US");
            word2.setText("Souteast US");
            word3.setText("Other US");
            word4.setText("Outside Us");
        }
    }
    
    private void remove(Window window) {
        window.removeShape(legend);
        window.removeShape(word1);
        window.removeShape(word2);
        window.removeShape(word3);
        window.removeShape(word4);
    }
    
    private void add(Window window) {
        window.addShape(legend);
        window.addShape(word1);
        window.addShape(word2);
        window.addShape(word3);
        window.addShape(word4);
    }
    
    public void render(Window window) {
        remove(window);
        setText();
        add(window);
    }

}
