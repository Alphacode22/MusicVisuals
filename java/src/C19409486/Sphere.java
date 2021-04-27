package C19409486;

import processing.core.PApplet;

public class Sphere extends MusicObject{
    //AlexVisual _av;
    float _x;
    float _y;
    float _z;
    private float _gravity=-1;
    private float _ySpeed=1;

    public Sphere(AlexVisual av, float y, float z, float gravity) {
        this._av = av;
        this._x =randomiser(0, _av.width);
        this._y = y;
        this._z = z;
        this._gravity = gravity;
       
        //TODO Auto-generated constructor stub 
    }

    public void start(){
        _av.translate(_av.getCx(),_av.getCy(), _z);
    }
   
    public void update(){
        drawSpheres();
    }

    void drawSpheres(){
  
        if(_y > _av.height || _y <0){
            _ySpeed *=  -1;
        }else{
            _ySpeed += _gravity;
        }

        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        _av.strokeWeight(5); 
        _av.noFill();

        _av.pushMatrix();
        _av.camera(); 
        _av.translate((_av.width /2) + 10,_y, _z);
        _av.sphere(50);
        _av.lights();
        _av.popMatrix();

        _y += _ySpeed; 
    }
}
