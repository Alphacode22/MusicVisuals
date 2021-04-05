package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Star {
    float x;
    float y;
    float z;

    float pz;

    AlexVisual av = Main.av;

    Star(){
        x = av.random(-av.width, av.width);
        y = av.random(-av.height, av.height);
        z = av.random(av.width);
        pz = z;
    }

    void update(){
        z = z -10;
        if(z < 1){
            z = av.width;
            x = av.random(-av.width, av.width);
            y = av.random(-av.height, av.height);
            pz = z;
        }
    }

    void show(){
        av.fill(255);
        av.noStroke();

        float sx = PApplet.map(x/z, 0, 1, 0, av.width);
        float sy = PApplet.map(y/z, 0, 1, 0, av.height);

        float r = PApplet.map(z, 0, av.width, 16, 0);
        av.ellipse(sx, sy, r, r);

        float px = PApplet.map(x/pz, 0, 1, 0, av.height);
        float py = PApplet.map(y/pz, 0, 1, 0, av.height);

        av.stroke(255);
        av.line(px, py, sx, sy);

      
    }

}//8.01