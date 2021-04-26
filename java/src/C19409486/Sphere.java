package C19409486;

import processing.core.PApplet;

public class Sphere extends MusicObject{
    //AlexVisual _av;
    float _x;
    float _y;
    float _z;
    private float gravity=-1;
    private float ySpeed=1;

    public Sphere(AlexVisual av) {
        this._av = av;
        this._x =randomiser(0, _av.width);
        this._y = _av.getCy();
        this._z = 0;
        this.gravity = 1;
       
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
            ySpeed *=  -1;
        }else{
            ySpeed += gravity;
           // System.out.println(ySpeed);
        }

        // _av.stroke(100, 255, 255);
        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        _av.strokeWeight(5); 
        //_av.noStroke();
        _av.noFill();
        //_av.fill(255, 255, 255);

        _av.pushMatrix();
        _av.camera(); 
        _av.translate(randomiser(0, _av.width),_y, _z);
        _av.sphere(50);
        _av.lights();
        _av.popMatrix();

        _y += ySpeed; 
    }
}
