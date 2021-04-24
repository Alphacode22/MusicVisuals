package C19409486;

import ie.tudublin.Visual;
import processing.core.PApplet;

public class AmpWave extends MusicObject {

    
    public AmpWave(AlexVisual av){
        this._av = av;
    }

    public void start() {
   
    }

    public void update() {
       drawAmp();
    } 

    // drawp amplitude wave
    public void drawAmp(){
        //Amplitude 
        float prevX=0;
        float prevY=0;
        for(int i = 0; i < _av.getAudioBuffer().size()-1; i++){
            float temp[] = new float[_av.getAudioBuffer().size()];

            _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
        
            temp = generateLerp(_av.getAudioBuffer(), _av);

            _av.strokeWeight(1);
            _av.point(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2 * 2), 0);
            _av.point(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i+1)* _av.height/2 * 2), 0);
        
            _av.strokeWeight(2);
            _av.line(i* 3,_av.height/2 + (temp[i]* _av.height/2), 0, i* 3, _av.height/2+ (temp[i+1] *_av.height/2), 0);
        }
    }
}
