package C19409486;

import processing.core.PApplet;
import ie.tudublin.Main;

public class Drop  {

    //temporary variable
    AlexVisual av = Main.av;

    float x = av.random(av.width);
    float y = av.random(-500, -50);
    float z = av.random(0, 20);
    float len = PApplet.map(z, 0, 20, 10, 20);
    float yspeed = PApplet.map(z, 0, 20, 10, 20);

    void start(){
        float thick = PApplet.map(z, 0, 20 , 1, 3);
        av.strokeWeight(thick);
        //av.stroke(138, 43, 226);
        av.stroke(240, 100, 100);
        av.line(x, y, x, y+len); 
    }

    void update(){
        y = y +yspeed;
        float grav = PApplet.map(z, 0, 20, 0, (float) 0.2);
        yspeed = yspeed +grav;

        if(y > av.height){
            y = av.random(-200, -100);
            yspeed= PApplet.map(z, 0, 20, 4 ,10);
        }
    }
}
