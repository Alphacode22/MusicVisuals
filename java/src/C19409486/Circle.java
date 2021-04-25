package C19409486;

import processing.core.PApplet;

public class Circle extends MusicObject {
 
    
    public Circle(AlexVisual av){
        this._av = av;
    }

    public void start(){

    }
   
    public void update(){
       drawCircle();
    }

    void drawCircle(){
        //Circle
        _av.stroke(255,255,255);
        _av.strokeWeight(2); 
        _av.fill(0,0,0);
        _av.circle(_av.width/2, _av.height/2, 200 + (_av.getLerpedAverage() * 500));
    }
}
