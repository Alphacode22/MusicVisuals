package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class StationaryStar {
    float x;
    float y;
    float z;

    AlexVisual av = Main.av;

    StationaryStar(){
        x = av.random(-av.width, av.width);
        y = av.random(-av.height, av.height);
        z = av.random(av.width);
    }

    void update(){
        z = z -1;
        if(z < 1){
            z = av.width;
            x = av.random(-av.width, av.width);
            y = av.random(-av.height, av.height);
        }
    }

    void show(){
        av.fill(255);
        av.noStroke();

        float sx = PApplet.map(x/z, 0, 1, 0, av.width);
        float sy = PApplet.map(y/z, 0, 1, 0, av.height);

        av.ellipse(sx, sy, 8, 8);
    }

}
