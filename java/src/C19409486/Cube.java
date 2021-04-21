package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Cube implements MusicObject {

    AlexVisual _av;
    float _angle;

    public Cube(AlexVisual av, float angle) {
        this._av = av;
        this._angle = angle;
    }

    public void start(){
        // _av.background(0);
        // _av.calculateAverageAmplitude();
        // _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // _av.strokeWeight(5);
        // _av.noFill();
        // _av.lights();
    }

    public void update(){
        moveCube();
    }

    public void moveCube(){
        //
        // _av.pushMatrix();
        // _av.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        // _av.translate(0, 0, -200);
        // _av.rotateX(_angle);
        // _av.rotateZ(_angle);       
        // float boxSize = 50 + (200 *  _av.getSmoothedAmplitude()); 
        // _av.box(boxSize);   
        // _av.popMatrix();
        // _angle += 0.01f;


        _av.calculateAverageAmplitude();
        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        _av.strokeWeight(5);
        _av.size(200, 200, _av.P3D);
        _av.translate(0, 0, 0); 
        _av.rotateY(0.5f);
        _av.noFill();
        _av.lights();
        _av.box(40);
    }
}

     