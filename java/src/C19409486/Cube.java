package C19409486;

import ie.tudublin.Main;
import processing.core.PApplet;

public class Cube {

    AlexVisual av;
    float angle;

    public Cube(AlexVisual av, float angle) {
        this.av = av;
        this.angle = angle;
    }

    void update(){
      
    }

    void show(){
        av.background(0);
        av.calculateAverageAmplitude();
        av.stroke(PApplet.map( av.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        av.strokeWeight(5);
        av.noFill();
        av.lights();
        av.pushMatrix();
        //
        av.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        av.translate(0, 0, -200);
        av.rotateX(angle);
        av.rotateZ(angle);       
        float boxSize = 50 + (200 *  av.getSmoothedAmplitude()); 
        av.box(boxSize);   
        av.popMatrix();
        angle += 0.01f;
    }
}

    