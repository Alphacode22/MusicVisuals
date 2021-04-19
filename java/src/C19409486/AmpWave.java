package C19409486;

import ie.tudublin.Visual;
import processing.core.PApplet;

public class AmpWave {

    AlexVisual _av;

    public AmpWave(AlexVisual av){
        this._av = av;
    }

    public void start() {
   
    }


    public void update() {
        //Amplitude //weird
        for(int i = 0; i < _av.getAudioBuffer().size(); i++){
            _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
            //line(i, halfHeight - (getAudioBuffer().get(i)* halfHeight), i, halfHeight + (getAudioBuffer().get(i) * halfHeight));
            _av.strokeWeight(1);
            //line(i, halfHeight - (getAudioBuffer().get(i)* halfHeight), i, halfHeight + (getAudioBuffer().get(i) * halfHeight));
            //line(i, halfHeight - (getAudioBuffer().get(i)* halfHeight), i, halfHeight + (getAudioBuffer().get(i) * halfHeight));
            //line(i * 10, halfHeight + (getAudioBuffer().get(i)* halfHeight), i * 10, halfHeight + (getAudioBuffer().get(i) * halfHeight));

            

            // lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);
            //line(i*2, halfHeight - lerpedBuffer[i] * halfHeight * 4, i*2, halfHeight + lerpedBuffer[i] * halfHeight * 4);
            //System.out.println("hahah");

            //line(i * 10, halfHeight + (getAudioBuffer().get(i)* halfHeight), i * 10, halfHeight + (getAudioBuffer().get(i) * halfHeight));
            //_av.line(i * 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i * 3, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));

            // _av.line(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));
            _av.point(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()));

            float x;
           // PApplet.map(i , 0,  _av.getAudioBuffer(),   0, width);  
            _av.line(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));
            _av.line(i* 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i* 3, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));
        }

    } 
}
