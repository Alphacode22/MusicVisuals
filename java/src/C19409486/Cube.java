package C19409486;

import java.util.Random;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Cube extends MusicObject {
    float _angle;

    public Cube(AlexVisual av, float angle) {
        this._av = av;
        this._angle = angle;
    }

    public void start(){
    
    }

    public void update(){
        moveCube();
    }

    public void moveCube(){
        int min =0;
        int randInt = randomiser(min, _av.height);
        int randInt2 = randomiser(min,  _av.width);
        float boxSize = 50 + (100 *  _av.getSmoothedAmplitude()); 

        _av.calculateAverageAmplitude();
        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        _av.strokeWeight(5);
        _av.noFill();

        _av.pushMatrix();
        _av.camera(); 
        _av.translate(randInt, randInt2, 50); 
        _av.rotateX(_angle);
        _av.rotateZ(_angle);  
        _av.box(boxSize);   
        _av.lights();
        _av.popMatrix();

        _angle += 0.01f;
    }
}

     