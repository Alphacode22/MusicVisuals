package C19409486;

import ie.tudublin.Visual;
import processing.core.PApplet;

public class AmpWave implements MusicObject {

    AlexVisual _av;

    public AmpWave(AlexVisual av){
        this._av = av;
    }

    public void start() {
   
    }

    public void update() {
        //Amplitude 
        float prevX=0;
        float prevY=0;
        for(int i = 0; i < _av.getAudioBuffer().size(); i++){
            _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
            _av.strokeWeight(1);

            // _av.point(i* 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()));
            // _av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);



            _av.point(i* 3, _av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2));
            _av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);

            //float x;
           // PApplet.map(i , 0,  _av.getAudioBuffer(),   0, width);  
            //_av.line(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));
            _av.line(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2), i* 3, _av.height/2+ (_av.getAudioBuffer().get(i) *_av.height/2));




            prevX= i * 3;
            prevY= _av.getAudioBuffer().get(i)* _av.getCy();
        }

        //  //Amplitude 
        //  float prevX=0;
        //  float prevY=0;
        //  for(int i = 0; i < _av.getAudioBuffer().size(); i++){
        //      _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
        //      _av.strokeWeight(1);
 
        //      _av.point(i* 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()));
        //      _av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);
 
 
 
        //      _av.point(i* 3, _av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2));
 
        //      //float x;
        //     // PApplet.map(i , 0,  _av.getAudioBuffer(),   0, width);  
        //      //_av.line(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));
        //      _av.line(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2), i* 3, _av.height/2+ (_av.getAudioBuffer().get(i) *_av.height/2));
 
 
 
 
        //      prevX= i * 3;
        //      prevY= _av.getAudioBuffer().get(i)* _av.getCy();
        //  }
    } 
}