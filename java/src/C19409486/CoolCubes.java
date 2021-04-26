package C19409486;

import processing.core.PApplet;

public class CoolCubes extends Cube{
    float _angle;

    public CoolCubes(AlexVisual av) {
        super(av, 10);
        this._av = av;
    }

    public void start(){
    
    }

    public void update(){
        moveCube();
    }

    public void moveCube(){
        float boxSize = 50 + (100 *  _av.getSmoothedAmplitude()); 
        _av.translate(_av.height, _av.width, 0);
        _av.calculateAverageAmplitude();
        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
       // _av.strokeWeight(5);

        _av.pushMatrix();
        _av.camera(); 
        for(int x = _av.width; x >= _av.height / 2; x -= 100){
            for(int y = _av.width; y >= _av.width / 2; y-=100){
                for(int z= 0; z >= 0; z-= 10){
                    _av.pushMatrix();
                    _av.translate(x, y, z); 
                    randomBoxes();
                    _av.popMatrix();
                }
            }
        }
     
        // _av.rotateX(_angle);
        // _av.rotateZ(_angle);  
        // _av.box(boxSize);   
        _av.lights();
        _av.popMatrix();

        _angle += 0.01f;
    }

    void randomBoxes(){
        _av.fill(_av.random(255));
        _av.box(_av.random(20));
    }
}
