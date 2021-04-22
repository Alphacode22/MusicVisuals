package C19409486;

import java.util.Random;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Cube extends MusicObject {
    private float _size;
    float _angle;

    public Cube(AlexVisual av, float angle, float size) {
        this._av = av;
        this._angle = angle;
        this._size = size;
    }

    public void start(){
    
    }

    public void update(){
        moveCube();
    }

    public void moveCube(){
        _av.calculateAverageAmplitude();
        _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        _av.strokeWeight(5);

        _av.pushMatrix();

        Random rng = new Random();
        int min =0;
        int heightMax = _av.height;
        int widthMax = _av.width;
       
        int randInt = rng.nextInt(heightMax - min + 1) + min;
        int randInt2 = rng.nextInt(widthMax - min + 1) + min;

        _av.camera(); 
        _av.translate(randInt, randInt2, 50); 
        _av.rotateX(_angle);
        _av.rotateZ(_angle);  

        float boxSize = 50 + (100 *  _av.getSmoothedAmplitude()); 
        _av.box(boxSize);   
        
        _av.noFill();
        _av.lights();
 
        _av.popMatrix();
        _angle += 0.01f;
    }

    // public void moveCube(){
    //     //
    //     // _av.pushMatrix();
    //     // _av.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
    //     // _av.translate(0, 0, -200);
    //     // _av.rotateX(_angle);
    //     // _av.rotateZ(_angle);       
    //     // float boxSize = 50 + (200 *  _av.getSmoothedAmplitude()); 
    //     // _av.box(boxSize);   
    //     // _av.popMatrix();
    //     // _angle += 0.01f;


    //     _av.calculateAverageAmplitude();
    //     _av.stroke(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
    //     _av.strokeWeight(5);

    //     _av.pushMatrix();
    //     _av.camera(0, 0, 0, _av.height, _av.width, -1, 0, 1, 0);
    //     //_av.size(200, 200, _av.P3D);
    //     _av.translate(200, 200, 0); 
    //     _av.rotateX(_angle);
    //     _av.rotateZ(_angle);  
    //     //_av.fill(PApplet.map( _av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
    //      float boxSize = 50 + (100 *  _av.getSmoothedAmplitude()); 
    //     _av.box(boxSize);   
    //     _av.noFill();
    //     _av.lights();
    //     //_av.box(40);
    //     _av.popMatrix();
    //     _angle += 0.01f;
    // }
}

     