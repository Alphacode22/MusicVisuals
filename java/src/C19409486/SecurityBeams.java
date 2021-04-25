package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class SecurityBeams extends MusicObject{

    float _px;
    float _py;

    public SecurityBeams(AlexVisual av){
        this._av = av;
        _x = _av.random(-_av.width, _av.width);
        _y = _av.random(-_av.height, _av.height);
        _z = -10;
    }

    public void start(){

        float sx = PApplet.map(_x/_z, 0, 1, 0, _av.width);
        float sy = PApplet.map(_y/_z, 0, 1, 0, _av.height);


        _av.strokeWeight(2);
     

        _av.stroke(120, 100, 55);
        _av.fill(120, 100, 55);
        _av.line(_px, _py, sx, sy);

        _px = sx;
        _py = sy;
    }

    public void update(){
        drawSecurityBeams();
    }

    void drawSecurityBeams(){
        _z = _z -10;
        if(_z < 1){
            _z = _av.width;
            _x = _av.random(-_av.width, _av.width);
            _y = _av.random(-_av.height, _av.height);
        }
    }  
}