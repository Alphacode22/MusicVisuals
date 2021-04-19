package C19409486;

import processing.core.PApplet;

public class Circle {
    AlexVisual _av;
    
    public Circle(AlexVisual av){
        this._av = av;
    }

    public void start(){

    }

    public void update(){
        //Circle
        for (int i = 0; i < _av.getAudioBuffer().size(); i++) {
            //float c = PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255);
            //_av.stroke(207, 80, 58);
            //_av.stroke(c , 255, 255);
            _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
            _av.strokeWeight(2); 
            _av.fill(0,0,0);
            _av.ellipse(_av.width/2, _av.height/2, 200 + (_av.getLerpedAverage() * 500), 200 + (_av.getLerpedAverage() * 500));//50
        }
    }
}
