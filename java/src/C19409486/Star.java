package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Star extends MusicObject{
    float x;
    float y;
    float z;

    float pz;


    Star(AlexVisual av){
        this._av = av;
        x = _av.random(-_av.width, _av.width);
        y = _av.random(-_av.height, _av.height);
        z = _av.random(_av.width);
        pz = z;
    }

    public void start(){
        _av.fill(255);
        _av.noStroke();

        float sx = PApplet.map(x/z, 0, 1, 0, _av.width);
        float sy = PApplet.map(y/z, 0, 1, 0, _av.height);

        float r = PApplet.map(z, 0, _av.width, 16, 0);
        _av.ellipse(sx, sy, r, r);

        float px = PApplet.map(x/pz, 0, 1, 0, _av.height);
        float py = PApplet.map(y/pz, 0, 1, 0, _av.height);

        _av.stroke(255);
        _av.line(px, py, sx, sy);

      
    }

    public void update(){
        z = z -10;
        if(z < 1){
            z = _av.width;
            x = _av.random(-_av.width, _av.width);
            y = _av.random(-_av.height, _av.height);
            pz = z;
        }
    }
}
