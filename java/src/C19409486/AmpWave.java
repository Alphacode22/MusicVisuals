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
        //Amplitude 
        float prevX=0;
        float prevY=0;
        for(int i = 0; i < _av.getAudioBuffer().size()-1; i++){
            float temp[] = new float[_av.getAudioBuffer().size()];

            // lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            //setLerpedBuffer() = lerp(getLerpedBuffer().get(i),  _av.getAudioBuffer().get(i), 0.1f);

            _av.stroke(PApplet.map(i, 0, _av.getAudioBuffer().size(), 0, 255), 255, 255);
          

            
            //_av.point(i* 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), 0);
            //_av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);

            temp = generateLerp(_av.getAudioBuffer(), _av);

          
            //_av.line(100, 100, 0, 200, 100, 0);
           // _av.line(i* 3,_av.height/2 + (temp[i]* _av.height/2), 0, i* 3, _av.height/2+ (temp[i] *_av.height/2), 0);
            _av.strokeWeight(1);
            _av.point(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2 * 2), 0);
            _av.point(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i+1)* _av.height/2 * 2), 0);
            //System.out.println("Co ord1 " + _av.height/2 + (temp[i]* _av.height/2) + "and Co ord 2 is " + _av.height/2+ (temp[i] *_av.height/2));
          

            _av.strokeWeight(2);
            _av.line(i* 3,_av.height/2 + (temp[i]* _av.height/2), 0, i* 3, _av.height/2+ (temp[i+1] *_av.height/2), 0);
            //_av.point(i* 3,_av.height/2 + (temp[i]* _av.height/2), 0);
           // _av.point(i* 3,_av.height/2 + (temp[i+1]* _av.height/2), 0);
            // prevX= i * 3;
            // prevY= _av.getAudioBuffer().get(i)* _av.getCy();
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






          // _av.noFill();

            // _av.point(i* 3, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()));
            // _av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);


            // _av.point(i* 3, _av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2));
            // _av.line(i * 3 , _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), prevX, prevY);

            // _av.point(i* 3, _av.height/2 + (temp[i]* _av.height/2));
            // _av.line(i * 3 , _av.getCy() + (temp[i]* _av.getCy()), prevX, prevY);

            //float x;
           // PApplet.map(i , 0,  _av.getAudioBuffer(),   0, width);  
            //_av.line(i, _av.getCy() + (_av.getAudioBuffer().get(i)* _av.getCy()), i, _av.getCy() + (_av.getAudioBuffer().get(i) * _av.getCy()));

          
            //_av.line(i* 3,_av.height/2 + (temp[i]* _av.height/2), i* 3, _av.height/2+ (temp[i] *_av.height/2));
            //_av.line(i* 3,_av.height/2 + (_av.getAudioBuffer().get(i)* _av.height/2), i* 3, _av.height/2+ (_av.getAudioBuffer().get(i) *_av.height/2));
    } 
}
