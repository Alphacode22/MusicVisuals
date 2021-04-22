package C19409486;

import processing.core.PApplet;

public class FreqWave extends MusicObject {
    AlexVisual _av;
    
    public FreqWave(AlexVisual av){
        this._av = av;
    }

    public void start(){

    }

    public void update(){
        drawFreqWave();
    }

    void drawFreqWave(){
          //Frequency
          for(int i=0; i < _av.getFFT().specSize(); i++){
            _av.stroke(PApplet.map(i, 0 , _av.getAudioBuffer().size(), 0 ,255), 255, 255);
            _av.strokeWeight(10);
            _av.strokeCap(PApplet.PROJECT);
            //_av.line(i* 10, _av.height, i * 10, _av.height - (_av.getFFT().getBand(i)));
            _av.line(i* 10, _av.height, i * 10, _av.height - (_av.getFFT().getBand(i) * 5));
        }
    }
}
