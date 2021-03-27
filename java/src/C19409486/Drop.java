package C19409486;

import processing.core.PApplet;
import C19409486.AlexVisual;
import ie.tudublin.Main;

public class Drop  {

    AlexVisual av = Main.myUI();

    float x = av.random(av.width);
    float y = av.random(-500, -50);
    float z = av.random(0, 20);
    float len = PApplet.map(z, 0, 20, 10, 20);
    float yspeed = PApplet.map(z, 0, 20, 10, 20);

    void fall(){
        y = y +yspeed;
        float grav = PApplet.map(z, 0, 20, 0, (float) 0.2);
        yspeed = yspeed +grav;

        if(y > av.height){
            y = av.random(-200, -100);
            yspeed= PApplet.map(z, 0, 20, 4 ,10);
        }
    }

    void show(){
        float thick = PApplet.map(z, 0, 20 , 1, 3);
        av.stroke(138, 43, 226);
        av.line(x, y, x, y+10);
    }
}
