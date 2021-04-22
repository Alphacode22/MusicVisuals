package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class SecurityBeams extends MusicObject{
    float x;
    float y;
    float z;

    float px;
    float py;

  

    public SecurityBeams(AlexVisual av){
        this._av = av;
        x = _av.random(-_av.width, _av.width);
        y = _av.random(-_av.height, _av.height);
        z = _av.random(_av.width);
    }

    public void start(){
        // av.fill(120, 100, 55);
        // av.noStroke();

        float sx = PApplet.map(x/z, 0, 1, 0, _av.width);
        float sy = PApplet.map(y/z, 0, 1, 0, _av.height);

        // float r = PApplet.map(z, 0, av.width, 16, 0);
        // av.ellipse(sx, sy, r, r);

        //av.stroke(255);

        _av.strokeWeight(2);
        //_av.strokeCap(PApplet.PROJECT);

        _av.stroke(120, 100, 55);
        _av.fill(120, 100, 55);
        _av.line(px, py, sx, sy);

        px = sx;
        py = sy;
    }

    public void update(){
        drawSecurityBeams();
    }

    void drawSecurityBeams(){
        z = z -10;
        if(z < 1){
            z = _av.width;
            x = _av.random(-_av.width, _av.width);
            y = _av.random(-_av.height, _av.height);
        }
    }

    
}//8.01